package com.bank.api.model.responses;

public class AccountResponse {
	private String accountNumber;
	private String accountType;
	private double balance;
	private String status;
	private String branch;
	private String createdAt;
	private String ownerName;

	public AccountResponse() {
	}

	public AccountResponse(String accountNumber, String accountType, double balance, String status, String branch,
			String createdAt, String ownerName) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.status = status;
		this.branch = branch;
		this.createdAt = createdAt;
		this.ownerName = ownerName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public double getBalance() {
		return balance;
	}

	public String getStatus() {
		return status;
	}

	public String getBranch() {
		return branch;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getOwnerName() {
		return ownerName;
	}
}
