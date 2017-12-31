package com.zenith.test;

import java.util.List;

import org.hibernate.Session;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zenith.Beans.CommentBean;
import com.zenith.Beans.PostBean;
import com.zenith.Beans.UserBean;
import com.zenith.DAO.CommentDAO;
import com.zenith.DAO.PostDAO;
import com.zenith.DAO.UserDAO;
import com.zenith.request.model.CommentModel;
import com.zenith.templates.CommentTemplate;

public class JCommentDaoTest {
	Session session=null;
	PostDAO pdao=new PostDAO();
	UserDAO udao= new UserDAO();
	CommentDAO cdao= new CommentDAO();
	
	  @BeforeTest
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
	    	CommentBean comment= new CommentBean();
	    	comment.setIsFlagged(1);
	    	comment.setComment_id(-3);
	    	comment.setCommentor(user);
	    	session.save(comment);
	    	session.getTransaction().commit();
	    }

	    @AfterTest
	    public void afterTest() {
	    	CommentBean comment= udao.getUserById(-3).getUser_comments().get(0);
	    	session.delete(comment);
	    	UserBean user=udao.getUserById(-3);
	    	session.delete(user);
	    	PostBean post=pdao.getPostById(-3);
	    	session.delete(post);
	    	session.getTransaction().commit();
	    }
	    
	    @Test
	    public void getFlaggedCommentsTest()
	    {
	    	session.beginTransaction();
	    	List<CommentTemplate> comments= cdao.getFlaggedComments();
	    	boolean found=false;
	    	for(CommentTemplate comment:comments)
	    	{
	    		if(comment.getPost()==-3)
	    		{
	    			found=true;
	    			break;
	    		}
	    	}
	    	Assert.assertTrue(found);
	    }
	    
	    @Test
	    public void flagCommentTest()
	    {
	    	CommentModel flag= new CommentModel();
	    	flag.setCommentID(-3);
	    	flag.setToken("iii");
	    	session.beginTransaction();
	    	CommentBean comment= cdao.getCommentById(-3);
	    	comment.setIsFlagged(1);
	    	session.save(comment);
	    	session.getTransaction().commit();
	    	cdao.flagComment(flag);
	    	comment=cdao.getCommentById(-3);
	    	Assert.assertEquals(comment.getIsFlagged(),1);
	    }
}
