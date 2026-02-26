package com.bstackdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bstackdemo.utilis.WaitUtils;

public class CheckoutPage {
	WebDriver driver;
	WaitUtils waitutil;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitutil = new WaitUtils(driver);
	}

	@FindBy(xpath = "//span[@class='cart-priceItem-value']")
	WebElement itemPriceOnCheckOutPage;
	@FindBy(id="firstNameInput") WebElement firstName;
	@FindBy(id="lastNameInput") WebElement lastName;
	@FindBy(id="addressLine1Input") WebElement addressLine;
	@FindBy(id="provinceInput") WebElement state;
	@FindBy(id="postCodeInput") WebElement postCode;
	@FindBy(xpath="//button[text()='Submit']") WebElement submit;
	@FindBy(id = "confirmation-message") WebElement confirmationMessage;
	@FindBy(partialLinkText = "Download order receipt") WebElement orderReceiptLink;
	
	public String getItemPriceOnCheckOutPage() {
		return itemPriceOnCheckOutPage.getText();
	}
	
	public void buyerInfo(String fname, String lname, String address, String st, String code) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		addressLine.sendKeys(address);
		state.sendKeys(st);
		postCode.sendKeys(code);
		submit.click();
	}
	
	public String getConfirmationMessage() {
		waitutil.waitforElementVisibility(orderReceiptLink);
		return confirmationMessage.getText();
	}

}
