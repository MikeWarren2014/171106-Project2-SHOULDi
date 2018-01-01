package com.zenith.test;



import java.util.List;

import org.hibernate.Session;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zenith.Beans.UserBean;
import com.zenith.DAO.UserDAO;
import com.zenith.request.model.GenericGetModel;
import com.zenith.templates.UserTemplate;


public class JUserDaoTest {
	Session session = null;
	UserDAO udao=new UserDAO();

    
    @BeforeTest
    public void beforeTest() {
    	session.beginTransaction();
    	UserBean user= new UserBean();
    	user.setUser_id(-3);
    	user.setToken("iii");
    	user.setUsername("test");
    	user.setPassword("test");
    	user.setScore(6000);
    	session.save(user);
    	session.getTransaction().commit();
    }

    @AfterTest
    public void afterTest() {
    	UserBean user=udao.getUserById(-3);
    	session.delete(user);
    	session.getTransaction().commit();
    }
    
    @Test
    public void GetByTokenTest() {
	    GenericGetModel get= new GenericGetModel();
	    get.setToken("iii");
	    UserBean user= udao.getUserByToken("iii");
	    Assert.assertEquals(user.getUser_id(),3);    
    }
    
    @Test
    public void GetByIdTest() {
	    GenericGetModel get= new GenericGetModel();
	    get.setToken("iii");
	    UserBean user= udao.getUserById(-3);
	    Assert.assertEquals(user.getUser_id(),3);    
    }
    @Test
    public void GetScoreTest() {
	    GenericGetModel get= new GenericGetModel();
	    get.setToken("iii");
	    int score= udao.getUserScore(get);
	    Assert.assertEquals(score,6000);    
    }
    
    @Test
    public void GetFlaggedUserTest() {
	    GenericGetModel get= new GenericGetModel();
	    get.setToken("iii");
	    List<UserTemplate> flagged= udao.getFlaggedUsers();
	    boolean found=false;
	    for(UserTemplate user: flagged)
	    {
	    	if(user.getUser_id()==-3) {
	    		found=true;
	    		break;
	    	}
	    }
	    Assert.assertTrue(found);    
    }
    @Test
    public void GetFavoriteUserTest() {
	    GenericGetModel get= new GenericGetModel();
	    get.setToken("iii");
	    List<UserTemplate> favorites= udao.getFavoriteUsers();
	    boolean found=false;
	    for(UserTemplate user: favorites)
	    {
	    	if(user.getUser_id()==-3) {
	    		found=true;
	    		break;
	    	}
	    }
	    Assert.assertTrue(found);    
    }
    
    @Test
    public void lockUserTest() {
	    GenericGetModel get= new GenericGetModel();
	    get.setToken("iii");
	    udao.lockUser(get);
	    UserBean user= udao.getUserByToken("iii");
	    Assert.assertEquals(user.getLock(),1);    
    }
}
