package com.bstackdemo.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.bstackdemo.pages.CartPage;
import com.bstackdemo.pages.CheckoutPage;
import com.bstackdemo.pages.LoginPage;
import com.bstackdemo.pages.ProductPage;
import com.bstackdemo.utilis.WebDriverFactory;

public class BaseTest {
	// BaseTest.java – Initializes WebDriver and loads configs
	public static WebDriver driver;
	public LoginPage loginpage;
	public CartPage cartpage;
	public ProductPage productpage;
	public CheckoutPage checkoutpage;

	@BeforeMethod
	public void initDriver() {
		driver = WebDriverFactory.getWebdriver("Chrome");
		// logger.info("Browser is launching");
		driver.get("https://bstackdemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginpage = new LoginPage(driver);
		cartpage = new CartPage(driver);
		productpage = new ProductPage(driver);
		checkoutpage = new CheckoutPage(driver);
	}

	@AfterMethod
	public void closeBrowser() {
		WebDriverFactory.CloseDriver();
	}
}
