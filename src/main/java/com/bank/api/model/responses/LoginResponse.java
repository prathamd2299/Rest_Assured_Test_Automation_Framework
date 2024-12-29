package com.bank.api.model.responses;

import java.util.List;

public class LoginResponse {
	private String token;
	private String type;
	private int id;
	private String username;
	private String email;
	private List<String> roles;

	public LoginResponse() { // Default Constrcutor

	}

	public LoginResponse(String token, String type, int id, String username, String email, List<String> roles) {
		this.token = token;
		this.type = type;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public String getType() {
		return type;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public List<String> getRoles() {
		return roles;
	}
}
