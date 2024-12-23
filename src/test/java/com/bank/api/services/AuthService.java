package com.bank.api.services;

import com.bank.api.model.requests.*;

import io.restassured.response.Response;

public class AuthService extends BaseService {
	private static final String BASE_PATH = "/api/auth/";
	
	public Response signup(SignUpRequest payload) {
		return postRequest(payload, BASE_PATH + "signup");
	}

	public Response login(LoginRequest payload) {
		return postRequest(payload, BASE_PATH + "login");
	}
}
