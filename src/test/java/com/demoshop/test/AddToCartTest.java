package com.demoshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

	@Test
	public void  verifyUserIsAbletoAddProductToCart() {
		
		loginPage.searchProduct(prop.getProperty("productToSearch"));
		
		addToCartPage.viewLaptop();
		
		String actualProductName= addToCartPage. getProductTitle();
	    Assert.assertEquals(prop.getProperty("expectedProductName"), actualProductName, "Product does not match");
		
	    addToCartPage.addProductToCart();
	    
	    String actualText = addToCartPage.getConfirmationMsg();
	   
        Assert.assertEquals(prop.getProperty("expectedText"), actualText, "Product is not added to cart");
		
	}
}
