package com.tweetapp.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tweetapp.bean.Post;
import com.tweetapp.bean.ReplyTweets;
import com.tweetapp.bean.Users;
import com.tweetapp.repository.ReplyTweetRepository;
import com.tweetapp.repository.TweetRepository;
import com.tweetapp.repository.UserDetailsRepository;

/**
 * @author Manogari M
 *
 */
@Service
public class TweetService {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private TweetRepository tweetRepository;

	@Autowired
	private ReplyTweetRepository replyTweetRepository;

	/**
	 * this method is used to find all the tweets from database
	 * 
	 * @return tweetList
	 */
	@Transactional
	public Iterable<Post> findAllTweets() {
		Iterable<Post> tweetList = new ArrayList<Post>();
		tweetList = tweetRepository.findAll();

		return tweetList;
	}

	/**
	 * this method is used to find the tweets based on the loginId
	 * 
	 * @param loginId
	 * @return tweetList
	 */
	@Transactional
	public List<Post> findByUserTweet(String loginId) {
		List<Post> tweetList = new ArrayList<Post>();
		tweetList = tweetRepository.findByLoginId(loginId);
		return tweetList;

	}

	/**
	 * this method is used to find the tweet based on id
	 * 
	 * @param id
	 * @return post
	 */
	@Transactional
	public Optional<Post> findByTweet(String id) {
		Optional<Post> post = tweetRepository.findById(id);
		return post;
	}

	/**
	 * this method is used the save the tweets to the db
	 * 
	 * @param tweets
	 * @param loginId
	 * @throws ParseException
	 */
	@Transactional
	public void postTweets(Post tweets, String loginId) throws ParseException {
		Users existingUser = userDetailsRepository.findByLoginId(loginId);
		if (existingUser.isLogin()) {
			tweets.setEmailId(existingUser.getEmail());
			tweets.setLoginId(loginId);
			tweets.setLike("0");

			tweets.setPostTime(new Date());
			System.out.println(tweets);
			tweetRepository.save(tweets);
		}
	}

	/**
	 * this method is used to view the replytweets for the specific user
	 * 
	 * @param loginId
	 * @param id
	 * @return
	 */
	@Transactional
	public List<ReplyTweets> viewReply(String loginId, String id) {
		List<ReplyTweets> replyTweets = replyTweetRepository.findByPostId(id);
		return replyTweets;
	}

	/**
	 * this method is used to update the tweet in the db
	 * 
	 * @param tweets
	 * @param loginId
	 * @param id
	 */
	@Transactional
	public void updateTweets(Post tweets, String loginId, String id) {
		Users existingUser = userDetailsRepository.findByLoginId(loginId);
		if (existingUser.isLogin()) {
			Optional<Post> updatePost = tweetRepository.findById(id);
			if (updatePost != null) {
				Post updateTweet = updatePost.get();
				updateTweet.setMessage(tweets.getMessage());
				updateTweet.setPostTime(new Date());
				tweetRepository.save(updateTweet);
			}
		}
	}

	/**
	 * this method is used to delete the tweet from the db
	 * 
	 * @param id
	 * @param loginId
	 */
	@Transactional
	public void deleteTweets(String id, String loginId) {
		Users existingUser = userDetailsRepository.findByLoginId(loginId);
		if (existingUser.isLogin()) {
			tweetRepository.deleteById(id);
		}
	}

	/**
	 * this method is used to increase the like count for specific tweets in the db
	 * 
	 * @param id
	 * @param loginId
	 */
	@Transactional
	public void likeTweets(String id, String loginId) {
		Users existingUser = userDetailsRepository.findByLoginId(loginId);
		if (existingUser.isLogin()) {
			Optional<Post> likePost = tweetRepository.findById(id);
			if (likePost != null) {
				Post post = likePost.get();
				System.out.println(post.getLike());
				int likeCount = Integer.valueOf(post.getLike());
				post.setLike(String.valueOf(likeCount + 1));
				tweetRepository.save(post);
			}
		}

	}

	/**
	 * this method is used to post the reply to specific tweet
	 * 
	 * @param id
	 * @param loginId
	 * @param replyTweets
	 */
	@Transactional
	public void replyTweets(String id, String loginId, ReplyTweets replyTweets) {
		Users existingUser = userDetailsRepository.findByLoginId(loginId);
		if (existingUser.isLogin()) {
			Optional<Post> likePost = tweetRepository.findById(id);
			if (likePost != null) {
				Post post = likePost.get();
				replyTweets.setLoginId(loginId);

				replyTweets.setPostId(post.getId());
				replyTweetRepository.save(replyTweets);
			}
		}
	}

}
