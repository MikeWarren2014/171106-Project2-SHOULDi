package com.zenith.DAO;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.zenith.Beans.AdvertisementBean;
import com.zenith.Beans.CommentBean;
import com.zenith.Beans.DislikeBean;
import com.zenith.Beans.LikeBean;
import com.zenith.Beans.PostBean;
import com.zenith.Beans.UserBean;
import com.zenith.Beans.VPBean;
import com.zenith.ImageUtils.ImageConversionUtil;
import com.zenith.hibernate.utils.HibernateUtils;
import com.zenith.request.model.AdPostModel;
import com.zenith.request.model.FlagPostModel;
import com.zenith.request.model.GenderedGetModel;
import com.zenith.request.model.GenericGetModel;
import com.zenith.request.model.PostComp;
import com.zenith.request.model.PostModel;
import com.zenith.request.model.RatingModel;
import com.zenith.request.model.UserGetModel;
import com.zenith.service.UserServiceImpl;
import com.google.gson.Gson;
import com.zenith.Beans.AdvertisementBean;
import java.sql.Blob;
import com.zenith.ImageUtils.ImageConversionUtil;
import com.zenith.interfaces.UserService;
import com.zenith.request.model.ViewedAdModel;
import com.zenith.service.PostsService;
import com.zenith.templates.AdPostTemplate;
import com.zenith.templates.PostTemplate;
import java.util.Random;

/**
 *DAO layer to access database in regards to posts.
 * @author Xavier Garibay and Caleb Schumake
 */
public class PostDAO {

    Session session = null;

    public void openConnection() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public void closeConnection() {
        if (session != null) {
            session.close();
        }
    }
    
    /**
     * Score a single post
     * @param rating - post to be scored and token
     */
    public void finalize(RatingModel rating) {
        session.beginTransaction();
        String hql = "From PostBean E WHERE E.post_id = :_id";
        List posts
                = session.createQuery(hql).setParameter("_id", rating.getPost_id())
                        .list();
        PostBean postBean = (PostBean) posts.get(0);
        postBean.setCompleted(1);
        List<LikeBean> likes = postBean.getLikes();
        List<DislikeBean> dislikes = postBean.getDislikes();
        List<Integer> ids = new ArrayList<Integer>();
        int flag = 0;
        if (likes.size() > dislikes.size()) {//if more likes than dislikes give points to likers
            flag = 1;
            for (LikeBean like : likes) {
                ids.add(like.getUser().getUser_id());
            }
        } else if (likes.size() < dislikes.size()) {//if more dislikes than likes give points to likers
            flag = 1;
            for (DislikeBean dislike : dislikes) {
                ids.add(dislike.getUser().getUser_id());
            }
        }

        /* Get users by their id */
        if (flag == 1) {
            hql = "From UserBean";
            List users = session.createQuery(hql).list();
            int score = 0;
            UserBean temp = null;
            for (Object user : users) {
                for (Integer id : ids) {
                    temp = (UserBean) user;
                    if (temp.getUser_id() == id) {
                        score = temp.getScore() + 1;
                        temp.setScore(score);
                        session.update(temp);
                    }
                }
            }
            session.update(postBean);

            session.getTransaction().commit();
        }

    }
    
    /**
     * Update advertisement's statistics after being shown
     * @param - token, ad id, and whether clicked or not
     */
    public void updateAd(ViewedAdModel viewedAdModel) {

        /* Get post based on ID */
        String hql = "From AdvertisementBean E WHERE E.ad_id = :_id";
        List posts
                = session.createQuery(hql).setParameter("_id", viewedAdModel.getPost_id())
                        .list();
        if (!posts.isEmpty()) {
            session.getTransaction().begin();
            AdvertisementBean adBean = (AdvertisementBean) posts.get(0);
            int numShown = adBean.getNum_shown() + 1;
            int wasClicked = adBean.getNum_clicked() + viewedAdModel.getClicked();
            adBean.setNum_clicked(wasClicked);
            adBean.setNum_shown(numShown);
            session.update(adBean);
            session.getTransaction().commit();

        }

    }
    
