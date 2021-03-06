/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.templates;

import java.util.List;
import javax.ws.rs.core.GenericEntity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wayne
 */
@XmlRootElement
public class PostTemplate {

    private int post_id;
    private String image;
    private int likes;
    private int dislikes;
    private List<String> comments;
    /* Xavier, this field is needed so we can group ads and user posts together, we have to use same object since collections 
       must hold same type 
     */
    private String url;
    private int num_clicked;
    private int num_shown;
    private int is_ad;
    private int poster_id;

    public PostTemplate() {
    }

    public PostTemplate(int post_id, int likes, String image, int dislikes, List<String> comments) {
        this.post_id = post_id;
        this.image = image;
        /* Mark it as a png */
        this.image = "data:image/png;base64," + image;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;

    }

    public PostTemplate(int num_clicked, int num_shown, String image, String url, int is_ad, int adID) {
        this.num_clicked = num_clicked;
        this.num_shown = num_shown;
        this.image = "data:image/png;base64," + image;
        this.url = url;
        this.is_ad = is_ad;
        this.post_id = adID;
    }

    public PostTemplate(int post_id, String image, int poster_id) {
        this.post_id = post_id;
        this.image = "data:image/png;base64," + image;
        this.poster_id = poster_id;
    }

    /**
     * @return the post_id
     */
    public int getPost_id() {
        return post_id;
    }

    /**
     * @param post_id the post_id to set
     */
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * @param likes the likes to set
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    /**
     * @return the dislikes
     */
    public int getDislikes() {
        return dislikes;
    }

    /**
     * @param dislikes the dislikes to set
     */
    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    /**
     * @return the comments
     */
    public List<String> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the num_clicked
     */
    public int getNum_clicked() {
        return num_clicked;
    }

    /**
     * @param num_clicked the num_clicked to set
     */
    public void setNum_clicked(int num_clicked) {
        this.num_clicked = num_clicked;
    }

    /**
     * @return the num_shown
     */
    public int getNum_shown() {
        return num_shown;
    }

    /**
     * @param num_shown the num_shown to set
     */
    public void setNum_shown(int num_shown) {
        this.num_shown = num_shown;
    }

    /**
     * @return the is_ad
     */
    public int getIs_ad() {
        return is_ad;
    }

    /**
     * @param is_ad the is_ad to set
     */
    public void setIs_ad(int is_ad) {
        this.is_ad = is_ad;
    }

    /**
     * @return the poster_id
     */
    public int getPoster_id() {
        return poster_id;
    }

    /**
     * @param poster_id the poster_id to set
     */
    public void setPoster_id(int poster_id) {
        this.poster_id = poster_id;
    }

}
