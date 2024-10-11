package com.demoshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.CheckoutUtils;
import com.demoshop.utils.PageActions;
import com.demoshop.utils.WaitUtils;

public class CheckOutPage extends PageActions {

private WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="removefromcart")			// first checkbox
	private WebElement checkBox1;
	
	@FindBy(id="termsofservice")			// second checkbox
	private WebElement checkBox2;
	
	@FindBy(id="checkout")					// checkout button
	private WebElement checkoutBtn;
	
	@FindBy(css=".page-title")				// checkout page title
	private WebElement checkOutHeading;		
	
	@FindBy(id="BillingNewAddress_CountryId")	// to select country name from static drop down
	private WebElement countryDropdown;
	
	@FindBy(id="BillingNewAddress_Company")		// to select company name 
	private WebElement companyName;
	
	@FindBy(id="BillingNewAddress_City")		// text box of city 
	private WebElement city;
	
	@FindBy(id="BillingNewAddress_Address1")
	private WebElement address1;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	private WebElement postalCode;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	private WebElement phoneNo;
	
	@FindBy(css=".button-1.new-address-next-step-button")		// continue btn after entering address
	private WebElement continueBtn;
	
//	@FindBy(id="shipping-address-select")		// confirming shipping address
//	private WebElement shippingAddress;

	@FindBy(css="#checkout-step-shipping [title='Continue']")	//continue after confirming shipping address
	private WebElement shippingAddressContinue;
	
	@FindBy(css=".button-1.shipping-method-next-step-button")
	private WebElement shippingMethodContinue;
	
	@FindBy(css="#payment-method-buttons-container [value='Continue']")
	private WebElement paymentMethodContinue;
	
	@FindBy(css=".button-1.payment-info-next-step-button")
	private WebElement paymentInfoContinue;
	
	@FindBy(css="#confirm-order-buttons-container .button-1.confirm-order-next-step-button")
	private WebElement confirmOrder;
	
	@FindBy(css=".section.order-completed strong")
	private WebElement orderPlacedTxt;
	
	
	public void clickCheckBox() {
		clickElement(checkBox1);
		clickElement(checkBox2);
	}
	
	public boolean isBox1Checked() {
		boolean isChecked1=checkBox1.isSelected();
		return isChecked1;
	}
	
	public boolean isBox2Checked() {
		boolean isChecked2=checkBox2.isSelected();
		return isChecked2;
	}
	
	public void clickCheckOutBtn() {
		clickElement(checkoutBtn);
	}
	
	public String checkOutTitle() {
		return getElementText(checkOutHeading);
	}
	
	
	public void orderConfirmation(){
		
		setTextBox(companyName, CheckoutUtils.getCompanyName());
		handleStaticDrowpdown(countryDropdown, "United States");
		setTextBox(city, CheckoutUtils.getCityName());
		setTextBox(address1, CheckoutUtils.getAddress1());
		setTextBox(postalCode, CheckoutUtils.getPostalCode());
		setTextBox(phoneNo, CheckoutUtils.getPhoneNo());
		clickElement(continueBtn);
		
		WaitUtils.waitUntilClickable(shippingAddressContinue, driver);
		clickElement(shippingAddressContinue);
		
		WaitUtils.waitUntilClickable(shippingMethodContinue, driver);
		clickElement(shippingMethodContinue);
		
		WaitUtils.waitUntilClickable(paymentMethodContinue, driver);
		clickElement(paymentMethodContinue);
		
		WaitUtils.waitUntilClickable(paymentInfoContinue, driver);
		clickElement(paymentInfoContinue);
		
		WaitUtils.waitUntilClickable(confirmOrder, driver);
		clickElement(confirmOrder);
	}
	
	public String orderPlacedMsg() {
	
		return getElementText(orderPlacedTxt);
	}
	
	
}
