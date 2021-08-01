package com.tweetapp.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.bean.Post;
import com.tweetapp.bean.ReplyTweets;
import com.tweetapp.service.KafkaService;
import com.tweetapp.service.TweetService;

/**
 * @author Manogari M
 *
 */
@RestController
@RequestMapping("/api/v1.0/tweets")
@CrossOrigin(origins = "*")
public class TweetsController {

	@Autowired
	private TweetService tweetService;
	

	
	/**
	 * @return list
	 */
	@GetMapping("/all")
	public Iterable<Post> findAllTweets() {
		Iterable<Post> tweetList = new ArrayList<Post>();
		tweetList = tweetService.findAllTweets();
		return tweetList;
	}

	/**
	 * @param tweets
	 * @param loginId
	 * @throws ParseException
	 */
	@PostMapping("/{loginId}/add")
	public void postTweets(@RequestBody Post tweets, @PathVariable("loginId") String loginId) throws ParseException {
		tweetService.postTweets(tweets, loginId);
	}
	
	/**
	 * @param loginId
	 * @return list
	 */
	@GetMapping("/{loginId}")
	public List<Post> findTweetByUser(@PathVariable("loginId") String loginId){
		return tweetService.findByUserTweet(loginId);
	}

	/**
	 * @param tweets
	 * @param loginId
	 * @param id
	 */
	@PutMapping("/{loginId}/update/{id}")
	public void updateTweets(@RequestBody Post tweets, @PathVariable("loginId") String loginId,
			@PathVariable("id") String id) {
		tweetService.updateTweets(tweets, loginId, id);
	}
	
	/**
	 * @param id
	 * @return post
	 */
	@GetMapping("/post/{id}")
	public Optional<Post> editTweet(@PathVariable("id") String id) {
		return tweetService.findByTweet(id);
	}

	/**
	 * @param loginId
	 * @param id
	 */
	@DeleteMapping("/{loginId}/delete/{id}")
	public void deleteTweets(@PathVariable("loginId") String loginId, @PathVariable("id") String id) {
		tweetService.deleteTweets(id, loginId);
	}

	/**
	 * @param loginId
	 * @param id
	 */
	@GetMapping("/{loginId}/like/{id}")
	public void likeTweets(@PathVariable("loginId") String loginId, @PathVariable("id") String id) {
		tweetService.likeTweets(id, loginId);
	}
	
	

	/**
	 * @param loginId
	 * @param id
	 * @param replyTweets
	 */
	@PostMapping("/{loginId}/reply/{id}")
	public void replyTweets(@PathVariable("loginId") String loginId, @PathVariable("id") String id,
			@RequestBody ReplyTweets replyTweets) {
		tweetService.replyTweets(id, loginId, replyTweets);
	}
	
	/**
	 * @param loginId
	 * @param id
	 * @return list
	 */
	@GetMapping("/{loginId}/view-reply/{id}")
	public List<ReplyTweets> viewReply(@PathVariable("loginId") String loginId, @PathVariable("id") String id) {
		return tweetService.viewReply(loginId, id);
	}
	

}
