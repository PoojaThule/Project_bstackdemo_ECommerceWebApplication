package com.bstackdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	// TC_001: Login with valid credentials (UserName: demouser, password: testingisfun99)
	@Test (priority = 1)
	public void TC_001_loginWithValidData() {
		loginpage.signIn();
		loginpage.userLogin("demouser", "testingisfun99");
		loginpage.logIn();
		Assert.assertTrue(loginpage.isUserLoggedIn(), "Test Case Fail as Logout button is not displayed.");
		logger.info("TC_001 is passed as user logged in with valid credentials");
	}

	// TC_002: Login with invalid credentials
	@Test (priority = 2)
	public void TC_002_loginWithInValidData() {
		loginpage.signIn();
		loginpage.userLogin("locked_user", "testingisfun99");
		loginpage.logIn();
		Assert.assertEquals(loginpage.getErrorMessage(), "Your account has been locked.", "Test Failed");
		logger.info("TC_002 is passed as user login failed");

	}

	// TC_003:Login with empty username/password
	@Test (priority = 3)
	public void TC_003_loginWithEmptyData() {
		loginpage.signIn();
		loginpage.logIn();
		Assert.assertEquals(loginpage.getErrorMessage(), "Invalid Username", "Test Failed");
		logger.info("TC_003 is passed as user is not able to login with empty data");

	}

}
