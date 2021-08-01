package com.tweetapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tweetapp.bean.Post;

/**
 * @author Manogari M
 *
 */
@Service
public class KafkaService {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	String kafkaTopic = "tweet_message";
	
	/**
	 * this method is used to send the kafka message 
	 * 
	 * @param post
	 */
	public void send(Post post) {
	    
	    kafkaTemplate.send(kafkaTopic, post.getMessage());
	}
}
