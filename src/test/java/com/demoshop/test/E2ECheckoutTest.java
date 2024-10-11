package com.demoshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.utils.DataUtils;

public class E2ECheckoutTest extends BaseTest{

	@Test(groups="Smoke")
	public void verifyNewUserRegistersAndCheckoutProduct(){
		
		//Registering user
		DataUtils.initUserData();
	    loginPage.navigateToRegisterationSection();
		registerPage.setUserData(DataUtils.firstName, DataUtils.lastName, DataUtils.uniqueEmail, DataUtils.password);
	    String expectedEmail = loginPage.getLoggedEmail();
		Assert.assertEquals(DataUtils.uniqueEmail, expectedEmail, "Registered email is differents");
		
		//Searching product
		loginPage.searchProduct(prop.getProperty("productToSearch"));
		
		//view product
		addToCartPage.viewLaptop();
		
		//assertion it's 14 inch Laptop
		String actualProductName= addToCartPage. getProductTitle();
	    Assert.assertEquals(prop.getProperty("expectedProductName"), actualProductName, "Product does not match");
		
	    
	    addToCartPage.addProductToCart();
		//assert that it is added to cart
	    String actualText = addToCartPage.getConfirmationMsg();   
        Assert.assertEquals(prop.getProperty("expectedText"), actualText, "Product is not added to cart");
		
        
		//navigate to cart
        addToCartPage.navigateToCart();
        String actualCartHeading= addToCartPage.cartTitle();
        Assert.assertEquals(prop.getProperty("expectedCartHeading"), actualCartHeading, "Not navigated to cart");
        
        
        //check the checkboxes
        checkOutPage.clickCheckBox();
        Assert.assertTrue(checkOutPage.isBox1Checked(), "The checkbox should be checked, but it's not.");
        Assert.assertTrue(checkOutPage.isBox2Checked(), "The checkbox should be checked, but it's not.");
        
        //move to checkout
        checkOutPage.clickCheckOutBtn();
        String actualCheckOutHeading= checkOutPage.checkOutTitle();
        Assert.assertEquals(prop.getProperty("expectedCheckOutHeading"), actualCheckOutHeading, "Not navigated to checkout page");
        
        //order confirmation
        checkOutPage.orderConfirmation();
        String actualOrderPlaced= checkOutPage.orderPlacedMsg();
        Assert.assertEquals(prop.getProperty("expectedOrderPlaced"), actualOrderPlaced, "Order not placed");
        
	}	
	
}
