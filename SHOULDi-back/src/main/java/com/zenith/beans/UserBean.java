package com.zenith.beans;


import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class UserBean {
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
	@Column(name="sponsor")
	private boolean sponsor;
	@Column(name="lock")
	private boolean lock;
	@OneToMany
	@JoinColumn(name="viewed_posts")
	private ArrayList<Integer> viewed_posts;
	@OneToMany
	@JoinColumn(name="message_ids")
	private ArrayList<Integer> message_ids;
	@Column(name="score")
	private int score;
	
	
	
	public UserBean() {
		super();
	}
	public UserBean(String username, String password, int gender, boolean moderator, boolean sponsor, boolean lock,
			ArrayList<Integer> viewed_posts, ArrayList<Integer> message_ids, int score) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.moderator = moderator;
		this.sponsor = sponsor;
		this.lock = lock;
		this.viewed_posts = viewed_posts;
		this.message_ids = message_ids;
		this.score = score;
	}
	public UserBean(int user_id, String username, String password, int gender, boolean moderator, boolean sponsor,
			boolean lock, ArrayList<Integer> viewed_posts, ArrayList<Integer> message_ids, int score) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.moderator = moderator;
		this.sponsor = sponsor;
		this.lock = lock;
		this.viewed_posts = viewed_posts;
		this.message_ids = message_ids;
		this.score = score;
	}
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
	public boolean isSponsor() {
		return sponsor;
	}
	public void setSponsor(boolean sponsor) {
		this.sponsor = sponsor;
	}
	public boolean isLock() {
		return lock;
	}
	public void setLock(boolean lock) {
		this.lock = lock;
	}
	public ArrayList<Integer> getViewed() {
		return viewed_posts;
	}
	public void setViewed(ArrayList<Integer> viewed) {
		this.viewed_posts = viewed;
	}
	public ArrayList<Integer> getMessage_ids() {
		return message_ids;
	}
	public void setMessage_ids(ArrayList<Integer> message_ids) {
		this.message_ids = message_ids;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}