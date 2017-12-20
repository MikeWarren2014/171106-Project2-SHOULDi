package com.revature.beans;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Sponsor")
@PrimaryKeyJoinColumn(name="USER_ID")
public class Sponsor extends User{
	@Column(name="EMAIL")
	private String email;
	@Column(name="BALANCE")
	private int balance;
	@OneToMany(
	        mappedBy = "Sponsor", 
	        orphanRemoval = true
	    )
	private ArrayList<Advertisement> ads;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public ArrayList<Advertisement> getAds() {
		return ads;
	}
	public void setAds(ArrayList<Advertisement> ads) {
		this.ads = ads;
	}
	public Sponsor(int user_id, String username, String password, int gender, boolean moderator, boolean lock,
			ArrayList<Post> user_posts, ArrayList<Post> viewed_posts, ArrayList<Message> messages,
			ArrayList<Message> user_comments, int score, String email, int balance, ArrayList<Advertisement> ads) {
		super(user_id, username, password, gender, moderator, lock, user_posts, viewed_posts, messages, user_comments,
				score);
		this.email = email;
		this.balance = balance;
		this.ads = ads;
	}
	public Sponsor() {
		super();
	}
	public Sponsor(String username, String password, int gender, boolean moderator, boolean lock,
			ArrayList<Post> user_posts, ArrayList<Post> viewed_posts, ArrayList<Message> messages,
			ArrayList<Message> user_comments, int score, String email, int balance, ArrayList<Advertisement> ads) {
		super(username, password, gender, moderator, lock, user_posts, viewed_posts, messages, user_comments,
				score);
		this.email = email;
		this.balance = balance;
		this.ads = ads;
	}
	
	
}
