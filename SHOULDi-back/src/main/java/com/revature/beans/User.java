package com.revature.beans;

import java.util.ArrayList;

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
@Inheritance(strategy=InheritanceType.JOINED)  
public class User {
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
	@Column(name="moderator")
	private boolean moderator;
	@Column(name="lock")
	private boolean lock;
	
	@OneToMany(
	        mappedBy = "User", 
	        orphanRemoval = true
	    )
	private ArrayList<Post> user_posts;
	
	@OneToMany(
	        mappedBy = "User", 
	        orphanRemoval = true
	    )
	private ArrayList<Post> viewed_posts;
	
	@OneToMany(
	        mappedBy = "User", 
	        orphanRemoval = true
	    )
	private ArrayList<Message> messages;
	
	@OneToMany(
	        mappedBy = "User", 
	        orphanRemoval = true
	    )
	private ArrayList<Message> user_comments;
	
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

	public ArrayList<Post> getUser_posts() {
		return user_posts;
	}

	public void setUser_posts(ArrayList<Post> user_posts) {
		this.user_posts = user_posts;
	}

	public ArrayList<Post> getViewed_posts() {
		return viewed_posts;
	}

	public void setViewed_posts(ArrayList<Post> viewed_posts) {
		this.viewed_posts = viewed_posts;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

	public ArrayList<Message> getUser_comments() {
		return user_comments;
	}

	public void setUser_comments(ArrayList<Message> user_comments) {
		this.user_comments = user_comments;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public User(int user_id, String username, String password, int gender, boolean moderator, boolean lock,
			ArrayList<Post> user_posts, ArrayList<Post> viewed_posts, ArrayList<Message> messages,
			ArrayList<Message> user_comments, int score) {
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

	public User() {
		super();
	}

	public User(String username, String password, int gender, boolean moderator, boolean lock,
			ArrayList<Post> user_posts, ArrayList<Post> viewed_posts, ArrayList<Message> messages,
			ArrayList<Message> user_comments, int score) {
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
