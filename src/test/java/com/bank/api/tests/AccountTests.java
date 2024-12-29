package com.bank.api.tests;

import static org.testng.Assert.*;

import java.util.*;

import org.testng.annotations.*;

import com.bank.api.base.BaseTest;
import com.bank.api.listeners.TestListener;
import com.bank.api.model.requests.*;
import com.bank.api.model.responses.*;
import com.bank.api.services.*;
import com.bank.api.utilities.*;

import io.restassured.response.Response;

@Listeners(TestListener.class)

public class AccountTests extends BaseTest {
	private static String username;
	private static String password;
	private static String email;
	private static int id;
	private static String authToken;
	private static String accountType;
	private static String branch;
	private static String userFullName;
	private static double accountBalance;
	private static String accountNumber;
	private static String accountStatus;

	private static Random random;

	@BeforeClass
	public void setData() {
		username = ConfigManager.getProperty("username");
		LoggerUtility.info("Username input is: " + username);

		password = ConfigManager.getProperty("password");
		LoggerUtility.info("Password input is: " + password);

		email = ConfigManager.getProperty("email");
		LoggerUtility.info("Email input is: " + email);

		List<String> accountTypes = new ArrayList<>(Arrays.asList("SAVINGS", "CURRENT"));
		random = new Random();
		int randomNum = random.nextInt(accountTypes.size());
		accountType = accountTypes.get(randomNum);

		branch = "Pune";
	}

	@Test(priority = 1)
	public void verifyCreateUserAccount() {
		LoginRequest loginRequest = new LoginRequest.LoginRequestBuilder().withUsername(username).withPassword(password)
				.build();
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoggerUtility.info("Login response body: " + response.asPrettyString());

		assertEquals(response.getStatusCode(), 200);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		authToken = loginResponse.getToken();
		id = loginResponse.getId();

		AccountRequest accountRequest = new AccountRequest.AccountRequestBuilder().withAccountType(accountType)
				.withBranch(branch).build();
		AccountService accountService = new AccountService();
		response = accountService.createUserAccount(authToken, accountRequest);
		LoggerUtility.info("Create user account response body: " + response.asPrettyString());

		AccountResponse userAccountResponse = response.as(AccountResponse.class);

		assertEquals(userAccountResponse.getAccountType(), accountType);
		assertEquals(userAccountResponse.getBranch(), branch);
		accountNumber = userAccountResponse.getAccountNumber();
		userFullName = userAccountResponse.getOwnerName();
		accountBalance = userAccountResponse.getBalance();
		accountStatus = userAccountResponse.getStatus();
	}

	@Test(priority = 2)
	public void verifyGetUserAccountByAccountNumber() {
		AccountService accountService = new AccountService();
		Response response = accountService.getUserAccountByAccountNumber(authToken, accountNumber);
		LoggerUtility.info("Get user account by account number response body: " + response.asPrettyString());

		AccountResponse userAccountResponse = response.as(AccountResponse.class);
		assertEquals(userAccountResponse.getAccountType(), accountType);
		assertEquals(userAccountResponse.getBranch(), branch);
		assertEquals(userAccountResponse.getAccountNumber(), accountNumber);
		assertEquals(userAccountResponse.getOwnerName(), userFullName);
		assertEquals(userAccountResponse.getBalance(), accountBalance);
		assertEquals(userAccountResponse.getStatus(), accountStatus);
	}

	@Test(priority = 3)
	public void verifyGetUserAccounts() {
		AccountService accountService = new AccountService();
		Response response = accountService.getUserAccounts(authToken);
		LoggerUtility.info("Get user accounts response body: " + response.asPrettyString());

		AccountResponse[] userAccountResponse = response.as(AccountResponse[].class);
		for (AccountResponse account : userAccountResponse) {
			if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
				assertEquals(account.getAccountType(), accountType);
				assertEquals(account.getBranch(), branch);
				assertEquals(account.getAccountNumber(), accountNumber);
				assertEquals(account.getOwnerName(), userFullName);
				assertEquals(account.getBalance(), accountBalance);
				assertEquals(account.getStatus(), accountStatus);
			}
		}
	}
}
