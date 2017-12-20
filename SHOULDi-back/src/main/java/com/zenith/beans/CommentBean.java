/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.beans;


public class CommentBean {
	private int comment_id;
	private int post_id;
	private int commenter_id;
	public int getCommenter_id() {
		return commenter_id;
	}
	public void setCommenter_id(int commenter_id) {
		this.commenter_id = commenter_id;
	}
	private String comment_text;
	private boolean flag;
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public CommentBean(int comment_id, int post_id,int commenter_id, String comment_text, boolean flag) {
		super();
		this.comment_id = comment_id;
		this.commenter_id = commenter_id;
		this.post_id = post_id;
		this.comment_text = comment_text;
		this.flag = flag;
	}
	public CommentBean(int post_id, String comment_text,int commenter_id, boolean flag) {
		super();
		this.post_id = post_id;
		this.commenter_id = commenter_id;
		this.comment_text = comment_text;
		this.flag = flag;
	}
	public CommentBean() {
		super();
	}
	
	
	
}
