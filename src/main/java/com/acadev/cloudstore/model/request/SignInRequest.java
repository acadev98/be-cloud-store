package com.acadev.cloudstore.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInRequest {
	private String mail;
	private String password;
}
