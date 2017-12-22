/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity 
@Table(name="Posts")
public class PostBean implements Serializable {
    
	@Id //designates as primary key
	@Column(name="POST_ID")
	@SequenceGenerator(sequenceName="POST_SEQ", name="POST_SEQ")
	@GeneratedValue(generator="POST_SEQ", strategy=GenerationType.SEQUENCE)
	private int post_id;
        
	@ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "poster_id")
	private UserBean poster;
        
	@OneToMany(
	        mappedBy = "postBean", 
	        orphanRemoval = true
	    )
	private List<ImageBean> images; 
        
        @ManyToOne
        @JoinColumn(name="user_id")
        UserBean userBean; 
        
        @ManyToOne
        @JoinColumn(name="user_id")
        UserBean User;
        
	@OneToMany(
	        mappedBy = "postBean", 
	        orphanRemoval = true
	    )
	private List<CommentBean> post_comments;
        
	@Column(name="FLAG")
	private boolean flag;
	
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public UserBean getPoster() {
		return poster;
	}
	public void setPoster(UserBean poster) {
		this.poster = poster;
	}
	public List<ImageBean> getImages() {
		return images;
	}
	public void setImages(ArrayList<ImageBean> images) {
		this.images = images;
	}
	public List<CommentBean> getPost_comments() {
		return post_comments;
	}
	public void setPost_comments(ArrayList<CommentBean> post_comments) {
		this.post_comments = post_comments;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public PostBean(int post_id, UserBean poster, ArrayList<ImageBean> images, ArrayList<CommentBean> post_comments, boolean flag) {
		super();
		this.post_id = post_id;
		this.poster = poster;
		this.images = images;
		this.post_comments = post_comments;
		this.flag = flag;
	}
	public PostBean(UserBean poster, ArrayList<ImageBean> images, ArrayList<CommentBean> post_comments, boolean flag) {
		super();
		this.poster = poster;
		this.images = images;
		this.post_comments = post_comments;
		this.flag = flag;
	}
	public PostBean() {
		super();
	}

}