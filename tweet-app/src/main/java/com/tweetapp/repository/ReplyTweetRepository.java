package com.tweetapp.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.tweetapp.bean.ReplyTweets;

@EnableScan
public interface ReplyTweetRepository extends CrudRepository<ReplyTweets, String> {
	
	List<ReplyTweets> findByPostId(String postId);
}
