package com.demoshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.utils.DataUtils;

public class ExcelRegisterationTest extends BaseTest{

	@Test
	public void verifyUserIsAbleToRegisterUsingCorrectCreds() {
		
		loginPage.navigateToRegisterationSection();
		DataUtils.initUserData();
		registerPage.setUserData(DataUtils.firstName, DataUtils.lastName, DataUtils.uniqueEmail, DataUtils.password);
	    String expectedEmail = loginPage.getLoggedEmail();
		Assert.assertEquals(DataUtils.uniqueEmail, expectedEmail, "Registered email is differents");
		
	}
}
