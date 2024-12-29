package com.bank.api.services;

import com.bank.api.model.requests.*;
import static com.bank.api.endpoints.APIEndpoints.*;

import java.util.*;

import io.restassured.response.Response;

public class AuthService extends BaseService {
//	private static final String BASE_PATH = "/api/auth/";

	public Response signup(SignUpRequest payload) {
		return postRequest(payload, signUpAPI);
	}

	public Response login(LoginRequest payload) {
		return postRequest(payload, loginAPI);
	}

	public Response forgotPassword(String authToken, String email) {
		HashMap<String, String> payload = new HashMap<String, String>();
		payload.put("email", email);

		attachToken(authToken);
		return postRequest(payload, forgotPasswordAPI);
	}
}
