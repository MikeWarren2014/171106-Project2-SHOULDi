package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class Advertisement {
	@Id //designates as primary key
	@Column(name="AD_ID")
	@SequenceGenerator(sequenceName="AD_SEQ", name="AD_SEQ")
	@GeneratedValue(generator="AD_SEQ", strategy=GenerationType.SEQUENCE)
	private int ad_id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spon_id")
	private Sponsor spon_id;
	@OneToOne
	@JoinColumn(name="IMAGE_ID")
	private Image image;
	@Column(name="AD_LINK")
	private String ad_link;
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public Sponsor getSpon_id() {
		return spon_id;
	}
	public void setSpon_id(Sponsor spon_id) {
		this.spon_id = spon_id;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getAd_link() {
		return ad_link;
	}
	public void setAd_link(String ad_link) {
		this.ad_link = ad_link;
	}
	public Advertisement(int ad_id, Sponsor spon_id, Image image, String ad_link) {
		super();
		this.ad_id = ad_id;
		this.spon_id = spon_id;
		this.image = image;
		this.ad_link = ad_link;
	}
	public Advertisement(Sponsor spon_id, Image image, String ad_link) {
		super();
		this.spon_id = spon_id;
		this.image = image;
		this.ad_link = ad_link;
	}
	public Advertisement() {
		super();
	}
	
	
	
}
