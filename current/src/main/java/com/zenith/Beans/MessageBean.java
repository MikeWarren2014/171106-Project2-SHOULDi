/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenith.Beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *Bean to hold Messages. Holds sender and receiver UserBeans along with the text of the message
 * @author Caleb Schumake
 */
@Entity
@XmlRootElement
@Table(name = "Messages")
public class MessageBean implements Serializable {

    @Id //designates as primary key
    @Column(name = "MESSAGE_ID")
    @SequenceGenerator(sequenceName = "MESSAGE_SEQ", name = "MESSAGE_SEQ")
    @GeneratedValue(generator = "MESSAGE_SEQ", strategy = GenerationType.SEQUENCE)
    private int message_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserBean userBean;
    
    @ManyToOne
    @JoinColumn(name = "sponsor_id")
    UserBean sponsorBean;

    @OneToOne
    @JoinColumn(name = "TO_ID")
    private UserBean to;

    @OneToOne
    @JoinColumn(name = "FROM_ID")
    private UserBean from;

    @Column(name = "CONTENT")
    private String content;

    /**
     * @return - id of the message
     */
    public int getMessage_id() {
        return message_id;
    }

    /**
     * @param message_id - id of the message to set
     */
    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    /**
     * @return - user the message is to
     */
    public UserBean getTo() {
        return to;
    }

    /**
     * @param to - set the user to which the message is sent
     */
    public void setTo(UserBean to) {
        this.to = to;
    }

    /**
     * @return - user the message is from
     */
    public UserBean getFrom() {
        return from;
    }

    /**
     * @param to - set the user from which the message is sent
     */
    public void setFrom(UserBean from) {
        this.from = from;
    }
    
    /**
     * @return - text of the comment
     */
    public String getContent() {
        return content;
    }

    /**
     * @return - set the text of the comment
     */
    public void setContent(String content) {
        this.content = content;
    }

    public MessageBean(int message_id, UserBean to, UserBean from, String content) {
        super();
        this.message_id = message_id;
        this.to = to;
        this.from = from;
        this.content = content;
    }

    public MessageBean(UserBean to, UserBean from, String content) {
        super();
        this.to = to;
        this.from = from;
        this.content = content;
    }

    public MessageBean() {
        super();
    }

}
