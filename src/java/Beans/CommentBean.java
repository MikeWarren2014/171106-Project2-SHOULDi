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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Comments")
public class CommentBean implements Serializable {
	@Id //designates as primary key
	@Column(name="COMMENT_ID")
	@SequenceGenerator(sequenceName="COMMENT_SEQ", name="COMMENT_SEQ")
	@GeneratedValue(generator="COMMENT_SEQ", strategy=GenerationType.SEQUENCE)
	private int comment_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "post_id")
	private PostBean post_id;
        
        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserBean userBean; 
	
	@ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "commenter_id")
	private UserBean commenter;
        
        @ManyToOne
        @JoinColumn(name="COMMENT_ID")
        PostBean postBean;
	
	@Column(name="COMMENT_TEXT")
	private String comment_text;

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public PostBean getPost_id() {
		return post_id;
	}

	public void setPost_id(PostBean post_id) {
		this.post_id = post_id;
	}

	public UserBean getCommenter() {
		return commenter;
	}

	public void setCommenter(UserBean commenter) {
		this.commenter = commenter;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public CommentBean(int comment_id, PostBean post_id, UserBean commenter, String comment_text) {
		super();
		this.comment_id = comment_id;
		this.post_id = post_id;
		this.commenter = commenter;
		this.comment_text = comment_text;
	}

	public CommentBean(PostBean post_id, UserBean commenter, String comment_text) {
		super();
		this.post_id = post_id;
		this.commenter = commenter;
		this.comment_text = comment_text;
	}

	public CommentBean() {
		super();
	}
	
	
	
}