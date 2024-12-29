package com.bank.api.model.requests;

public class UserProfileRequest {
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static class UserProfileRequestBuilder {
		private UserProfileRequest userProfileRequest;

		public UserProfileRequestBuilder() {
			this.userProfileRequest = new UserProfileRequest();
		}

		public UserProfileRequestBuilder withFirstName(String firstName) {
			this.userProfileRequest.setFirstName(firstName);
			return this;
		}

		public UserProfileRequestBuilder withLastName(String lastName) {
			this.userProfileRequest.setLastName(lastName);
			return this;
		}

		public UserProfileRequestBuilder withEmail(String email) {
			this.userProfileRequest.setEmail(email);
			return this;
		}

		public UserProfileRequestBuilder withMobileNumber(String mobileNumber) {
			this.userProfileRequest.setMobileNumber(mobileNumber);
			return this;
		}

		public UserProfileRequestBuilder withAddress(String address) {
			this.userProfileRequest.setAddress(address);
			return this;
		}

		public UserProfileRequest build() {
			return this.userProfileRequest;
		}
	}
}
