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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *Bean for Comments on Posts. Holds commentor and post that is being commented on.
 *@author Caleb Schumake
 */
@Entity
@XmlRootElement
@Table(name = "Comments")
public class CommentBean implements Serializable {

    /**
     * @return the commentor
     */
    public UserBean getCommentor() {
        return commentor;
    }

    /**
     * @param commentor the commentor to set
     */
    public void setCommentor(UserBean commentor) {
        this.commentor = commentor;
    }

    /**
     * @return the isFlagged
     */
    public int getIsFlagged() {
        return isFlagged;
    }

    /**
     * @param isFlagged the isFlagged to set
     */
    public void setIsFlagged(int isFlagged) {
        this.isFlagged = isFlagged;
    }

    /**
     * @return the postBean
     */
    public PostBean getPostBean() {
        return postBean;
    }

    /**
     * @param postBean the postBean to set
     */
    public void setPostBean(PostBean postBean) {
        this.postBean = postBean;
    }

    @Id //designates as primary key
    @Column(name = "COMMENT_ID")
    @SequenceGenerator(sequenceName = "COMMENT_SEQ", name = "COMMENT_SEQ")
    @GeneratedValue(generator = "COMMENT_SEQ", strategy = GenerationType.SEQUENCE)
    private int comment_id;

    /* Maps to user comments */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserBean commentor;

    @Column(name = "is_flagged")
    private int isFlagged;

    /* Link to Posts */
    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private PostBean postBean;

    @Column(name = "COMMENT_TEXT")
    private String comment_text;

    /**
     * @return - id of the comment
     */
    public int getComment_id() {
        return comment_id;
    }

    /**
     * @param comment_id - id of the comment
     */
    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    /**
     * @return - text of the comment
     */
    public String getComment_text() {
        return comment_text;
    }

    /**
     * @param comment_text - text of the comment to set
     */
    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public CommentBean(int comment_id, PostBean postBean, UserBean commenter, String comment_text) {
        super();
        this.comment_id = comment_id;
        this.postBean = postBean;
        this.commentor = commenter;
        this.comment_text = comment_text;
    }

    public CommentBean(PostBean postBean, UserBean commenter, String comment_text) {
        super();
        this.postBean = postBean;
        this.commentor = commenter;
        this.comment_text = comment_text;
    }

    public CommentBean() {
        super();
    }

}
