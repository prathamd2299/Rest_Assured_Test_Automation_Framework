package com.bank.api.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.bank.api.utilities.LoggerUtility;

public class TestListener implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		LoggerUtility.info("Test Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LoggerUtility.info("Test passed: " + result.getName() + "\n");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LoggerUtility.info("Test failed: " + result.getName() + "\n");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LoggerUtility.info("Test skipped: " + result.getName() + "\n");
	}

	@Override
	public void onStart(ITestContext context) {
		LoggerUtility.info("Test Suite Started: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		LoggerUtility.info("Test Suite Finished: " + context.getName());
	}
}
