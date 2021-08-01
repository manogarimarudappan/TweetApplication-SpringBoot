package com.tweetapp.bean;

import org.springframework.data.annotation.Id;

/**
 * @author Manogari M
 *
 */
public class DbSequence {
	@Id
    private String  id;
    private int seq;
	
	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return seq
	 */
	public int getSeq() {
		return seq;
	}
	/**
	 * @param seq
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
}
