package com.bank.api.services;

import io.restassured.response.Response;
import static com.bank.api.endpoints.APIEndpoints.*;

import com.bank.api.model.requests.*;

public class UserProfileService extends BaseService {
//	private static final String BASE_PATH = "/api/users";

	public Response getUserProfile(String authToken) {
		attachToken(authToken);
		return getRequest(getUserProfileEndpoint);
	}

	public Response updateUserProfileWithPutRequest(String authToken, UserProfileRequest payload) {
		attachToken(authToken);
		return putRequest(payload, updateUserProfileEndpoint);
	}

	public Response updateUserProfileWithPatchRequest(String authToken, UserProfileRequest payload) {
		attachToken(authToken);
		return patchRequest(payload, updateUserProfileEndpoint);
	}

	public Response changePassword(String authToken, ChangePasswordRequest payload) {
		attachToken(authToken);
		return putRequest(payload, chnagePasswordUserProfileEndpoint);
	}

	public Response deleteUserProfile(String authToken, int value) {
		attachToken(authToken);
		return deleteRequestWithOneQueryParameter("confirmationCode", value, deleteUserProfileEndpoint);
	}
}
