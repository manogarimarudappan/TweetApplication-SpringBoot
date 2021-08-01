package com.tweetapp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tweetapp.bean.Users;
import com.tweetapp.constant.TweetAppConstant;
import com.tweetapp.exception.UserException;
import com.tweetapp.repository.UserDetailsRepository;

/**
 * @author Manogari M
 *
 */
@Service
public class UserDetailsService {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserDetailsService.class);

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	/**
	 * this method is used to register the user for tweet app
	 * 
	 * @param user
	 * @throws UserException
	 */
	@Transactional
	public void registerUser(Users user) throws UserException {
		LOGGER.info("Entering registerUser method in UserDetailsService");
		boolean isLoginUserExists = false;
		Users existingLoginIdUser = userDetailsRepository.findByLoginId(user.getLoginId());
		Users existingEmailUser = userDetailsRepository.findByEmail(user.getEmail());
		List<Users> mergeUsers = new ArrayList<>();
		if (existingEmailUser != null && existingLoginIdUser != null) {
			mergeUsers.add(existingEmailUser);
			mergeUsers.add(existingLoginIdUser);
		} else if (existingLoginIdUser != null) {
			mergeUsers.add(existingLoginIdUser);
		} else {
			if (existingEmailUser != null) {
				mergeUsers.add(existingEmailUser);
			}
		}
		System.out.println(mergeUsers);
		if (!mergeUsers.isEmpty()) {
			for (Users loginUser : mergeUsers) {

				if (loginUser.getEmail() != user.getEmail() && loginUser.getLoginId() != user.getLoginId()) {
					isLoginUserExists = true;
					break;
				}
			}

			if (!isLoginUserExists) {
				LOGGER.info("new user");

				user.setLogin(false);
				System.out.println(user);
				userDetailsRepository.save(user);
			} else {
				LOGGER.error("User Already Exists...");
				throw new UserException("Kindly Enter Unique Email id and Login Id");
			}
		} else

		{
			user.setLogin(false);
			System.out.println(user);
			userDetailsRepository.save(user);
		}
	}

	/**
	 * this method is used for login
	 * 
	 * @param user
	 * @throws UserException
	 */
	@Transactional
	public void login(Users user) throws UserException {
		Users existingUsers = userDetailsRepository.findByLoginId(user.getLoginId());
		if (user.getLoginId().equals(existingUsers.getLoginId())
				&& user.getPassword().equals(existingUsers.getPassword())) {
			existingUsers.setLogin(true);
			userDetailsRepository.save(existingUsers);
			System.out.println(existingUsers);
		} else {
			LOGGER.error("Please Entered Valid Login Id and Password");
			throw new UserException("Invalid Credentials");
		}
	}

	/**
	 * this method is used for logout
	 * 
	 * @param loginId
	 * @throws UserException
	 */
	@Transactional
	public void logout(String loginId) throws UserException {
		Users existingUsers = userDetailsRepository.findByLoginId(loginId);
		existingUsers.setLogin(false);
		userDetailsRepository.save(existingUsers);
	}

	/**
	 * this method is used for changing the password
	 * 
	 * 
	 * @param loginId
	 * @param user
	 */
	@Transactional
	public void forgotPassword(String loginId, Users user) {
		Users existingUsers = userDetailsRepository.findByLoginId(loginId);
		System.out.println(existingUsers);
		if (!existingUsers.isLogin()) {
			if (existingUsers != null) {
				if (!existingUsers.getPassword().equals(user.getPassword())) {
					if (user.getPassword().equals(user.getConfirmPassword())) {
						existingUsers.setPassword(user.getPassword());
						existingUsers.setConfirmPassword(user.getConfirmPassword());
						userDetailsRepository.save(existingUsers);
					}
				}
			}
		}
	}

	/**
	 * this method is used to retrieve all user from the db
	 * 
	 * @param loginId
	 * @return list
	 */
	@Transactional
	public Iterable<Users> findAllUsers(String loginId) {
		Iterable<Users> userList = new ArrayList<Users>();

		Users existingUsers = userDetailsRepository.findByLoginId(loginId);
		if (existingUsers.isLogin()) {
			userList = userDetailsRepository.findAll();
			return userList;
		}
		return null;

	}

	
}
