package com.revature.beans;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class Post {
	@Id //designates as primary key
	@Column(name="POST_ID")
	@SequenceGenerator(sequenceName="POST_SEQ", name="POST_SEQ")
	@GeneratedValue(generator="POST_SEQ", strategy=GenerationType.SEQUENCE)
	private int post_id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poster_id")
	private User poster;
	@OneToMany(
	        mappedBy = "Post", 
	        orphanRemoval = true
	    )
	private ArrayList<Image> images;
	@OneToMany(
	        mappedBy = "Post", 
	        orphanRemoval = true
	    )
	private ArrayList<Comment> post_comments;
	@Column(name="FLAG")
	private boolean flag;
	
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public User getPoster() {
		return poster;
	}
	public void setPoster(User poster) {
		this.poster = poster;
	}
	public ArrayList<Image> getImages() {
		return images;
	}
	public void setImages(ArrayList<Image> images) {
		this.images = images;
	}
	public ArrayList<Comment> getPost_comments() {
		return post_comments;
	}
	public void setPost_comments(ArrayList<Comment> post_comments) {
		this.post_comments = post_comments;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Post(int post_id, User poster, ArrayList<Image> images, ArrayList<Comment> post_comments, boolean flag) {
		super();
		this.post_id = post_id;
		this.poster = poster;
		this.images = images;
		this.post_comments = post_comments;
		this.flag = flag;
	}
	public Post(User poster, ArrayList<Image> images, ArrayList<Comment> post_comments, boolean flag) {
		super();
		this.poster = poster;
		this.images = images;
		this.post_comments = post_comments;
		this.flag = flag;
	}
	public Post() {
		super();
	}

}
