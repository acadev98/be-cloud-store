package com.acadev.cloudstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acadev.cloudstore.handler.ResponseHandler;
import com.acadev.cloudstore.model.request.SignInRequest;
import com.acadev.cloudstore.model.request.SignUpRequest;
import com.acadev.cloudstore.service.impl.UserServiceImpl;
import com.acadev.cloudstore.utils.MessagesUtils;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserServiceImpl service;
	
	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@RequestBody SignUpRequest request) {
		service.signup(request);
		return ResponseHandler.generateResponse(MessagesUtils.USER_CREATED, HttpStatus.CREATED);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<Object> signin(@RequestBody SignInRequest request) {
		return ResponseHandler.generateResponse(MessagesUtils.USER_LOGED, HttpStatus.OK, service.signin(request));
	}

}
