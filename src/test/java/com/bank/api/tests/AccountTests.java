package com.bank.api.tests;

import static org.testng.Assert.*;

import org.testng.annotations.*;

import com.bank.api.base.BaseTest;
import com.bank.api.listeners.TestListener;
import com.bank.api.model.requests.*;
import com.bank.api.model.responses.*;
import com.bank.api.services.*;
import com.bank.api.testData.AccountData;
import com.bank.api.utilities.*;

import io.restassured.response.Response;

@Listeners(TestListener.class)

public class AccountTests extends BaseTest {
	private AccountData accountData = new AccountData();

	@Test(priority = 1)
	public void verifyCreateUserAccount() {
		String username = ConfigManager.getInstance().getProperty("username");
		String password = ConfigManager.getInstance().getProperty("password");

		LoginRequest loginRequest = new LoginRequest.LoginRequestBuilder().withUsername(username).withPassword(password)
				.build();
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String authToken = loginResponse.getToken();

		AccountRequest accountRequest = accountData.createUserAccountData();
		AccountService accountService = new AccountService();
		response = accountService.createUserAccount(authToken, accountRequest);

		AccountResponse userAccountResponse = response.as(AccountResponse.class);

		assertEquals(userAccountResponse.getAccountType(), accountRequest.getAccountType());
		assertEquals(userAccountResponse.getBranch(), accountRequest.getBranch());

		System.setProperty("accountType", accountRequest.getAccountType());
		System.setProperty("branch", accountRequest.getBranch());

		String accountNumber = userAccountResponse.getAccountNumber();
		System.setProperty("accountNumber", accountNumber);

		String userFullName = userAccountResponse.getOwnerName();
		System.setProperty("userFullName", userFullName);

		double accountBalance = userAccountResponse.getBalance();
		System.setProperty("accountBalance", String.valueOf(accountBalance));

		String accountStatus = userAccountResponse.getStatus();
		System.setProperty("accountStatus", accountStatus);
	}

	@Test(priority = 2, dependsOnMethods = "verifyCreateUserAccount")
	public void verifyGetUserAccountByAccountNumber() {
		String username = ConfigManager.getInstance().getProperty("username");
		String password = ConfigManager.getInstance().getProperty("password");

		String accountType = System.getProperty("accountType");
		String accountNumber = System.getProperty("accountNumber");
		String userFullName = System.getProperty("userFullName");
		String branch = System.getProperty("branch");
		String accountBalance = System.getProperty(String.valueOf("accountBalance"));
		String accountStatus = System.getProperty("accountStatus");

		LoginRequest loginRequest = new LoginRequest.LoginRequestBuilder().withUsername(username).withPassword(password)
				.build();
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String authToken = loginResponse.getToken();

		AccountService accountService = new AccountService();
		response = accountService.getUserAccountByAccountNumber(authToken, accountNumber);

		AccountResponse userAccountResponse = response.as(AccountResponse.class);
		assertEquals(userAccountResponse.getAccountType(), accountType);
		assertEquals(userAccountResponse.getBranch(), branch);
		assertEquals(userAccountResponse.getAccountNumber(), accountNumber);
		assertEquals(userAccountResponse.getOwnerName(), userFullName);
		assertEquals(userAccountResponse.getBalance(), Double.parseDouble(accountBalance));
		assertEquals(userAccountResponse.getStatus(), accountStatus);
	}

	@Test(priority = 3, dependsOnMethods = "verifyCreateUserAccount")
	public void verifyGetUserAccounts() {
		String username = ConfigManager.getInstance().getProperty("username");
		String password = ConfigManager.getInstance().getProperty("password");

		String accountType = System.getProperty("accountType");
		String accountNumber = System.getProperty("accountNumber");
		String userFullName = System.getProperty("userFullName");
		String branch = System.getProperty("branch");
		String accountBalance = System.getProperty(String.valueOf("accountBalance"));
		String accountStatus = System.getProperty("accountStatus");

		LoginRequest loginRequest = new LoginRequest.LoginRequestBuilder().withUsername(username).withPassword(password)
				.build();
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String authToken = loginResponse.getToken();

		AccountService accountService = new AccountService();
		response = accountService.getUserAccounts(authToken);

		AccountResponse[] userAccountResponse = response.as(AccountResponse[].class);
		for (AccountResponse account : userAccountResponse) {
			if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
				assertEquals(account.getAccountType(), accountType);
				assertEquals(account.getBranch(), branch);
				assertEquals(account.getAccountNumber(), accountNumber);
				assertEquals(account.getOwnerName(), userFullName);
				assertEquals(account.getBalance(), Double.parseDouble(accountBalance));
				assertEquals(account.getStatus(), accountStatus);
			}
		}
	}
}
