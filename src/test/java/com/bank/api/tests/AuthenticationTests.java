package com.bank.api.tests;

import static org.testng.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import com.bank.api.base.*;
import com.bank.api.model.requests.*;
import com.bank.api.model.responses.*;
import com.bank.api.services.*;
import com.bank.api.testData.AuthData;
import com.bank.api.utilities.ConfigManager;
import com.bank.api.listeners.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.*;

@Listeners(TestListener.class)
public class AuthenticationTests extends BaseTest {
	public static final Logger logger = LogManager.getLogger(AuthenticationTests.class);

	private AuthService authService = new AuthService();
	private AuthData authData = new AuthData();

	@Test(priority = 1, enabled = false)
	public void testSignUp_validData() {
		SignUpRequest validUser = authData.getValidSignUpData();

		Response response = authService.signup(validUser);

		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void testSignUp_alreadyExistUser() {
		SignUpRequest alreadyExistUser = authData.getAlreadyExistSignUpData();
		Response response = authService.signup(alreadyExistUser);

		assertEquals(response.getStatusCode(), 400);

		assertEquals(response.asPrettyString(), "Error: Username is already taken!");
	}

	@Test(priority = 3)
	public void testLogin_invalidCredentials() {
		LoginRequest invalidLogin = authData.getInvalidLoginCredentials();
		Response response = authService.login(invalidLogin);

		assertEquals(response.getStatusCode(), 401);

		response.then().body("status", equalTo(401)).body("error", equalTo("Invalid Credentials"))
				.body("message", equalTo("The username or password you entered is incorrect"))
				.body("solution", equalTo("Please check your credentials and try again"));
	}

	@Test(priority = 4)
	public void testLogin_validCredentials() {
		String email = ConfigManager.getInstance().getProperty("email");
		
		LoginRequest validLogin = authData.getValidLoginCredentials();
		Response response = authService.login(validLogin);

		assertEquals(response.getStatusCode(), 200);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		assertNotNull(loginResponse.getToken());
		assertEquals(loginResponse.getType(), "Bearer");
		assertEquals(loginResponse.getUsername(), validLogin.getUsername());
		assertEquals(loginResponse.getEmail(), email);
		assertNotNull(loginResponse.getId());
		assertEquals(loginResponse.getRoles().get(0), "ROLE_USER");
	}

	@Test(priority = 5)
	public void testForgotPassword_validEmail() {
		LoginRequest validLogin = authData.getValidLoginCredentials();
		Response response = authService.login(validLogin);

		assertEquals(response.getStatusCode(), 200);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String authToken = loginResponse.getToken();

		response = authService.forgotPassword(authToken, "testautomationacademy33@gmail.com");

		response.then().body("message",
				equalTo("If your email exists in our system, you will receive reset instructions."));
	}
}