    /**
     * Get a random ad to display
     * @return - random advertisement
     */
    private PostTemplate getRandomAd() {


        /* Get post based on ID */
        String hql = "From AdvertisementBean";
        List ads
                = session.createQuery(hql)
                        .list();

        // number of ads is the maximum and the 0 is our minimum 
        Random rand = new Random();
        if (ads.size() == 0) {
            return null;
        }
        int n = rand.nextInt(ads.size()) + 0;
        AdvertisementBean adBean = (AdvertisementBean) ads.get(n);

        String image = ImageConversionUtil.convertToB64(adBean.getImage());
        return new PostTemplate(adBean.getNum_clicked(), adBean.getNum_shown(), image, adBean.getAd_link(), 1, adBean.getAd_id());

    }

    /**
     * Get user's advertisements' information for review
     * @param - token to identify user
     * @return - list of advertisements and statistics
     */
    public List<AdPostTemplate> adGetMyPosts(GenericGetModel getModel) {

        String token = getModel.getToken();
        UserServiceImpl service = new UserServiceImpl();
        UserBean userBean = service.getUserByToken(token);

        /* Need to hold posts temporarily */
        List<AdvertisementBean> ads = userBean.getAds();

        /* All posts will be converted to a PostTemplate */
        List<AdPostTemplate> postTemplate = new ArrayList<AdPostTemplate>();
        String image;

        session.update(userBean);
        for (AdvertisementBean adBean : ads) {

            image = ImageConversionUtil.convertToB64(adBean.getImage());
            postTemplate.add(new AdPostTemplate(adBean.getNum_clicked(), adBean.getNum_shown(), image));

        }
        return postTemplate;
    }

    /**
     * Get user's posts' information for review
     * @param - token to identify user
     * @return - list of posts and statistics
     */
    public List<PostTemplate> getMyPosts(GenericGetModel getModel) {
        String token = getModel.getToken();
        UserServiceImpl service = new UserServiceImpl();
        UserBean userBean = service.getUserByToken(token);

        /* Need to hold posts temporarily */
        List<PostBean> temp = new ArrayList<PostBean>();
        /* All posts will be converted to a PostTemplate */
        List<PostTemplate> postTemplate = new ArrayList<PostTemplate>();
        /* Comments for every post */
        List<String> comments = new ArrayList<String>();

        /* Image needs to be converted to proper format for each post */
        String image;
        session.update(userBean);
        temp = userBean.getUser_posts();
        for (PostBean bean : temp) {
            image = ImageConversionUtil.convertToB64(bean.getImage());
            List<CommentBean> commentBean = bean.getPost_comments();
            for (CommentBean comment : commentBean) {
                comments.add(comment.getComment_text());
            }
            postTemplate.add(new PostTemplate(bean.getPost_id(), bean.getLikes().size(), image, bean.getDislikes().size(), comments));
        }
        return postTemplate;
    }

    /**
     * Get specified user's flagged posts for moderator review
     * @return - List of posts that are flagged
     */
    public List<PostTemplate> getFlaggedPosts(UserGetModel user) {

        session.beginTransaction();
        List<String> comments = new ArrayList<String>();
        List<PostBean> flagged = session.createCriteria(PostBean.class).list();
        flagged = session.createCriteria(PostBean.class).add(Restrictions.eq("flag", 1)).list();//all flagged
        List<PostTemplate> templates=new ArrayList<PostTemplate>();
        for(PostBean post: flagged)
        {
        	String image = ImageConversionUtil.convertToB64(post.getImage());
            List<CommentBean> commentBean = post.getPost_comments(); 
            for (CommentBean comment : commentBean) {
                comments.add(comment.getComment_text());
            }
            if(user.getUser()==post.getPoster().getUser_id())
            {
            	templates.add(new PostTemplate(post.getPost_id(), post.getLikes().size(), image, post.getDislikes().size(), comments)); 
            }
        }
        return templates;
    }

    public PostBean getBestEventPost(int event) {
        List<PostBean> posts = session.createCriteria(PostBean.class).list();
        posts = session.createCriteria(PostBean.class).add(Restrictions.eq("event", event)).list();
        PostBean highest = null;
        for (PostBean post : posts) {
            if (highest == null) {
                highest = post;
            } else {
                if (highest.getLikes().size() < post.getLikes().size()) {
                    highest = post;
                }
            }
        }
        return highest;

    }

