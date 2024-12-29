package com.bank.api.services;

import static com.bank.api.endpoints.APIEndpoints.*;

import com.bank.api.model.requests.*;

import io.restassured.response.Response;

public class AccountService extends BaseService {
//	private static final String BASE_PATH = "/api/accounts";

	public Response getUserAccountByAccountNumber(String authToken, String accountNumber) {
		attachToken(authToken);
		return getRequestWithPathParameter(accountNumber, getUserAccountByAccountNumberEndpoint);
	}

	public Response getUserAccounts(String authToken) {
		attachToken(authToken);
		return getRequest(getUserAccountsEndpoint);
	}

	public Response createUserAccount(String authToken, AccountRequest payload) {
		attachToken(authToken);
		return postRequest(payload, createUserAccountEndpoint);
	}
}
