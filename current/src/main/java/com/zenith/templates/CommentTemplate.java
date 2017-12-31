package com.zenith.templates;

public class CommentTemplate {
	private int user;
	private int post;
	private String content;
	
	public CommentTemplate(int user, int post, String content) {
		super();
		this.user = user;
		this.post = post;
		this.content = content;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getPost() {
		return post;
	}
	public void setPost(int post) {
		this.post = post;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