    public List<PostTemplate> getHall() {
        List<PostBean> posts = session.createCriteria(PostBean.class).list();
        Collections.sort(posts, new PostComp());//sort by occasion
        List<PostBean> highest= new ArrayList<PostBean>();
        PostBean curHigh=posts.get(0);
        for(int i= 1; i<posts.size(); i++)
        {//whenever not same occasion add to list and set new highest for new occasion
        	if(!curHigh.getOccasion().equalsIgnoreCase(posts.get(i).getOccasion()))
        	{
        		highest.add(curHigh);
        		curHigh=posts.get(i);
        	}
        	else//if same occasion check if likes are higher
        	{
        		if(curHigh.getLikes().size()<posts.get(i).getLikes().size())
        			curHigh=posts.get(i);
        	}        		
        }
        List<PostTemplate> templates= new ArrayList<PostTemplate>();
        for(PostBean bean: highest)//add all highest to list to return
        {
        	templates.add(new PostTemplate(bean.getPost_id(), ImageConversionUtil.convertToB64(bean.getImage()), bean.getOccasion()));
        }
        return templates;
    }

    /**
     * Return list of posts and an advertisement to be reviewed
     * @param - token to identify user
     * @return - list of posts and an ad
     */

    public List<PostTemplate> getUnseenPost(GenericGetModel user) {

        session.beginTransaction();
        UserDAO dao = new UserDAO();
        List<PostBean> choosable = session.createCriteria(PostBean.class).list();
        choosable = session.createCriteria(PostBean.class).add(Restrictions.eq("completed", 0)).list();//all not completed
        dao.openConnection();
        UserBean viewer = dao.getUserByToken(user.getToken());
        List<VPBean> seen = viewer.getViewed_posts();
        List<PostBean> left = new ArrayList<PostBean>();
        List<PostBean> returnPosts = new ArrayList<PostBean>();
        List<PostTemplate> posts = new ArrayList<PostTemplate>();

        int viewed_post_id = 0;
        int current_user_id = viewer.getUser_id();

        if (!seen.isEmpty()) {

            for (PostBean post : choosable) {
                boolean hasViewed = false;
                for (VPBean vp : seen) {
                    viewed_post_id = vp.getViewed().getPost_id();
                    if (post.getPost_id() == vp.getViewed().getPost_id()) {
                        hasViewed = true;
                    }

                }

                if (!hasViewed) {
                    returnPosts.add(post);
                }

            }

            for (int i = 0; i < returnPosts.size(); i++) {
                if (i < 9) {
                    System.out.println("Made it!");
                    posts.add(new PostTemplate(returnPosts.get(i).getPost_id(),
                            ImageConversionUtil.convertToB64(returnPosts.get(i).getImage()),
                            returnPosts.get(i).getPoster().getUser_id()));
                }
            }

            PostTemplate model = this.getRandomAd();
            if (model != null) {
                posts.add(model);
            }

            int viewer_id = viewer.getUser_id();
            int i = 0;
            List<PostTemplate> finalReturn = new ArrayList<PostTemplate>();
            for (PostTemplate post : posts) {
                if (viewer_id != post.getPoster_id()) {
                    finalReturn.add(post);
                }
            }

            return finalReturn;

        } else {
            /* no seen posts */

            for (int i = 0; i < choosable.size(); i++) {
                if (i < 9) {
                    posts.add(new PostTemplate(choosable.get(i).getPost_id(),
                            ImageConversionUtil.convertToB64(choosable.get(i).getImage()),
                            choosable.get(i).getPoster().getUser_id()));
                }
            }

            PostTemplate model = this.getRandomAd();
            if (model != null) {
                posts.add(model);
            }

            int viewer_id = viewer.getUser_id();
            int i = 0;
            List<PostTemplate> finalReturn = new ArrayList<PostTemplate>();
            for (PostTemplate post : posts) {

                if (viewer_id != post.getPoster_id()) {
                    finalReturn.add(post);
                }

            }

            dao.closeConnection();
            return finalReturn;
        }
    }

