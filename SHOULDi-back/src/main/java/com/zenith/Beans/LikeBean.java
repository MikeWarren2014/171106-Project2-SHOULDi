package com.zenith.Beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Likes")
public class LikeBean {

	@Id //designates as primary key
	@Column(name="LIKE_ID")
	@SequenceGenerator(sequenceName="LIKE_SEQ", name="LIKE_SEQ")
	@GeneratedValue(generator="LIKE_SEQ", strategy=GenerationType.SEQUENCE)
	private int like_id;
	
	@ManyToOne
    @JoinColumn(name="user_id")
	private UserBean user;
	 
	@ManyToOne
    @JoinColumn(name="post_id")
	private PostBean post;
}
