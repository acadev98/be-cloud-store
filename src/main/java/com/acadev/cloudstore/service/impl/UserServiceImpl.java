package com.acadev.cloudstore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acadev.cloudstore.database.entity.Users;
import com.acadev.cloudstore.database.repository.UsersRepository;
import com.acadev.cloudstore.handler.exception.ApiException;
import com.acadev.cloudstore.model.request.SignInRequest;
import com.acadev.cloudstore.model.request.SignUpRequest;
import com.acadev.cloudstore.model.response.SignInResponse;
import com.acadev.cloudstore.service.UserService;
import com.acadev.cloudstore.utils.JwtHelper;
import com.acadev.cloudstore.utils.enums.ApiMessage;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	public String echo() {
		return "user echo message service";
	}
	
	@Transactional
	public void signup(SignUpRequest request) {
		Optional<Users> existingUser = repository.findByMail(request.getMail());
		if (existingUser.isPresent()) {
			throw new ApiException(ApiMessage.EMAIL_USER_ALREADY_EXISTS);
		}
		
		String hashedPassword = passwordEncoder.encode(request.getPassword());
		
		Users user = Users.builder()
				.name(request.getName())
				.mail(request.getMail())
				.password(hashedPassword)
				.build();
		
		repository.save(user);
	}
	
	public SignInResponse signin(SignInRequest request) {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getMail(), request.getPassword()));
	    } catch (Exception e) {
			throw new ApiException(ApiMessage.CREDENTIALS_INCORRECT);
	    }
		
		String token = JwtHelper.generateToken(request.getMail());
		return SignInResponse.builder().mail(request.getMail()).token(token).build();
	}
	
}
