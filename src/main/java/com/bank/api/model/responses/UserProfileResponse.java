package com.bank.api.model.responses;

public class UserProfileResponse {
	private int id;
	private String username;
	private String email;
	private String firstName;
	private String lastName;
	private String mobileNumber;

	public UserProfileResponse() {

	}

	public UserProfileResponse(int id, String username, String email, String firstName, String lastName,
			String mobileNumber) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
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

}
