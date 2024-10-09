package com.demoshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.PageActions;

public class AddToCartPage extends PageActions{
	
	private WebDriver driver;
	
	public AddToCartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css=".product-title")
	private WebElement laptop;
	
	@FindBy(css=".product-name")
	private WebElement productTitle;
	
	@FindBy(id="add-to-cart-button-31")
	private WebElement addToCartBtn;
	
	@FindBy(css=".content")
	private WebElement confirmationMsg;
	
	@FindBy(css=".header-links .ico-cart ")
	private WebElement shoppingCartHeader;
	
	
	public void viewLaptop() {
		clickElement(laptop);
	}
	
	public String getProductTitle() {
		return getElementText(productTitle);
	}
	
	public void addProductToCart() {
	//public AddToCartPage addProductToCart() {
		clickElement(addToCartBtn);
		//return this;
	}
	
	public String getConfirmationMsg() {
		return getElementText(confirmationMsg);
	}
	
	public void navigateToCart() {
		clickElement(shoppingCartHeader);
	}

}
