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
@Table(name="Dislikes")
public class DislikeBean {

	@Id //designates as primary key
	@Column(name="DISLIKE_ID")
	@SequenceGenerator(sequenceName="DISLIKE_SEQ", name="DISLIKE_SEQ")
	@GeneratedValue(generator="DISLIKE_SEQ", strategy=GenerationType.SEQUENCE)
	private int dislike_id;
	
	@ManyToOne
    @JoinColumn(name="user_id")
	private UserBean user;
	 
	@ManyToOne
    @JoinColumn(name="post_id")
	private PostBean post;
}