    /**
     * Return list of posts of a single gender and an advertisement to be reviewed
     * @param - token to identify user
     * @return - list of posts and an ad
     */
    public List<PostTemplate> getUnseenPostGendered(GenderedGetModel request) {
        session.beginTransaction();
        UserDAO udao = new UserDAO();
        UserBean user = udao.getUserByToken(request.getToken());
        List<PostBean> choosable = session.createCriteria(PostBean.class).list();
        choosable = session.createCriteria(PostBean.class).add(Restrictions.eq("completed", 0)).list();//all not completed

        List<VPBean> seen = user.getViewed_posts();
        List<PostBean> left = new ArrayList<PostBean>();
        for (VPBean vp : seen) {//filter seen posts
            choosable.remove(vp.getViewed());
        }
        List<PostBean> remove = new ArrayList<PostBean>();
        for (PostBean post : choosable) {//filter to only posts of correct gender
            String postGender = post.getPoster().getGender();
            if (!request.getGender().equalsIgnoreCase(postGender)) {
                remove.add(post);
            }
        }
        for (PostBean post : remove) {
            choosable.remove(post);
        }
        List<PostTemplate> posts = new ArrayList<PostTemplate>();
        for (int i = 0; i < choosable.size(); i++) {
            if (i < 9) {
                //	posts.add(new PostTemplate(choosable.get(i).getPost_id(),  ImageConversionUtil.convertToB64( choosable.get(i).getImage())));
            }
        }
        PostBean random = choosable.get(new Random().nextInt(choosable.size()));
        return posts;
    }

    /**
     * For posts older than a week, mark as complete and score
     */
    public void checkScore() {
        List<PostBean> posts = session.createCriteria(PostBean.class).list();
        posts = session.createCriteria(PostBean.class).add(Restrictions.eq("completed", 0)).list();
        for (PostBean post : posts) {
            Date curDate = new Date(Calendar.getInstance().getTime().getTime());
            long diff = getDateDiff(curDate, post.getCreated());
            if (diff > 7) {
                score(post);
            }
        }
    }

    /**
     * Check if generally liked or disliked and award points to the winning side's voters
     * @param - post to be scored
     */
    private void score(PostBean post) {
        List<LikeBean> likes = post.getLikes();
        List<DislikeBean> dislikes = post.getDislikes();
        if (likes.size() > dislikes.size()) {
            for (LikeBean like : likes) {
                like.getUser().setScore(like.getUser().getScore() + 2);
            }
        } else if (likes.size() < dislikes.size()) {
            for (DislikeBean dislike : dislikes) {
                dislike.getUser().setScore(dislike.getUser().getScore() + 2);
            }
        }
        post.getPoster().setScore(post.getPoster().getScore() + (likes.size() / 10));
        post.setCompleted(1);
        session.save(post);
        session.getTransaction().commit();

    }

    /**
     * Get difference in days between two dates
     */
    private static long getDateDiff(Date date1, Date date2) {
        long difference = date2.getTime() - date1.getTime();
        difference = difference / 1000 / 60 / 60 / 24;//Milliseconds to days
        return difference;
    }

    /**
     * Create post in the database
     * @param - post information and token for user identification
     * @return - confirmation of creation
     */
    public boolean createPost(PostModel postModel) {

        /* Creates new post */
        UserDAO userdao = new UserDAO();
        userdao.openConnection();
        String s = postModel.getImage();
        s = s.substring(s.lastIndexOf(',') + 1);
        Blob image = ImageConversionUtil.convertToBlob(s);
        PostBean postBean = new PostBean(image, postModel.getOccasion(), userdao.getUserByToken(postModel.getToken()));
        userdao.closeConnection();
        session.beginTransaction();
        session.save(postBean);
        session.getTransaction().commit();
        return true;
    }


    public boolean createAd(AdPostModel adPostModel) {

        /* Creates new post */
        UserDAO userdao = new UserDAO();
        userdao.openConnection();

        /* Remove money from the sponsors balance based on amount to pay for ad */
        UserBean sponsor = userdao.getUserByToken(adPostModel.getToken());
        String s = adPostModel.getImage();
        s = s.substring(s.lastIndexOf(',') + 1);
        /* create ad and save both the ad and the sponsor */
        Blob image = ImageConversionUtil.convertToBlob(s);
        AdvertisementBean adBean = new AdvertisementBean(image, adPostModel.getUrl(), sponsor);

        session.beginTransaction();
        session.save(adBean);
        session.getTransaction().commit();
        userdao.closeConnection();

        this.saveNewBalance(adPostModel);

        return true;
    }

