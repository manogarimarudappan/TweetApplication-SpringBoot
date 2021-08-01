package com.tweetapp.bean;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PostTest {

	Post post;

	@Before
	public void setup() {
		post = new Post();
	}

	@Test
	public void postTest() {
		post.setEmailId(Mockito.anyString());
		post.setId(Mockito.anyString());
		post.setLike(Mockito.anyString());
		post.setLoginId(Mockito.anyString());
		post.setMessage(Mockito.anyString());
		post.setPostTime(Mockito.any());

		assertNotEquals("xyz", post.getEmailId());
		assertNotEquals("xyz", post.getId());
		assertNotEquals("xyz", post.getLike());
		assertNotEquals("xyz", post.getLoginId());
		assertNotEquals("xyz", post.getMessage());
		assertNotEquals(new Date(), post.getPostTime());
	}

}
