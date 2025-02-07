package com.bank.api.model.requests;

public class ChangePasswordRequest {
	private String currentPassword;
	private String newPassword;
	private String confirmPassword;

	public ChangePasswordRequest(ChangePasswordRequestBuilder builder) {
		super();
		this.currentPassword = builder.currentPassword;
		this.newPassword = builder.newPassword;
		this.confirmPassword = builder.confirmPassword;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public static class ChangePasswordRequestBuilder {
		private String currentPassword;
		private String newPassword;
		private String confirmPassword;

		public ChangePasswordRequestBuilder withCurrentPassword(String currentPassword) {
			this.currentPassword = currentPassword;
			return this;
		}

		public ChangePasswordRequestBuilder withNewPassword(String newPassword) {
			this.newPassword = newPassword;
			return this;
		}

		public ChangePasswordRequestBuilder withConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
			return this;
		}

		public ChangePasswordRequest build() {
			return new ChangePasswordRequest(this);
		}
	}
}
