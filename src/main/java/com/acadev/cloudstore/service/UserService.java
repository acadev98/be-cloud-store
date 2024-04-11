package com.acadev.cloudstore.service;

import com.acadev.cloudstore.model.request.SignInRequest;
import com.acadev.cloudstore.model.request.SignUpRequest;
import com.acadev.cloudstore.model.response.SignInResponse;

public interface UserService {

	String echo();
	
	void signup(SignUpRequest request);
	
	SignInResponse signin(SignInRequest request);

}
