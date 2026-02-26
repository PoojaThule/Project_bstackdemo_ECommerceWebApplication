package com.bstackdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bstackdemo.utilis.WaitUtils;

public class ProductPage {
	WebDriver driver;
	WaitUtils waitutil;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitutil = new WaitUtils(driver);
	}

	@FindBy(className = "float-cart__close-btn")
	WebElement cartCloseButton;
	@FindBy(xpath = "//div[@id='1']//p")
	WebElement firstElementName;
	@FindBy(xpath = "//div[@id='1']/div[3]/div[1]")
	WebElement firstElementPrice;

	public String getfirstElementName() {
		return firstElementName.getText();
	}

	public String getfirstElementPrice() {
		return firstElementPrice.getText();
	}

	public void addItemstoCart(int item) {
		for (int i = 1; i <= item; i++) {
			driver.findElement(By.xpath("//div[@id='" + i + "']//div[4]")).click();
			waitutil.waitforElementTobeClickable(cartCloseButton);
			if (item != 1) {
				cartCloseButton.click();
			}
		}
	}

}
