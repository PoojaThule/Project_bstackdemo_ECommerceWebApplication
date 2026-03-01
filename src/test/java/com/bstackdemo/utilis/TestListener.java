package com.bstackdemo.utilis;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bstackdemo.tests.BaseTest;

public class TestListener implements ITestListener {

	ExtentReports extent = ExtentReport.getReportObj();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		String path = BaseTest.captureScreenshot(BaseTest.driver, result.getName());
		test.addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, "Test Failed");
		test.log(Status.INFO, result.getThrowable().getMessage());

		String path = BaseTest.captureScreenshot(BaseTest.driver, result.getName());
		test.addScreenCaptureFromPath(path);

	}

	@Override
	public void onFinish(org.testng.ITestContext context) {
		extent.flush();
	}
}