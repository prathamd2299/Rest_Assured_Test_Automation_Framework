package com.bank.api.model.requests;

public class SignUpRequest {
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String mobileNumber;

	private SignUpRequest(SignUpRequestBuilder builder) {
		super();
		this.username = builder.username;
		this.password = builder.password;
		this.email = builder.email;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.mobileNumber = builder.mobileNumber;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public static class SignUpRequestBuilder {
		private String username;
		private String password;
		private String email;
		private String firstName;
		private String lastName;
		private String mobileNumber;

		public SignUpRequestBuilder withUsername(String username) {
			this.username = username;
			return this;
		}

		public SignUpRequestBuilder withPassword(String password) {
			this.password = password;
			return this;
		}

		public SignUpRequestBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public SignUpRequestBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public SignUpRequestBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public SignUpRequestBuilder withMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}

		public SignUpRequest build() {
			return new SignUpRequest(this);
		}
	}
}
