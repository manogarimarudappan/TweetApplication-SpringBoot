package com.tweetapp.bean;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ReplyTweetsTest {

	ReplyTweets replyTweets;

	@Before
	public void setup() {
		replyTweets = new ReplyTweets();

	}

	@Test
	public void replyTweetsTest() {
		replyTweets.setId(Mockito.anyString());
		replyTweets.setLoginId(Mockito.anyString());
		replyTweets.setMessage(Mockito.anyString());
		replyTweets.setPostId(Mockito.anyString());

		assertNotEquals("xyz", replyTweets.getId());
		assertNotEquals("xyz", replyTweets.getLoginId());
		assertNotEquals("xyz", replyTweets.getMessage());
		assertNotEquals("xyz", replyTweets.getPostId());
	}

}
