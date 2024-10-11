package com.demoshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductTest extends BaseTest{
	@Test
	public void  verifyUserIsAbletoRemoveProductFromCart() {
	
	loginPage.searchProduct(prop.getProperty("productToSearch"));
	addToCartPage.viewLaptop();	
	addToCartPage.addProductToCart();
	addToCartPage.navigateToCart();
	removeProductPage.removeProduct();
	String cartMsg = removeProductPage.emptyCartMessage();
	Assert.assertEquals(cartMsg, prop.getProperty("emptyCartMsg"), "product not removed");
	
}
	
}
