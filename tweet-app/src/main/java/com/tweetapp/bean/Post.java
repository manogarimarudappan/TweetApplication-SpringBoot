package com.tweetapp.bean;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * @author Manogari M
 *
 */
@DynamoDBTable(tableName = "post")
public class Post {


	private String id;

	private String message;

	private String emailId;

	private String like;

	private Date postTime;

	private String loginId;

	/**
	 * @return loginId
	 */
	@DynamoDBAttribute(attributeName ="loginId")
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return postTime
	 */
	@DynamoDBAttribute(attributeName ="postTime")	
	public Date getPostTime() {
		return postTime;
	}

	/**
	 * @param postTime the postTime to set
	 */
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	/**
	 * @return like
	 */
	@DynamoDBAttribute(attributeName ="like")	
	public String getLike() {
		return like;
	}

	/**
	 * @param like the like to set
	 */
	public void setLike(String like) {
		this.like = like;
	}

	/**
	 * @return id
	 */
	@DynamoDBHashKey(attributeName ="id")
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return message
	 */
	@DynamoDBAttribute(attributeName ="message")	
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return emailId
	 */
	@DynamoDBAttribute(attributeName ="emailId")	
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
