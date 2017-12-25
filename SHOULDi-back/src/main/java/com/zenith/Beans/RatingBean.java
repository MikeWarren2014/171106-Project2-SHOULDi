/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.Beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity 
@Table(name="Ratings")
public class RatingBean implements Serializable {
	@Id //designates as primary key
	@Column(name="RATING_ID")
	@SequenceGenerator(sequenceName="RATING_SEQ", name="RATING_SEQ")
	@GeneratedValue(generator="RATING_SEQ", strategy=GenerationType.SEQUENCE)
	private int rating_id;
        
        /* Rating does not need to be linked with users (I think) */ 
	@ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
	private UserBean rater;
        
	@ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "post_id")
	private PostBean post;
        
	@Column(name="LIKES")
	private int like;
        
	@Column(name="DISLIKES")
	private int dislike;
        
	@Column(name="RATING_")
	private int rating;
        
	public int getRating_id() {
		return rating_id;
	}
	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}
	public UserBean getRater() {
		return rater;
	}
	public void setRater_id(UserBean rater) {
		this.rater = rater;
	}
	public PostBean getPost() {
		return post;
	}
	public void setPost(PostBean post) {
		this.post = post;
	}
	public int isLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int isDislike() {
		return dislike;
	}
	public void setDislike(int dislike) {
		this.dislike = dislike;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public RatingBean(int rating_id, PostBean post, UserBean rater,  int like, int dislike, int rating) {
		super();
		this.rating_id = rating_id;
		this.rater = rater;
		this.post = post;
		this.like = like;
		this.dislike = dislike;
		this.rating = rating;
	}
	public RatingBean(PostBean post, UserBean rater, int like, int dislike, int rating) {
		super();
		this.rater = rater;
		this.post = post;
		this.like = like;
		this.dislike = dislike;
		this.rating = rating;
	}
	public RatingBean() {
		super();
	}
	
	
}