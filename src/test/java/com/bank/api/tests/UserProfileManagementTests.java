package com.bank.api.tests;

import static org.testng.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import com.bank.api.base.*;
import com.bank.api.listeners.*;
import com.bank.api.model.requests.*;
import com.bank.api.model.responses.*;
import com.bank.api.services.*;
import com.bank.api.utilities.*;

import io.restassured.response.Response;

@Listeners(TestListener.class)
public class UserProfileManagementTests extends BaseTest {
	public static final Logger logger = LogManager.getLogger(UserProfileManagementTests.class);

	@Test(priority = 1)
	public void verifyGetUserProfile() {
		String username = ConfigManager.getInstance().getProperty("username");
		String password = ConfigManager.getInstance().getProperty("password");
		String email = ConfigManager.getInstance().getProperty("email");

		LoginRequest loginRequest = new LoginRequest.LoginRequestBuilder().withUsername(username).withPassword(password)
				.build();
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		assertEquals(response.getStatusCode(), 200);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String authToken = loginResponse.getToken();
		int id = loginResponse.getId();

		UserProfileService userProfileService = new UserProfileService();
		response = userProfileService.getUserProfile(authToken);

		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		assertEquals(userProfileResponse.getId(), id);
		assertEquals(userProfileResponse.getUsername(), username);
		assertEquals(userProfileResponse.getEmail(), email);
	}

	@Test(priority = 2)
	public void verifyUpdateUserProfileWithPutRequest() {
		String username = ConfigManager.getInstance().getProperty("username");
		String password = ConfigManager.getInstance().getProperty("password");
		String email = ConfigManager.getInstance().getProperty("email");

		LoginRequest loginRequest = new LoginRequest.LoginRequestBuilder().withUsername(username).withPassword(password)
				.build();
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String authToken = loginResponse.getToken();

		UserProfileRequest userProfileRequest = new UserProfileRequest.UserProfileRequestBuilder()
				.withFirstName("Prathamesh").withLastName("Dhasade").withEmail(email).withMobileNumber("9834530434")
				.build();
		UserProfileService userProfileService = new UserProfileService();
		response = userProfileService.updateUserProfileWithPutRequest(authToken, userProfileRequest);

		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		assertNotNull(userProfileResponse.getId());
		assertEquals(userProfileResponse.getUsername(), username);
		assertEquals(userProfileResponse.getEmail(), email);
		assertEquals(userProfileResponse.getFirstName(), "Prathamesh");
		assertEquals(userProfileResponse.getLastName(), "Dhasade");
		assertEquals(userProfileResponse.getMobileNumber(), "9834530434");
	}

	@Test(priority = 3)
	public void verifyUpdateUserProfileWithPatchRequest() {
		String username = ConfigManager.getInstance().getProperty("username");
		String password = ConfigManager.getInstance().getProperty("password");
		String email = ConfigManager.getInstance().getProperty("email");

		LoginRequest loginRequest = new LoginRequest.LoginRequestBuilder().withUsername(username).withPassword(password)
				.build();
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String authToken = loginResponse.getToken();

		UserProfileRequest userProfileRequest = new UserProfileRequest.UserProfileRequestBuilder()
				.withFirstName("Prathamesh").withLastName("Dhasade").withEmail(email).withMobileNumber("9834530434")
				.withAddress("Pune").build();
		UserProfileService userProfileService = new UserProfileService();
		response = userProfileService.updateUserProfileWithPutRequest(authToken, userProfileRequest);

		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		assertNotNull(userProfileResponse.getId());
		assertEquals(userProfileResponse.getUsername(), username);
		assertEquals(userProfileResponse.getEmail(), email);
		assertEquals(userProfileResponse.getFirstName(), "Prathamesh");
		assertEquals(userProfileResponse.getLastName(), "Dhasade");
		assertEquals(userProfileResponse.getMobileNumber(), "9834530434");
	}

	@Test(priority = 4)
	public void verifyChangePassword() {
		String username = ConfigManager.getInstance().getProperty("username");
		String password = ConfigManager.getInstance().getProperty("password");

		LoginRequest loginRequest = new LoginRequest.LoginRequestBuilder().withUsername(username).withPassword(password)
				.build();
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String authToken = loginResponse.getToken();

		ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest.ChangePasswordRequestBuilder()
				.withCurrentPassword(password).withNewPassword(password).withConfirmPassword(password).build();
		UserProfileService userProfileService = new UserProfileService();
		response = userProfileService.changePassword(authToken, changePasswordRequest);
		logger.info("Change password response body: " + response.asPrettyString());
	}

	@Test(priority = 5)
	public void verifyDeleteUserProfile() {
		String username = ConfigManager.getInstance().getProperty("username");
		String password = ConfigManager.getInstance().getProperty("password");

		LoginRequest loginRequest = new LoginRequest.LoginRequestBuilder().withUsername(username).withPassword(password)
				.build();
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String authToken = loginResponse.getToken();
		int id = loginResponse.getId();

		UserProfileService userProfileService = new UserProfileService();
		response = userProfileService.deleteUserProfile(authToken, id);

		assertEquals(response.asPrettyString(), "User profile deleted successfully");
	}
}
