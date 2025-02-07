package com.bank.api.testData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.bank.api.model.requests.AccountRequest;

public class AccountData {
	private Random random = new Random();

	public AccountRequest createUserAccountData() {
		List<String> accountTypes = new ArrayList<>(Arrays.asList("SAVINGS", "CURRENT"));
		int randomNum = random.nextInt(accountTypes.size());
		String accountType = accountTypes.get(randomNum);

		String branch = "Pune";
		return new AccountRequest.AccountRequestBuilder().withAccountType(accountType).withBranch(branch).build();
	}
}
