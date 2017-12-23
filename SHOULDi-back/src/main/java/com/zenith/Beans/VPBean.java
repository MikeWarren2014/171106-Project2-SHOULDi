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
@Table(name="Viewed_Posts")
public class VPBean {

	@Id //designates as primary key
	@Column(name="VP_ID")
	@SequenceGenerator(sequenceName="VP_SEQ", name="VP_SEQ")
	@GeneratedValue(generator="VP_SEQ", strategy=GenerationType.SEQUENCE)
	private int vp_id;
	
	@ManyToOne
    @JoinColumn(name="user_id")
	private UserBean viewer;
	 
	@ManyToOne
    @JoinColumn(name="post_id")
	private PostBean viewed;
}
