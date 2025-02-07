package com.bank.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	public static final Logger logger = LogManager.getLogger(TestListener.class);

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test passed: " + result.getName() + "\n");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test failed: " + result.getName() + "\n");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test skipped: " + result.getName() + "\n");
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Finished: " + context.getName());
	}
}
