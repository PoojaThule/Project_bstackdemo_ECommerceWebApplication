package com.bstackdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
	// TC_004: Add single item to cart
	@Test(priority = 4)
	public void TC_004_addSingleItemToCart() {
		productpage.addItemstoCart(1);
		Assert.assertEquals(productpage.getfirstElementName(), cartpage.getcartPageTitle());
		System.out.println("Test Case Pass");
	}

	// TC_005: Add multiple items to cart and verify cart count
	@Test(priority = 5)
	public void TC_005_addMultipleItemToCart() {
		productpage.addItemstoCart(4);
		Assert.assertEquals(cartpage.getBagQuantity(), "4");
		System.out.println("Test Case Pass");
	}

	// TC_006: Remove item from cart
	@Test(priority = 6)
	public void TC_006_removeItemFromCart() {
		int items = 3;
		productpage.addItemstoCart(items);
		cartpage.removeItemFromCart(items);
		Assert.assertEquals(cartpage.getBagQuantity(), "0");
		System.out.println("Test case pass");
	}
}
