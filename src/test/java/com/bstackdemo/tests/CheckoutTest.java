package com.bstackdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
	// TC_007: Place order with valid details
	@Test (priority = 7)
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
		logger.info("TC_007 is passed as order places successfully");
	}
	//TC_008: Checkout flow without adding items (negative test)
	@Test (priority = 8)
	public void TC_008_CheckOutWithoutAddingItem() {
		cartpage.openCart();
		System.out.println(cartpage.isCheckoutButtonPresent());
		System.out.println(cartpage.getEmptyCartVisibility());
		Assert.assertTrue(cartpage.getEmptyCartVisibility());
		logger.info("TC_008 Passed: User cannot checkout with empty cart");
	}
}
