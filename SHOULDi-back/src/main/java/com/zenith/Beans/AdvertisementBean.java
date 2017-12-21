/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.Beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AdTable")
public class AdvertisementBean implements Serializable  {
    
	@Id //designates as primary key
	@Column(name="AD_ID")
	@SequenceGenerator(sequenceName="AD_SEQ", name="AD_SEQ")
	@GeneratedValue(generator="AD_SEQ", strategy=GenerationType.SEQUENCE)
	private int ad_id;
        
	@ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "spon_id")
	private SponsorBean Sponsor;
        
	@OneToOne
	@JoinColumn(name="IMAGE_ID")
	private ImageBean image;
        
	@Column(name="AD_LINK")
	private String ad_link;
        
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public SponsorBean getSponsor() {
		return Sponsor;
	}
	public void setSponsor(SponsorBean Sponsor) {
		this.Sponsor = Sponsor;
	}
	public ImageBean getImage() {
		return image;
	}
	public void setImage(ImageBean image) {
		this.image = image;
	}
	public String getAd_link() {
		return ad_link;
	}
	public void setAd_link(String ad_link) {
		this.ad_link = ad_link;
	}
	public AdvertisementBean(int ad_id, SponsorBean spon_id, ImageBean image, String ad_link) {
		super();
		this.ad_id = ad_id;
		this.Sponsor = spon_id;
		this.image = image;
		this.ad_link = ad_link;
	}
	public AdvertisementBean(SponsorBean spon_id, ImageBean image, String ad_link) {
		super();
		this.Sponsor = spon_id;
		this.image = image;
		this.ad_link = ad_link;
	}
	public AdvertisementBean() {
		super();
	}
	
	
	
}