package com.bank.api.model.requests;

public class AccountRequest {
	private String accountType;
	private String branch;

	public AccountRequest(AccountRequestBuilder builder) {
		super();
		this.accountType = builder.accountType;
		this.branch = builder.branch;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getBranch() {
		return branch;
	}

	public static class AccountRequestBuilder {
		private String accountType;
		private String branch;

		public AccountRequestBuilder withAccountType(String accountType) {
			this.accountType = accountType;
			return this;
		}

		public AccountRequestBuilder withBranch(String branch) {
			this.branch = branch;
			return this;
		}

		public AccountRequest build() {
			return new AccountRequest(this);
		}
	}
}
