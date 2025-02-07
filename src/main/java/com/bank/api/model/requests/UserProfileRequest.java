package com.bank.api.model.requests;

public class UserProfileRequest {
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String address;

	private UserProfileRequest(UserProfileRequestBuilder builder) {
		super();
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.email = builder.email;
		this.mobileNumber = builder.mobileNumber;
		this.address = builder.address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public static class UserProfileRequestBuilder {
		private String firstName;
		private String lastName;
		private String email;
		private String mobileNumber;
		private String address;

		public UserProfileRequestBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserProfileRequestBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserProfileRequestBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public UserProfileRequestBuilder withMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}

		public UserProfileRequestBuilder withAddress(String address) {
			this.address = address;
			return this;
		}

		public UserProfileRequest build() {
			return new UserProfileRequest(this);
		}
	}
}
