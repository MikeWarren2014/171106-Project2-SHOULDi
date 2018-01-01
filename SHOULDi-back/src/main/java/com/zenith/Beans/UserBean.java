/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.Beans;

/**
 *
 * @author Caleb Schumake
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "SIUser")
@XmlRootElement
public class UserBean implements Serializable {

    /**
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * @return the ads
     */
    public List<AdvertisementBean> getAds() {
        return ads;
    }

    /**
     * @param ads the ads to set
     */
    public void setAds(List<AdvertisementBean> ads) {
        this.ads = ads;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @Column(name = "user_id")
    @SequenceGenerator(sequenceName = "USER_SEQ", name = "USER_SEQ")
    @GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.SEQUENCE)
    private int user_id;

    @Column(name = "email")
    private String email;
    
    @Column(name = "BALANCE")
    private int balance;
    
    @Column(name="token")
    private String token; 

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;
    
    @Column(name="role")
    private String role; 

    @Column(name = "locked_account")
    private int lock;

    @OneToMany(
            mappedBy = "poster",
            orphanRemoval = true
    )
    private List<PostBean> user_posts;
    
        @OneToMany(
            mappedBy = "Sponsor",
            orphanRemoval = true
    )
    private List<AdvertisementBean> ads;

    @OneToMany(
            mappedBy = "viewer",
            orphanRemoval = true
    )
    private List<VPBean> viewed_posts;

    @OneToMany(
            mappedBy = "userBean",
            orphanRemoval = true
    )
    private List<MessageBean> messages;

    @OneToMany(
            mappedBy = "commentor",
            orphanRemoval = true
    )
    private List<CommentBean> user_comments;

    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true
    )
    private List<LikeBean> likes;

    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true
    )
    private List<DislikeBean> dislikes;

    @Column(name = "score")
    private int score;

    /**
     * @return - id of the user
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id - id of the user to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return - username of the user
     */
    public String getUsername() {
        return getEmail();
    }

    /**
     * @param username - username of the user to set
     */
    public void setUsername(String username) {
        this.setEmail(username);
    }

    /**
     * @return - password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password - password of the user to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return - gender of the user
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender - gender of the user to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return - whether or not user is locked
     */
    public int isLock() {
        return getLock();
    }

    /**
     * @param lock - set whether the user is locked or not
     */
    public void setLock(int lock) {
        this.lock = lock;
    }

    /**
     * @return - posts the user has created
     */
    public List<PostBean> getUser_posts() {
        return user_posts;
    }

    /**
     * @param user_posts - posts of the user to set
     */
    public void setUser_posts(ArrayList<PostBean> user_posts) {
        this.setUser_posts(user_posts);
    }

    /**
     * @return - posts the user has rated
     */
    public List<VPBean> getViewed_posts() {
        return viewed_posts;
    }

    /**
     * @param viewed_posts - posts the user has rated to set
     */
    public void setViewed_posts(ArrayList<VPBean> viewed_posts) {
        this.setViewed_posts(viewed_posts);
    }

    /**
     * @return - messages to user
     */
    public List<MessageBean> getMessages() {
        return messages;
    }
    /**
     * @param messages - messages to user to set
     */
    public void setMessages(ArrayList<MessageBean> messages) {
        this.setMessages(messages);
    }

    /**
     * @return - comments the user has made
     */
    public List<CommentBean> getUser_comments() {
        return user_comments;
    }

    /**
     * @param user_comments - comments the user has made to set
     */
    public void setUser_comments(ArrayList<CommentBean> user_comments) {
        this.setUser_comments(user_comments);
    }

    /**
     * @return - score of the user
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score - of the user to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return - likes user has made
     */
    public List<LikeBean> getLikes() {
        return likes;
    }

    /**
     * @param likes - likes user has made to set
     */
    public void setLikes(List<LikeBean> likes) {
        this.likes = likes;
    }

    /**
     * @return - dislikes user has made
     */
    public List<DislikeBean> getDislikes() {
        return dislikes;
    }

    /**
     * @param dislikes - dislikes user has made to set
     */
    public void setDislikes(List<DislikeBean> dislikes) {
        this.dislikes = dislikes;
    }

    /**
     * @return - whether or not user is locked
     */
    public int getLock() {
        return lock;
    }

    /**
     * @param user_posts - posts created by the user
     */
    public void setUser_posts(List<PostBean> user_posts) {
        this.user_posts = user_posts;
    }

    /**
     * @param viewed_posts - posts the user has viewed to set
     */
    public void setViewed_posts(List<VPBean> viewed_posts) {
        this.viewed_posts = viewed_posts;
    }

    /**
     * @param messages - messages to the user 
     */
    public void setMessages(List<MessageBean> messages) {
        this.messages = messages;
    }

    /**
     * @param user_comments - comments that the user has made to set
     */
    public void setUser_comments(List<CommentBean> user_comments) {
        this.user_comments = user_comments;
    }

    public UserBean(int user_id, String username, String password, String gender, String role, int lock,
            ArrayList<PostBean> user_posts, ArrayList<VPBean> viewed_posts, ArrayList<MessageBean> messages,
            ArrayList<CommentBean> user_comments, ArrayList<LikeBean> likes, ArrayList<DislikeBean> dislikes, int score) {
        super();
        this.user_id = user_id;
        this.email = username;
        this.password = password;
        this.gender = gender;
        this.role = role; 
        this.lock = lock;
        this.user_posts = user_posts;
        this.viewed_posts = viewed_posts;
        this.messages = messages;
        this.likes = likes;
        this.dislikes = dislikes;
        this.user_comments = user_comments;
        this.score = score;
    }

    public UserBean() {
        super();
    }

    public UserBean(String username, String password, String gender, String role, int lock,
            ArrayList<PostBean> user_posts, ArrayList<VPBean> viewed_posts, ArrayList<MessageBean> messages,
            ArrayList<CommentBean> user_comments, ArrayList<LikeBean> likes, ArrayList<DislikeBean> dislikes, int score) {
        super();
        this.email = username;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.lock = lock;
        this.user_posts = user_posts;
        this.viewed_posts = viewed_posts;
        this.messages = messages;
        this.user_comments = user_comments;
        this.likes = likes;
        this.dislikes = dislikes;
        this.score = score;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

}
