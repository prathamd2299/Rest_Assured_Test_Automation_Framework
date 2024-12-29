package com.bank.api.model.requests;

public class ResetPasswordRequest {
	private String token;
	private String newPassword;
	private String confirmPassword;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public static class ResetPasswordRequestBuilder {
		private ResetPasswordRequest resetPasswordRequest;

		public ResetPasswordRequestBuilder() {
			this.resetPasswordRequest = new ResetPasswordRequest();
		}

		public ResetPasswordRequestBuilder withToken(String token) {
			this.resetPasswordRequest.setToken(token);
			return this;
		}

		public ResetPasswordRequestBuilder withNewPassword(String newPassword) {
			this.resetPasswordRequest.setNewPassword(newPassword);
			return this;
		}

		public ResetPasswordRequestBuilder withConfirmPassword(String confirmPassword) {
			this.resetPasswordRequest.setConfirmPassword(confirmPassword);
			return this;
		}

		public ResetPasswordRequest build() {
			return this.resetPasswordRequest;
		}
	}
}
