package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class Message {
	@Id //designates as primary key
	@Column(name="MESSAGE_ID")
	@SequenceGenerator(sequenceName="MESSAGE_SEQ", name="MESSAGE_SEQ")
	@GeneratedValue(generator="MESSAGE_SEQ", strategy=GenerationType.SEQUENCE)
	private int message_id;
	@OneToOne
	@JoinColumn(name="TO_ID")
	private User to;
	@OneToOne
	@JoinColumn( name="FROM_ID")
	private User from;
	@Column(name="CONTENT")
	private String content;
	
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public User getTo() {
		return to;
	}
	public void setTo(User to) {
		this.to = to;
	}
	public User getFrom() {
		return from;
	}
	public void setFrom(User from) {
		this.from = from;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Message(int message_id, User to, User from, String content) {
		super();
		this.message_id = message_id;
		this.to = to;
		this.from = from;
		this.content = content;
	}
	public Message(User to, User from, String content) {
		super();
		this.to = to;
		this.from = from;
		this.content = content;
	}
	public Message() {
		super();
	}
	
	
}
