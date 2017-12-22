/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

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
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rater_id")
	private UserBean rater_id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
	private PostBean post;
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
	public UserBean getRater_id() {
		return rater_id;
	}
	public void setRater_id(UserBean rater_id) {
		this.rater_id = rater_id;
	}
	public PostBean getPost() {
		return post;
	}
	public void setPost(PostBean post) {
		this.post = post;
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
	public RatingBean(int rating_id, UserBean rater_id, PostBean post, boolean like, boolean dislike, int rating) {
		super();
		this.rating_id = rating_id;
		this.rater_id = rater_id;
		this.post = post;
		this.like = like;
		this.dislike = dislike;
		this.rating = rating;
	}
	public RatingBean(UserBean rater_id, PostBean post, boolean like, boolean dislike, int rating) {
		super();
		this.rater_id = rater_id;
		this.post = post;
		this.like = like;
		this.dislike = dislike;
		this.rating = rating;
	}
	public RatingBean() {
		super();
	}
	
	
}