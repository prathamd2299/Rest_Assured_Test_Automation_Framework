package com.bank.api.tests;

import static org.testng.Assert.*;

import org.testng.annotations.*;

import com.bank.api.base.BaseTest;
import com.bank.api.listeners.TestListener;
import com.bank.api.model.requests.*;
import com.bank.api.model.responses.*;
import com.bank.api.services.*;
import com.bank.api.utilities.*;

import io.restassured.response.Response;

@Listeners(TestListener.class)
public class UserProfileManagementTests extends BaseTest {
	private static String username;
	private static String password;
	private static String email;
	private static int id;
	private static String authToken;

	@BeforeClass
	public void setData() {
		username = ConfigManager.getProperty("username");
		LoggerUtility.info("Username input is: " + username);

		password = ConfigManager.getProperty("password");
		LoggerUtility.info("Password input is: " + password);

		email = ConfigManager.getProperty("email");
		LoggerUtility.info("Email input is: " + email);
	}

	@Test(priority = 1)
	public void verifyGetUserProfile() {
		LoginRequest loginRequest = new LoginRequest.LoginRequestBuilder().withUsername(username).withPassword(password)
				.build();
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoggerUtility.info("Login response body: " + response.asPrettyString());

		assertEquals(response.getStatusCode(), 200);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		authToken = loginResponse.getToken();
		id = loginResponse.getId();

		UserProfileService userProfileService = new UserProfileService();
		response = userProfileService.getUserProfile(authToken);
		LoggerUtility.info("Get user profile response body: " + response.asPrettyString());

		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		assertEquals(userProfileResponse.getId(), id);
		assertEquals(userProfileResponse.getUsername(), username);
		assertEquals(userProfileResponse.getEmail(), email);
	}

	@Test(priority = 2)
	public void verifyUpdateUserProfileWithPutRequest() {
		UserProfileRequest userProfileRequest = new UserProfileRequest.UserProfileRequestBuilder()
				.withFirstName("Prathamesh").withLastName("Dhasade").withEmail(email).withMobileNumber("9834530434")
				.build();
		UserProfileService userProfileService = new UserProfileService();
		Response response = userProfileService.updateUserProfileWithPutRequest(authToken, userProfileRequest);
		LoggerUtility.info("Update user profile with put request response body: " + response.asPrettyString());

		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		assertEquals(userProfileResponse.getId(), id);
		assertEquals(userProfileResponse.getUsername(), username);
		assertEquals(userProfileResponse.getEmail(), email);
		assertEquals(userProfileResponse.getFirstName(), "Prathamesh");
		assertEquals(userProfileResponse.getLastName(), "Dhasade");
		assertEquals(userProfileResponse.getMobileNumber(), "9834530434");
	}

	@Test(priority = 3)
	public void verifyUpdateUserProfileWithPatchRequest() {
		UserProfileRequest userProfileRequest = new UserProfileRequest.UserProfileRequestBuilder()
				.withFirstName("Prathamesh").withLastName("Dhasade").withEmail(email).withMobileNumber("9834530434")
				.withAddress("Pune").build();
		UserProfileService userProfileService = new UserProfileService();
		Response response = userProfileService.updateUserProfileWithPutRequest(authToken, userProfileRequest);
		LoggerUtility.info("Update user profile with patch request response body: " + response.asPrettyString());

		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		assertEquals(userProfileResponse.getId(), id);
		assertEquals(userProfileResponse.getUsername(), username);
		assertEquals(userProfileResponse.getEmail(), email);
		assertEquals(userProfileResponse.getFirstName(), "Prathamesh");
		assertEquals(userProfileResponse.getLastName(), "Dhasade");
		assertEquals(userProfileResponse.getMobileNumber(), "9834530434");
	}

	@Test(priority = 4)
	public void verifyChangePassword() {
		ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest.ChangePasswordRequestBuilder()
				.withCurrentPassword(password).withNewPassword(password).withConfirmPassword(password).build();
		UserProfileService userProfileService = new UserProfileService();
		Response response = userProfileService.changePassword(authToken, changePasswordRequest);
		LoggerUtility.info("Change password response body: " + response.asPrettyString());
	}

	@Test(priority = 5)
	public void verifyDeleteUserProfile() {
		UserProfileService userProfileService = new UserProfileService();
		Response response = userProfileService.deleteUserProfile(authToken, id);
		LoggerUtility.info("Delete user profile with patch request response body: " + response.asPrettyString());

		assertEquals(response.asPrettyString(), "User profile deleted successfully");
	}
}
