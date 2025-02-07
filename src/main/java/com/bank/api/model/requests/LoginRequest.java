package com.bank.api.model.requests;

public class LoginRequest {
	private String username;
	private String password;

	public LoginRequest(LoginRequestBuilder builder) {
		super();
		this.username = builder.username;
		this.password = builder.password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public static class LoginRequestBuilder {
		private String username;
		private String password;

		public LoginRequestBuilder withUsername(String username) {
			this.username = username;
			return this;
		}

		public LoginRequestBuilder withPassword(String password) {
			this.password = password;
			return this;
		}

		public LoginRequest build() {
			return new LoginRequest(this);
		}
	}
}
