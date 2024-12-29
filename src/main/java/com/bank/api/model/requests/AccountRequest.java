package com.bank.api.model.requests;

public class AccountRequest {
	private String accountType;
	private String branch;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public static class AccountRequestBuilder {
		private AccountRequest accountRequest;

		public AccountRequestBuilder() {
			this.accountRequest = new AccountRequest();
		}

		public AccountRequestBuilder withAccountType(String accountType) {
			this.accountRequest.setAccountType(accountType);
			return this;
		}

		public AccountRequestBuilder withBranch(String branch) {
			this.accountRequest.setBranch(branch);
			return this;
		}

		public AccountRequest build() {
			return this.accountRequest;
		}
	}
}