    /**
     * Remove post from database, done by moderator
     * @param post - post to be removed
     */
    public void removePost(PostBean post) {
        PostBean delPost = null;
        Transaction tx = session.getTransaction();
        try {
            tx = session.beginTransaction();
            delPost = (PostBean) session.get(PostBean.class, post);
            if (delPost != null) {
                session.delete(delPost);
                tx.commit();
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Like a post and create comment if requested
     * @param rating - user and post information
     */
    public void like(RatingModel rating) {
        PostBean post = null;
        UserServiceImpl service = new UserServiceImpl();
        UserBean rater = service.getUserByToken(rating.getToken());

        Transaction tx = session.getTransaction();
        try {
            tx = session.beginTransaction();
            post = this.getPostById(rating.getPost_id());
            if (post != null) {
                LikeBean like = new LikeBean(post.getPoster(), post);
                VPBean view = new VPBean(rater, post);
                if (!rating.getComment().equals("")) {
                    CommentBean comment = new CommentBean(post, rater, rating.getComment());
                    session.save(comment);
                }
                session.save(like);
                session.save(view);
                tx.commit();
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Dislike a post and create comment if requested
     * @param rating - user and post information
     */
    public void dislike(RatingModel rating) {
        PostBean post = null;
        UserServiceImpl service = new UserServiceImpl();
        UserBean rater = service.getUserByToken(rating.getToken());
        Transaction tx = session.getTransaction();
        try {
            tx = session.beginTransaction();
            post = this.getPostById(rating.getPost_id());
            if (post != null) {
                DislikeBean dislike = new DislikeBean(post.getPoster(), post);
                VPBean view = new VPBean(rater, post);
                if (!rating.getComment().equals("")) {
                    CommentBean comment = new CommentBean(post, rater, rating.getComment());
                    session.save(comment);
                }
                session.save(dislike);
                session.save(view);
                tx.commit();
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Flag a post to be viewed by a moderator
     * @param flagPostModel - post to be flagged and token for user verification
     * @return - confirmation of flag
     */
    public boolean flagPost(FlagPostModel flagPostModel) {

        int post_id = flagPostModel.getPostID();

        /* Get post based on ID */
        String hql = "From PostBean E WHERE E.post_id = :_id";
        List posts
                = session.createQuery(hql).setParameter("_id", post_id)
                        .list();
        if (posts.isEmpty()) {
            return false;
        } else {
            session.beginTransaction();
            PostBean postBean = (PostBean) posts.get(0);
            postBean.setFlag(1);
            UserBean user = postBean.getPoster();
            user.setFlag(1);
            session.save(user);
            session.update(postBean);
            session.getTransaction().commit();
            return true;
        }

    }

    /**
     * Change balance of a sponsor
     * @param adPostModel - amount to be changed and token for user
     */
    private void saveNewBalance(AdPostModel adPostModel) {

        UserDAO userdao = new UserDAO();
        userdao.openConnection();

        UserBean sponsor = userdao.getUserByToken(adPostModel.getToken());
        int currrentBalance = sponsor.getBalance();
        currrentBalance = currrentBalance - adPostModel.getAmountToPay();
        sponsor.setBalance(currrentBalance);

        session.beginTransaction();
        session.merge(sponsor);
        session.getTransaction().commit();
        userdao.closeConnection();

    }

    /**
     * Get a post from database by its id
     * @param id- id of desired post
     * @return - post
     */
    public PostBean getPostById(int id) {

        /* make sure value is not null */
        PostBean postBean = null;

        CriteriaBuilder cb = session.getCriteriaBuilder();

        // create criteria against a particular persistent class
        CriteriaQuery<PostBean> criteria = cb.createQuery(PostBean.class);

        String hql = "FROM PostBean E WHERE E.post_id = " + id;
        Query query = session.createQuery(hql);
        List resultList = query.list();

        if (resultList != null && resultList.size() > 0) {
            postBean = (PostBean) resultList.get(0);

        }
        return postBean;
    }
}
