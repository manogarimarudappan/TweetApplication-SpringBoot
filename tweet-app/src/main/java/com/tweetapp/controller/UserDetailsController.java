package com.tweetapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.bean.Users;
import com.tweetapp.exception.UserException;
import com.tweetapp.service.UserDetailsService;

/**
 * @author Manogari M
 *
 */
@RestController
@RequestMapping("/api/v1.0/tweets")
@CrossOrigin(origins = "*")
public class UserDetailsController {
	private final static Logger LOGGER = LoggerFactory.getLogger(UserDetailsController.class);

	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * @param users
	 * @throws UserException
	 */
	@PostMapping("/register")
	public void registerUser(@RequestBody Users users) throws UserException {
		userDetailsService.registerUser(users);
	}

	/**
	 * @param user
	 * @throws UserException
	 */
	@PostMapping("/login")
	public void login(@RequestBody Users user) throws UserException {
		LOGGER.info("Login method in UserDetailsController");
		userDetailsService.login(user);
	}

	/**
	 * @param loginId
	 * @param user
	 */

	@PostMapping("/forgot/{loginId}")
	public void forgotPassword(@PathVariable("loginId") String loginId, @RequestBody Users user) {
		userDetailsService.forgotPassword(loginId, user);
	}

	/**
	 * @param loginId
	 * @throws UserException
	 */
	@GetMapping("/logout/{loginId}")
	public void logout(@PathVariable("loginId") String loginId) throws UserException {
		LOGGER.info("logout method in UserDetailsController");
		userDetailsService.logout(loginId);
	}

	/**
	 * @param loginId
	 * @return list of users
	 */
	@GetMapping("/users/all/{loginId}")
	public Iterable<Users> findAllUsers(@PathVariable("loginId") String loginId) {
		System.out.println("controller");
		Iterable<Users> userList = new ArrayList<Users>();
		userList = userDetailsService.findAllUsers(loginId);
		return userList;
	}

}
