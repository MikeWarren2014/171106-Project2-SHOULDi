package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class Advertisement {
	@Id //designates as primary key
	@Column(name="AD_ID")
	@SequenceGenerator(sequenceName="AD_SEQ", name="AD_SEQ")
	@GeneratedValue(generator="AD_SEQ", strategy=GenerationType.SEQUENCE)
	private int ad_id;
	@OneToOne
	@JoinColumn(name="USER_ID")
	private int spon_id;
	@OneToOne
	@JoinColumn(name="IMAGE_ID")
	private int image_id;
	@Column(name="AD_LINK")
	private String ad_link;
	
	
	
	public Advertisement() {
		super();
	}
	public Advertisement(int spon_id, int image_id, String ad_link) {
		super();
		this.spon_id = spon_id;
		this.image_id = image_id;
		this.ad_link = ad_link;
	}
	public Advertisement(int ad_id, int spon_id, int image_id, String ad_link) {
		super();
		this.ad_id = ad_id;
		this.spon_id = spon_id;
		this.image_id = image_id;
		this.ad_link = ad_link;
	}
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public int getSpon_id() {
		return spon_id;
	}
	public void setSpon_id(int spon_id) {
		this.spon_id = spon_id;
	}
	public int getImage_id() {
		return image_id;
	}
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	public String getAd_link() {
		return ad_link;
	}
	public void setAd_link(String ad_link) {
		this.ad_link = ad_link;
	}
	
}
