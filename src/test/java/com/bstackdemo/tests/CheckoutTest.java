package com.bstackdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
	// TC_007: Place order with valid details
	@Test
	public void TC_007_placeOrderWithValidDetails() {
		productpage.addItemstoCart(1);
		String firstItemPrice = productpage.getfirstElementPrice();
		Assert.assertEquals(productpage.getfirstElementName(), cartpage.getcartPageTitle());
		cartpage.checkout();
		loginpage.userLogin("demouser", "testingisfun99");
		loginpage.logIn();
		Assert.assertEquals(checkoutpage.getItemPriceOnCheckOutPage(), firstItemPrice);
		checkoutpage.buyerInfo("Pooja", "Thule", "Mumbai", "Maharashtra", "37");
		Assert.assertEquals(checkoutpage.getConfirmationMessage(), "Your Order has been successfully placed.");
	}
	//TC_008: Checkout flow without adding items (negative test)
	@Test
	public void TC_008_CheckOutWithoutAddingItem() {
		
	}
}
