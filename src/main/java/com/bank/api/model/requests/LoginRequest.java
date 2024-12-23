package com.bank.api.model.requests;

public class LoginRequest {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static class LoginRequestBuilder {
		private LoginRequest loginRequest;

		public LoginRequestBuilder() {
			this.loginRequest = new LoginRequest();
		}

		public LoginRequestBuilder withUsername(String username) {
			this.loginRequest.setUsername(username);
			return this;
		}

		public LoginRequestBuilder withPassword(String password) {
			this.loginRequest.setPassword(password);
			return this;
		}

		public LoginRequest build() {
			return this.loginRequest;
		}
	}
}
