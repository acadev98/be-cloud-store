package com.acadev.cloudstore.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInResponse {
	private String mail;
	private String token;
}
