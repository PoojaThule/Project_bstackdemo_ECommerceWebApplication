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
		System.out.println("Test Case Pass");
	}

	// TC_002: Login with invalid credentials
	@Test (priority = 2)
	public void TC_002_loginWithInValidData() {
		loginpage.signIn();
		loginpage.userLogin("locked_user", "testingisfun99");
		loginpage.logIn();
		Assert.assertEquals(loginpage.getErrorMessage(), "Your account has been locked.", "Test Failed");
		System.out.println("Test Case Pass");

	}

	// TC_003:Login with empty username/password
	@Test (priority = 3)
	public void TC_003_loginWithEmptyData() {
		loginpage.signIn();
		loginpage.logIn();
		Assert.assertEquals(loginpage.getErrorMessage(), "Invalid Username", "Test Failed");
		System.out.println("Test Case Pass");

	}

}
