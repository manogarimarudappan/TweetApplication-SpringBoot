package com.tweetapp.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.tweetapp.bean.Post;

@EnableScan
public interface TweetRepository extends CrudRepository<Post, String> {
	List<Post> findByLoginId(String loginId);
	
}
