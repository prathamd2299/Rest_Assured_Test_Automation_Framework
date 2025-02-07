package com.bank.api.testData;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.api.model.requests.*;
import com.bank.api.utilities.*;

public class AuthData {
	public static final Logger logger = LogManager.getLogger(AuthData.class);

	public SignUpRequest getValidSignUpData() {
		String username = Datagenerator.getRandomUserName();
		logger.info("Username input is: " + username);

		String password = Datagenerator.getRandomPassword();
		logger.info("Password input is: " + password);

		String email = Datagenerator.getRandomEmail();
		logger.info("Email input is: " + email);

		String firstName = Datagenerator.getRandomFirstName();
		logger.info("First name input is: " + firstName);

		String lastName = Datagenerator.getRandomLastName();
		logger.info("Last name input is: " + lastName);

		String mobileNumber = Datagenerator.getRandomMobileNumber();
		logger.info("Mobile number input is: " + mobileNumber);

		return new SignUpRequest.SignUpRequestBuilder().withUsername(username).withPassword(password).withEmail(email)
				.withFirstName(firstName).withLastName(lastName).withMobileNumber(mobileNumber).build();
	}

	public SignUpRequest getAlreadyExistSignUpData() {
		String username = ConfigManager.getInstance().getProperty("username");
		logger.info("Username input is: " + username);

		String password = ConfigManager.getInstance().getProperty("password");
		logger.info("Password input is: " + password);

		String email = ConfigManager.getInstance().getProperty("email");
		logger.info("Email input is: " + email);

		String firstName = Datagenerator.getRandomFirstName();
		logger.info("First name input is: " + firstName);

		String lastName = Datagenerator.getRandomLastName();
		logger.info("Last name input is: " + lastName);

		String mobileNumber = Datagenerator.getRandomMobileNumber();
		logger.info("Mobile number input is: " + mobileNumber);

		return new SignUpRequest.SignUpRequestBuilder().withUsername(username).withPassword(password).withEmail(email)
				.withFirstName(firstName).withLastName(lastName).withMobileNumber(mobileNumber).build();
	}

	public LoginRequest getInvalidLoginCredentials() {
		return new LoginRequest.LoginRequestBuilder().withUsername("john").withPassword("John@123").build();
	}

	public LoginRequest getValidLoginCredentials() {
		String username = ConfigManager.getInstance().getProperty("username");
		logger.info("Username input is: " + username);

		String password = ConfigManager.getInstance().getProperty("password");
		logger.info("Password input is: " + password);

		return new LoginRequest.LoginRequestBuilder().withUsername(username).withPassword(password).build();
	}
}
