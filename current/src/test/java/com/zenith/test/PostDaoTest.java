package com.zenith.test;

import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import com.zenith.Beans.DislikeBean;
import com.zenith.Beans.LikeBean;
import com.zenith.Beans.PostBean;
import com.zenith.Beans.UserBean;
import com.zenith.Beans.VPBean;
import com.zenith.DAO.PostDAO;
import com.zenith.DAO.UserDAO;
import com.zenith.request.model.FlagPostModel;
import com.zenith.request.model.GenericGetModel;
import com.zenith.request.model.RatingModel;
import com.zenith.templates.PostTemplate;

public class PostDaoTest {
	Session session=null;
	PostDAO pdao=new PostDAO();
	UserDAO udao= new UserDAO();
	
	  @Before
	    public void beforeTest() {
	    	session.beginTransaction();
	    	UserBean user= new UserBean();
	    	user.setUser_id(-3);
	    	user.setToken("iii");
	    	user.setUsername("test");
	    	user.setPassword("test");
	    	user.setScore(6000);
	    	user.setGender("male");
	    	session.save(user);
	    	PostBean post= new PostBean();
	    	post.setPost_id(-3);
	    	post.setOccasion("test");
	    	post.setPoster(user);
	    	post.setFlag(1);
	    	session.getTransaction().commit();
	    }

	    @After
	    public void afterTest() {
	    	UserBean user=udao.getUserById(-3);
	    	session.delete(user);
	    	PostBean post=pdao.getPostById(-3);
	    	session.delete(post);
	    	session.getTransaction().commit();
	    }
	    
	    @Test
	    public void getUnseenPostsTest()
	    {
		    GenericGetModel get= new GenericGetModel();
		    get.setToken("iii");
	    	session.beginTransaction();
	    	List<PostTemplate> posts= pdao.getUnseenPost(get);
	    	boolean found=false;
	    	for(PostTemplate post:posts)
	    	{
	    		if(post.getPost_id()==-3)
	    		{
	    			found=true;
	    			break;
	    		}
	    	}
	    	Assert.assertTrue(found);
	    }
	    
	    @Test
	    public void getHallTest()
	    {
	    	session.beginTransaction();
	    	List<PostTemplate> posts= pdao.getHall();
	    	boolean found=false;
	    	for(PostTemplate post:posts)
	    	{
	    		if(post.getPost_id()==-3)
	    		{
	    			found=true;
	    			break;
	    		}
	    	}
	    	Assert.assertTrue(found);
	    }
	    
	    @Test
	    public void getMyPostsTest()
	    {
		    GenericGetModel get= new GenericGetModel();
		    get.setToken("iii");
	    	session.beginTransaction();
	    	List<PostTemplate> posts= pdao.getMyPosts(get);
	    	boolean found=false;
	    	for(PostTemplate post:posts)
	    	{
	    		if(post.getPost_id()==-3)
	    		{
	    			found=true;
	    			break;
	    		}
	    	}
	    	Assert.assertTrue(found);
	    }
	    
	    @Test
	    public void flagPostTest()
	    {
	    	FlagPostModel flag= new FlagPostModel();
	    	flag.setPostID(-3);
	    	flag.setToken("iii");
	    	session.beginTransaction();
	    	PostBean post= pdao.getPostById(-3);
	    	post.setFlag(0);
	    	session.save(post);
	    	session.getTransaction().commit();
	    	pdao.flagPost(flag);
	    	post=pdao.getPostById(-3);
	    	Assert.assertEquals(post.getFlag(),1);
	    } 
	    
	    @Test
	    public void likeTest()
	    {
	    	session.beginTransaction();
	    	RatingModel rating= new RatingModel();
	    	rating.setPost_id(-3);
	    	rating.setToken("iii");
	    	rating.setComment("");
	    	pdao.like(rating);
	    	UserBean user= udao.getUserById(-3);
	    	Assert.assertEquals(user.getLikes().size(), 1);
	    	VPBean vp=udao.getUserById(-3).getViewed_posts().get(0);
	    	LikeBean like=udao.getUserById(-3).getLikes().get(0);
	    	session.delete(vp);
	    	session.delete(like);
	    	session.getTransaction().commit();
	    } 
	    
	    @Test
	    public void dislikeTest()
	    {
	    	session.beginTransaction();
	    	RatingModel rating= new RatingModel();
	    	rating.setPost_id(-3);
	    	rating.setToken("iii");
	    	rating.setComment("");
	    	pdao.dislike(rating);
	    	UserBean user= udao.getUserById(-3);
	    	Assert.assertEquals(user.getDislikes().size(), 1);
	    	VPBean vp=udao.getUserById(-3).getViewed_posts().get(0);
	    	DislikeBean dislike=udao.getUserById(-3).getDislikes().get(0);
	    	session.delete(vp);
	    	session.delete(dislike);
	    	session.getTransaction().commit();
	    }    
}