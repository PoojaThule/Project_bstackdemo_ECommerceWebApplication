package com.bstackdemo.utilis;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	static WebDriverWait wait;
	public WaitUtils(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void waitforElementVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitforElementTobeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
