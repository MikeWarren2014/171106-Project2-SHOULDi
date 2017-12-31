package com.zenith.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.zenith.Beans.CommentBean;
import com.zenith.Beans.PostBean; 
import com.zenith.Beans.UserBean;
import com.zenith.ImageUtils.ImageConversionUtil;
import com.zenith.hibernate.utils.HibernateUtil;
import com.zenith.hibernate.utils.HibernateUtils;
import com.zenith.request.model.GenericGetModel;

import com.zenith.templates.PostTemplate;
import com.zenith.templates.UserTemplate;


/**
 *DAO layer to access database in regards to users.
 * @author Xavier Garibay and Caleb Schumake
 */

public class UserDAO {

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
     * Get score of current user
     * @param requestModel - token to identify user
     * @return - score of user
     */
    public int getUserScore(GenericGetModel requestModel){
        this.openConnection();
        UserBean user = this.getUserByToken(requestModel.getToken()); 
        this.closeConnection();
        return user.getScore(); 
    }

    /**
     * Get  user by its email
     * @param email - email to identify user
     * @return - user
     */
    public UserBean getUserByEmail(String email) {

        UserBean user = null;

        /* make sure value is not null */
        if (email == null || email.isEmpty()) {
            return null;
        }

        /* Get user based on ID */
        String hql = "From UserBean E WHERE E.email = :email";
        List users
                = session.createQuery(hql).setParameter("email", email)
                        .list();
        if (users.isEmpty()) {
            return null;
        } else {
            return (UserBean) users.get(0);
        }
    }

    /**
     * Get  user by its id
     * @param username - id to identify user
     * @return - user
     */
	public UserBean getUserById(int username) {

		/* make sure value is not null */
		UserBean userBean = null;

		CriteriaBuilder cb = session.getCriteriaBuilder();

		// create criteria against a particular persistent class
		CriteriaQuery<UserBean> criteria = cb.createQuery(UserBean.class);

		String hql = "FROM UserBean E WHERE E.user_id = " + username;
		Query query = session.createQuery(hql);
		List resultList = query.list();

		if (resultList != null && resultList.size() > 0) {
			userBean = (UserBean) resultList.get(0);

		}
		System.out.println(userBean);
		return userBean;
	}
	
    /**
     * Get  user by its token
     * @param token - token to identify user
     * @return - user
     */
    public UserBean getUserByToken(String token) {

        UserBean user = null;

        /* make sure token is not null */
        if (token == null || token.isEmpty()) {
            return null;
        }

        /* Get user based on token */
        String hql = "From UserBean E WHERE E.token = :token";
        List users
                = session.createQuery(hql).setParameter("token", token)
                        .list();
        if (users.isEmpty()) {
            return null;
        } else {
            return (UserBean) users.get(0);
        }

    }
    
    /**
     * Get all flagged users
     * @return - list of flagged users
     */
    public List<UserTemplate> getFlaggedUsers()
    {
        session.beginTransaction();
        List<String> comments = new ArrayList<String>(); 
        List<UserBean> flagged = session.createCriteria(UserBean.class).list();
        flagged = session.createCriteria(UserBean.class).add(Restrictions.eq("flag", 1)).list();
        List<UserTemplate> templates=new ArrayList<UserTemplate>();
        for(UserBean user: flagged)
        {
            templates.add(new UserTemplate(user.getUser_id(), user.getEmail(), user.getPassword(), user.getGender(), user.getRole(), user.getLock(), user.getFlag(), user.getScore(), user.getToken())); 
        }
        return templates;
    }

    /**
     * Save changes to user
     * @param user - user to save
     */
    public void saveUser(UserBean user) {

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

    }

    /**
     * Save changes to user
     * @param user - user to save
     */
    public void updateUser(UserBean user) {

        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();

    }

    /**
     * Get all users with a score of over 2000
     * @return - list of favorite users
     */
    public List<UserTemplate> getFavoriteUsers() {

        session.beginTransaction();
        Criteria criteria;

        List<UserBean> favorites = session.createCriteria(UserBean.class).list();

        favorites = session.createCriteria(UserBean.class).add(Restrictions.gt("score", 2000)).list();
        List<UserTemplate> templates= new ArrayList<UserTemplate>();
        for(UserBean user: favorites)
        {
        	templates.add(new UserTemplate(user.getUser_id(), user.getEmail(), user.getPassword(), user.getGender(), user.getRole(), user.getLock(), user.getFlag(), user.getScore(), user.getToken()));
        }
        return templates;

    }
    //change form getmodel will lock itself
    /**
     * Lock a user
     * @param - token of user
     */
	public void lockUser(GenericGetModel user) {
		UserBean lockUser = null;
		UserBean u=getUserByToken(user.getToken());
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			//lockUser = (UserBean)session.createCriteria(UserBean.class).add(Restrictions.eq("user_id", user.getUser_id())).list().get(0);
			if (u != null) {
				u.setLock(1);
				session.save(u);
				tx.commit();
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}
