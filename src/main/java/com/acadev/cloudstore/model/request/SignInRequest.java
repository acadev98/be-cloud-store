package com.acadev.cloudstore.model.request;

import lombok.Data;

@Data
public class SignInRequest {
	private String mail;
	private String password;
}
