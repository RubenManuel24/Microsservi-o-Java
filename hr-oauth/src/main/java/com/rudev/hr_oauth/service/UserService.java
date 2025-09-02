package com.rudev.hr_oauth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudev.hr_oauth.entities.User;
import com.rudev.hr_oauth.feignclients.UserFeignClient;

@Service
public class UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if(user == null) {
			logger.error("Email not found");
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found: "+ email);
		return user;
	}

}
