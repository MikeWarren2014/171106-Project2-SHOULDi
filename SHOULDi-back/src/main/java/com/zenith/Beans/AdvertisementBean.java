package com.zenith.Beans;

import java.io.Serializable;
import java.sql.Blob;
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
/**
 * Bean for advertisement. Differs from Posts in that they contain a url to click through along with the statistics on how
 * often shown and clicked on.
 * @author Caleb Schumake
 */
@Entity
@Table(name = "AdTable")
public class AdvertisementBean implements Serializable {

    @Id 
    @Column(name = "AD_ID")
    @SequenceGenerator(sequenceName = "AD_SEQ", name = "AD_SEQ")
    @GeneratedValue(generator = "AD_SEQ", strategy = GenerationType.SEQUENCE)
    private int ad_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spon_id")
    private UserBean Sponsor;

    @Column(name = "AD_LINK")
    private String ad_link;
    
    @Column(name = "IMAGE")
    private Blob image;

    @Column(name = "CLICK_THRU")
    private String num_clicked;

    @Column(name = "NUM_SHOWN")
    private String num_shown;

    /**
     * @return - id of advertisment
     */
    public int getAd_id() {
        return ad_id;
    }

    /**
     * @param ad_id - id of advertisement to set
     */
    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    /**
     * @return - sponsor of the advertisement
     */
    public UserBean getSponsor() {
        return Sponsor;
    }

    /**
     * @param Sponsor - sponsor of the advertisement to set
     */
    public void setSponsor(UserBean Sponsor) {
        this.Sponsor = Sponsor;
    }

    /**
     * @return - url of advertisement
     */
    public String getAd_link() {
        return ad_link;
    }

    /**
     * @param ad_link - url of the advertisement to set
     */
    public void setAd_link(String ad_link) {
        this.ad_link = ad_link;
    }

    public AdvertisementBean(int ad_id, UserBean spon_id, String ad_link) {
        super();
        this.ad_id = ad_id;
        this.Sponsor = spon_id;
        this.ad_link = ad_link;
    }

    public AdvertisementBean(UserBean spon_id, String ad_link) {
        super();
        this.Sponsor = spon_id;
        this.ad_link = ad_link;
    }
    
    public AdvertisementBean(Blob image, String url, UserBean sponsor) {
        
        this.ad_link = url;
        this.image = image;
        this.Sponsor = sponsor;
        
    }

    public AdvertisementBean() {
        super();
    }

}
