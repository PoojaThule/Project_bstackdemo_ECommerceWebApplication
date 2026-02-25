package com.bstackdemo.utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	static WebDriver driver = null;

	public static WebDriver getWebdriver(String browsername) {
		if (driver == null) {
			switch (browsername.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;

			case "firefox":
				driver = new FirefoxDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;

			default:
				throw new IllegalArgumentException("Invalid browser name: " + browsername);
			}
		}
		return driver;
	}

	public static void CloseDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
