package com.zenith.templates;

/**
 *Template to return a message
 * @author Xavier Garibay
 */
public class MessageTemplate {
	private String to;
	private String from;
	private String content;
	
	
	public MessageTemplate() {
		super();
	}
	public MessageTemplate(String to, String from, String content) {
		super();
		this.to = to;
		this.from = from;
		this.content = content;
	}
	/**
	 * @return - username of receiver
	 */
	public String getTo() {
		return to;
	}
	
	/**
	 * @return - username of sender to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	
	/**
	 * @return - username of sender
	 */
	public String getFrom() {
		return from;
	}
	
	/**
	 * @return - username of sender to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * @return - content of message
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * @return - content of message to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
