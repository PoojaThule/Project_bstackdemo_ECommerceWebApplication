package com.bstackdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bstackdemo.utilis.WaitUtils;

public class LoginPage {

	// encapsulation = private data + public method
	WebDriver driver;
	WaitUtils waitutil;

	// initialize driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitutil = new WaitUtils(driver);
	}

	// data member (locator)
	@FindBy(xpath = "//span[text()='Sign In']")
	WebElement signIn;
	@FindBy(id = "username")
	WebElement UserName;
	@FindBy(id = "password")
	WebElement Passwrod;
	@FindBy(id = "login-btn")
	WebElement Login;
	@FindBy(xpath = "//span[text()='Logout']")
	WebElement Logout;
	@FindBy(tagName = "h3")
	WebElement Error;

	public String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}

	// method (functionality to test)
	public void signIn() {
		waitutil.waitforElementTobeClickable(signIn);
		signIn.click();
	}

	public void userLogin(String uname, String pass) {
		waitutil.waitforElementVisibility(Login);
		UserName.click();
		driver.findElement(By.xpath("//div[text()='" + uname + "']")).click();
		Passwrod.click();
		driver.findElement(By.xpath("//div[text()='" + pass + "']")).click();
	}

	public void logIn() {
		waitutil.waitforElementTobeClickable(Login);
		Login.click();
	}

	public boolean isUserLoggedIn() {
		waitutil.waitforElementTobeClickable(Logout);
		return Logout.isDisplayed() && driver.getCurrentUrl().contains("true");
	}

	public String getErrorMessage() {
		return Error.getText();
	}
}
