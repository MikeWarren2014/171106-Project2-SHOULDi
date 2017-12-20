package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class Comment {
	@Id //designates as primary key
	@Column(name="COMMENT_ID")
	@SequenceGenerator(sequenceName="COMMENT_SEQ", name="COMMENT_SEQ")
	@GeneratedValue(generator="COMMENT_SEQ", strategy=GenerationType.SEQUENCE)
	private int comment_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
	private Post post_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commenter_id")
	private User commenter;
	
	@Column(name="COMMENT_TEXT")
	private String comment_text;

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public Post getPost_id() {
		return post_id;
	}

	public void setPost_id(Post post_id) {
		this.post_id = post_id;
	}

	public User getCommenter() {
		return commenter;
	}

	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public Comment(int comment_id, Post post_id, User commenter, String comment_text) {
		super();
		this.comment_id = comment_id;
		this.post_id = post_id;
		this.commenter = commenter;
		this.comment_text = comment_text;
	}

	public Comment(Post post_id, User commenter, String comment_text) {
		super();
		this.post_id = post_id;
		this.commenter = commenter;
		this.comment_text = comment_text;
	}

	public Comment() {
		super();
	}
	
	
	
}
