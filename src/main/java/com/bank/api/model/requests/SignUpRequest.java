package com.bank.api.model.requests;

public class SignUpRequest {
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String mobileNumber;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public static class SignUpRequestBuilder {
		private SignUpRequest signUpRequest;

		public SignUpRequestBuilder() {
			this.signUpRequest = new SignUpRequest();
		}

		public SignUpRequestBuilder withUserName(String userName) {
			this.signUpRequest.setUsername(userName);
			return this;
		}

		public SignUpRequestBuilder withPassword(String password) {
			this.signUpRequest.setPassword(password);
			return this;
		}

		public SignUpRequestBuilder withEmail(String email) {
			this.signUpRequest.setEmail(email);
			return this;
		}

		public SignUpRequestBuilder withFirstName(String firstName) {
			this.signUpRequest.setFirstName(firstName);
			return this;
		}

		public SignUpRequestBuilder withLastName(String lastName) {
			this.signUpRequest.setLastName(lastName);
			return this;
		}

		public SignUpRequestBuilder withMobileNumber(String mobileNumber) {
			this.signUpRequest.setMobileNumber(mobileNumber);
			return this;
		}

		public SignUpRequest build() {
			return this.signUpRequest;
		}
	}
}
