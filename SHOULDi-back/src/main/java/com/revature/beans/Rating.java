package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class Rating {
	@Id //designates as primary key
	@Column(name="RATING_ID")
	@SequenceGenerator(sequenceName="RATING_SEQ", name="RATING_SEQ")
	@GeneratedValue(generator="RATING_SEQ", strategy=GenerationType.SEQUENCE)
	private int rating_id;
	@OneToOne
	@JoinColumn(name="USER_ID")
	private int rater_id;
	@OneToOne
	@JoinColumn(name="POST_ID")
	private int post_id;
	@Column(name="LIKE")
	private boolean like;
	@Column(name="DISLIKE")
	private boolean dislike;
	@Column(name="RATING")
	private int rating;
	
	
	public int getRating_id() {
		return rating_id;
	}
	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}
	public int getRater_id() {
		return rater_id;
	}
	public void setRater_id(int rater_id) {
		this.rater_id = rater_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public boolean isLike() {
		return like;
	}
	public void setLike(boolean like) {
		this.like = like;
	}
	public boolean isDislike() {
		return dislike;
	}
	public void setDislike(boolean dislike) {
		this.dislike = dislike;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Rating(int rating_id, int rater_id, int post_id, boolean like, boolean dislike, int rating) {
		super();
		this.rating_id = rating_id;
		this.rater_id = rater_id;
		this.post_id = post_id;
		this.like = like;
		this.dislike = dislike;
		this.rating = rating;
	}
	public Rating(int rater_id, int post_id, boolean like, boolean dislike, int rating) {
		super();
		this.rater_id = rater_id;
		this.post_id = post_id;
		this.like = like;
		this.dislike = dislike;
		this.rating = rating;
	}
	public Rating() {
		super();
	}
	
	
	
}
