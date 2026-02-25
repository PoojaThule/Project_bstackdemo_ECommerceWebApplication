package com.bstackdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bstackdemo.utilis.WaitUtils;

public class CartPage {
	WebDriver driver;
	WaitUtils waitutil;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitutil = new WaitUtils(driver);
	}

	@FindBy(xpath = "//p[@class='title']")
	WebElement cartPageTitle;
	@FindBy(xpath = "//span[@class='bag__quantity']")
	WebElement bagQuantity;
	@FindBy(xpath = "//div[@class='shelf-item__del']")
	WebElement itemCloseButton;

	public String getcartPageTitle() {
		return cartPageTitle.getText();
	}

	public String getBagQuantity() {
		return bagQuantity.getText();
	}

	public void removeItemFromCart(int item) {
		waitutil.waitforElementTobeClickable(bagQuantity);
		bagQuantity.click();
		for (int i = 1; i <= item; i++) {
			waitutil.waitforElementTobeClickable(itemCloseButton);
			itemCloseButton.click();
		}
	}
}
