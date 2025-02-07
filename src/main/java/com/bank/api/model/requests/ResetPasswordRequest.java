package com.bank.api.model.requests;

public class ResetPasswordRequest {
	private String token;
	private String newPassword;
	private String confirmPassword;

	public ResetPasswordRequest(ResetPasswordRequestBuilder builder) {
		super();
		this.token = builder.token;
		this.newPassword = builder.newPassword;
		this.confirmPassword = builder.confirmPassword;
	}

	public String getToken() {
		return token;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public static class ResetPasswordRequestBuilder {
		private String token;
		private String newPassword;
		private String confirmPassword;

		public ResetPasswordRequestBuilder withToken(String token) {
			this.token = token;
			return this;
		}

		public ResetPasswordRequestBuilder withNewPassword(String newPassword) {
			this.newPassword = newPassword;
			return this;
		}

		public ResetPasswordRequestBuilder withConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
			return this;
		}

		public ResetPasswordRequest build() {
			return new ResetPasswordRequest(this);
		}
	}
}
