package com.acadev.cloudstore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.acadev.cloudstore.database.entity.Users;
import com.acadev.cloudstore.database.repository.UsersRepository;
import com.acadev.cloudstore.handler.exception.ApiException;
import com.acadev.cloudstore.utils.enums.ApiMessage;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersRepository repository;

	public String echo() {
		return "user details echo message service";
	}
	
	public UserDetails loadUserByUsername(String email) {

		Optional<Users> userOptional = repository.findByMail(email); 
		
		if (userOptional.isEmpty()) {
			throw new ApiException(ApiMessage.USER_NOT_FOUND);
		} else {
			Users user = userOptional.get();
			return org.springframework.security.core.userdetails.User.builder()
					.username(user.getMail())
					.password(user.getPassword())
					.build();
		}
		
	}
	
}
