/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.Beans;

/**
 *
 * @author calebschumake
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="User")
//@Inheritance(strategy=InheritanceType.JOINED)  
public class UserBean implements Serializable {
    
	@Id //designates as primary key
	@Column(name="user_id")
	@SequenceGenerator(sequenceName="USER_SEQ", name="USER_SEQ")
	@GeneratedValue(generator="USER_SEQ", strategy=GenerationType.SEQUENCE)
	private int user_id;
	
	@Column(name="username")
	private String username;
        
	@Column(name="password")
	private String password;
        
	@Column(name="gender")
	private int gender;
        
	@Column(name="is_moderator")
	private boolean moderator;
        
	@Column(name="locked_account")
	private boolean lock;
	
	@OneToMany(
	        mappedBy = "poster", 
	        orphanRemoval = true
	    )
	private List<PostBean> user_posts;
	
	@OneToMany(
	        mappedBy = "poster", 
	        orphanRemoval = true
	    )
	private List<PostBean> viewed_posts;
        

	@OneToMany(
	        mappedBy = "userBean", 
	        orphanRemoval = true
	    )
	private List<MessageBean> messages;
	
	@OneToMany(
	        mappedBy = "commentor", 
	        orphanRemoval = true
	    )
	private List<CommentBean> user_comments;
	
	@Column(name="score")
	private int score;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public boolean isModerator() {
		return moderator;
	}

	public void setModerator(boolean moderator) {
		this.moderator = moderator;
	}

	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}
//
	public List<PostBean> getUser_posts() {
		return user_posts;
	}

	public void setUser_posts(ArrayList<PostBean> user_posts) {
		this.user_posts = user_posts;
	}

	public List<PostBean> getViewed_posts() {
		return viewed_posts;
	}

	public void setViewed_posts(ArrayList<PostBean> viewed_posts) {
		this.viewed_posts = viewed_posts;
	}

	public List<MessageBean> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<MessageBean> messages) {
		this.messages = messages;
	}

	public List<CommentBean> getUser_comments() {
		return user_comments;
	}

	public void setUser_comments(ArrayList<CommentBean> user_comments) {
		this.user_comments = user_comments;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public UserBean(int user_id, String username, String password, int gender, boolean moderator, boolean lock,
			ArrayList<PostBean> user_posts, ArrayList<PostBean> viewed_posts, ArrayList<MessageBean> messages,
			ArrayList<CommentBean> user_comments, int score) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.moderator = moderator;
		this.lock = lock;
		this.user_posts = user_posts;
		this.viewed_posts = viewed_posts;
		this.messages = messages;
		this.user_comments = user_comments;
		this.score = score;
	}

	public UserBean() {
		super();
	}

	public UserBean(String username, String password, int gender, boolean moderator, boolean lock,
			ArrayList<PostBean> user_posts, ArrayList<PostBean> viewed_posts, ArrayList<MessageBean> messages,
			ArrayList<CommentBean> user_comments, int score) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.moderator = moderator;
		this.lock = lock;
		this.user_posts = user_posts;
		this.viewed_posts = viewed_posts;
		this.messages = messages;
		this.user_comments = user_comments;
		this.score = score;
	}


}
