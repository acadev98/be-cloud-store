package com.acadev.cloudstore.model.request;

import lombok.Data;

@Data
public class SignUpRequest {
	private String name;
	private String mail;
	private String password;
}
