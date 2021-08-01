package com.tweetapp.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.tweetapp.bean.Users;

@EnableScan
public interface UserDetailsRepository extends CrudRepository<Users, String> {

	Users findByEmail(String email);
	Users findByLoginId(String loginId);

}
