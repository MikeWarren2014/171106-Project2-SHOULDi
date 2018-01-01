package com.zenith.templates;

import java.util.List;

import com.zenith.Beans.AdvertisementBean;
import com.zenith.Beans.CommentBean;
import com.zenith.Beans.DislikeBean;
import com.zenith.Beans.LikeBean;
import com.zenith.Beans.MessageBean;
import com.zenith.Beans.PostBean;
import com.zenith.Beans.VPBean;

/**
 * Template to return user information
 * @author - Xavier Garibay and Caleb Schumake
 */
public class UserTemplate {
    private int user_id;
    private String token;
    private String email; 
    private String password;
    private String gender; 
    private String role; 
    private int lock;
    private int flag;
    private int score;
    
	/**
	 * @return - user id
	 */
    public int getUser_id() {
		return user_id;
	}
    /**
     * @param - user id to set
     */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return - token
	 */
	public String getToken() {
		return token;
	}
    /**
     * @param - token to set
     */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return - email
	 */
	public String getEmail() {
		return email;
	}
    /**
     * @param - email to set
     */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return - password
	 */
	public String getPassword() {
		return password;
	}
    /**
     * @param - password to set
     */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return - gender
	 */
	public String getGender() {
		return gender;
	}
    /**
     * @param - gender to set
     */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return - role
	 */
	public String getRole() {
		return role;
	}
    /**
     * @param - role to set
     */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return - lock
	 */
	public int getLock() {
		return lock;
	}
    /**
     * @param - lock to set
     */
	public void setLock(int lock) {
		this.lock = lock;
	}
	/**
	 * @return - flag
	 */
	public int getFlag() {
		return flag;
	}
    /**
     * @param - flag to set
     */
	public void setFlag(int flag) {
		this.flag = flag;
	}
	/**
	 * @return - score
	 */
	public int getScore() {
		return score;
	}
    /**
     * @param - score to set
     */
	public void setScore(int score) {
		this.score = score;
	}
	
	public UserTemplate(){}
    public UserTemplate(int user_id,  String email, String password, String gender, String role, int lock, int flag, int score, String token){
        this.user_id = user_id;
        this.email = email;
        this.password = password; 
        this.gender = gender;
        this.role = role; 
        this.lock = lock;
        this.flag = flag;
        this.score = score; 
        this.token = token;
      
    }
}
