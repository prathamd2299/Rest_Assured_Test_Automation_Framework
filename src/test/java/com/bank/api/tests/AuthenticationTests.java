package com.bank.api.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.*;

import com.bank.api.base.*;
import com.bank.api.model.requests.*;
import com.bank.api.model.responses.*;
import com.bank.api.services.*;
import com.bank.api.utilities.*;
import com.bank.api.listeners.TestListener;

import io.restassured.response.*;

@Listeners(TestListener.class)
public class AuthenticationTests extends BaseTest {
	private static String username;
	private static String password;
	private static String email;
	private static String firstName;
	private static String lastName;
	private static String mobileNumber;
	public static String authToken;

	@BeforeClass
	public void setData() {
		username = Datagenerator.getRandomUserName();
		LoggerUtility.info("Username input is: " + username);

		password = Datagenerator.getRandomPassword();
		LoggerUtility.info("Password input is: " + password);

		email = Datagenerator.getRandomEmail();
		LoggerUtility.info("Email input is: " + email);

		firstName = Datagenerator.getRandomFirstName();
		LoggerUtility.info("First name input is: " + firstName);

		lastName = Datagenerator.getRandomLastName();
		LoggerUtility.info("Last name input is: " + lastName);

		mobileNumber = Datagenerator.getRandomMobileNumber();
		LoggerUtility.info("Mobile number input is: " + mobileNumber);
	}

	@Test(priority = 1)
	public void verifySignUpWithValidData() {
		SignUpRequest signUpRequest = new SignUpRequest.SignUpRequestBuilder().withUserName(username)
				.withPassword(password).withEmail(email).withFirstName(firstName).withLastName(lastName)
				.withMobileNumber(mobileNumber).build();
		AuthService authService = new AuthService();
		Response response = authService.signup(signUpRequest);
		LoggerUtility.info("Sign up response body: " + response.asPrettyString());

		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void verifyLoginWithValidCredentials() {
		LoginRequest loginRequest = new LoginRequest.LoginRequestBuilder().withUsername(username).withPassword(password)
				.build();
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoggerUtility.info("Login response body: " + response.asPrettyString());

		assertEquals(response.getStatusCode(), 200);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		assertNotNull(loginResponse.getToken());
		assertEquals(loginResponse.getType(), "Bearer");
		assertEquals(loginResponse.getUsername(), username);
		assertEquals(loginResponse.getEmail(), email);
		assertNotNull(loginResponse.getId());
		assertEquals(loginResponse.getRoles().get(0), "ROLE_USER");
	}
}
