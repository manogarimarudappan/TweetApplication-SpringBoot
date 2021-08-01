package com.tweetapp.bean;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserTest {

	Users user;

	@Before
	public void setup() {
		user = new Users();
	}

	@Test
	public void userBeanTest() {
		user.setId(Mockito.anyString());
		user.setConfirmPassword(Mockito.anyString());
		user.setContactNumber(Mockito.anyLong());
		user.setEmail(Mockito.anyString());
		user.setFirstName(Mockito.anyString());
		user.setLastName(Mockito.anyString());
		user.setLogin(Mockito.anyBoolean());
		user.setLoginId(Mockito.anyString());
		user.setPassword(Mockito.anyString());

		assertNotEquals("1", user.getConfirmPassword());
		assertNotEquals(2, user.getContactNumber());
		assertNotEquals("2", user.getEmail());
		assertNotEquals("abc", user.getFirstName());
		assertNotEquals("2", user.getId());
		assertNotEquals("abc", user.getLastName());
		assertNotEquals("2", user.getLoginId());
		assertNotEquals("2", user.getPassword());

		assertNotNull(user.isLogin());
	}

}
