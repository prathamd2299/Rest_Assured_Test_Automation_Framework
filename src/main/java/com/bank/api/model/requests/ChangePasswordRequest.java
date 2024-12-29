package com.bank.api.model.requests;

public class ChangePasswordRequest {
	private String currentPassword;
	private String newPassword;
	private String confirmPassword;

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
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

	public static class ChangePasswordRequestBuilder {
		private ChangePasswordRequest changePasswordRequest;

		public ChangePasswordRequestBuilder() {
			this.changePasswordRequest = new ChangePasswordRequest();
		}

		public ChangePasswordRequestBuilder withCurrentPassword(String currentPassword) {
			this.changePasswordRequest.setCurrentPassword(currentPassword);
			return this;
		}

		public ChangePasswordRequestBuilder withNewPassword(String newPassword) {
			this.changePasswordRequest.setNewPassword(newPassword);
			return this;
		}

		public ChangePasswordRequestBuilder withConfirmPassword(String confirmPassword) {
			this.changePasswordRequest.setConfirmPassword(confirmPassword);
			return this;
		}

		public ChangePasswordRequest build() {
			return this.changePasswordRequest;
		}
	}
}
