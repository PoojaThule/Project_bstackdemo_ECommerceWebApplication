package com.bstackdemo.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.bstackdemo.pages.CartPage;
import com.bstackdemo.pages.CheckoutPage;
import com.bstackdemo.pages.LoginPage;
import com.bstackdemo.pages.ProductPage;
import com.bstackdemo.utilis.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Listeners(com.bstackdemo.utilis.TestListener.class)
public class BaseTest {
	// BaseTest.java – Initializes WebDriver and loads configs
	public static WebDriver driver;
	public LoginPage loginpage;
	public CartPage cartpage;
	public ProductPage productpage;
	public CheckoutPage checkoutpage;
	public static Logger logger = LogManager.getLogger(BaseTest.class);
	
	@BeforeMethod
	public void initDriver() {
		driver = WebDriverFactory.getWebdriver("Chrome");
		logger.info("Browser is launching");
		driver.get("https://bstackdemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginpage = new LoginPage(driver);
		productpage = new ProductPage(driver);
		cartpage = new CartPage(driver);
		checkoutpage = new CheckoutPage(driver);
	}

	@AfterMethod
	public void closeBrowser() {
		WebDriverFactory.CloseDriver();
		logger.info("Driver is closing as Test case is completed");
	}

	public static String captureScreenshot(WebDriver driver, String testName) {

		String folderPath = System.getProperty("user.dir") + "/Screenshots";

		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdir();
		}

		String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destinationPath = folderPath + "/" + testName + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destinationPath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destinationPath;
	}
}
