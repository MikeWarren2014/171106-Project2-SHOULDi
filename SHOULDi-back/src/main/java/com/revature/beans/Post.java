package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class Post {
	@Id //designates as primary key
	@Column(name="POST_ID")
	@SequenceGenerator(sequenceName="POST_SEQ", name="POST_SEQ")
	@GeneratedValue(generator="POST_SEQ", strategy=GenerationType.SEQUENCE)
	private int post_id;
	@OneToOne
	@JoinColumn(name="USER_ID")
	private int poster_id;
	@OneToOne
	@JoinColumn(name="IMAGE_ID")
	private int image_id;
	@Column(name="FLAG")
	private boolean flag;
	
	
	
	public Post() {
		super();
	}
	public Post(int poster_id, int image_id, boolean flag) {
		super();
		this.poster_id = poster_id;
		this.image_id = image_id;
		this.flag = flag;
	}
	public Post(int post_id, int poster_id, int image_id, boolean flag) {
		super();
		this.post_id = post_id;
		this.poster_id = poster_id;
		this.image_id = image_id;
		this.flag = flag;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getPoster_id() {
		return poster_id;
	}
	public void setPoster_id(int poster_id) {
		this.poster_id = poster_id;
	}
	public int getImage_id() {
		return image_id;
	}
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
