package com.demoshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

	@Test
	public void  verifyUserIsAbletoAddProductToCart() {
		
		loginPage.searchProduct(prop.getProperty("productToSearch"));
		
		addToCartPage.viewLaptop();
		
		String actualProductName= addToCartPage. getProductTitle();
	    Assert.assertEquals(actualProductName, prop.getProperty("expectedProductName"), "Product does not match");
		
	    addToCartPage.addProductToCart();
	    
	    String actualText = addToCartPage.getConfirmationMsg();
	   
        Assert.assertEquals(actualText, prop.getProperty("expectedText"), "Product is not added to cart");
		
	}
}
