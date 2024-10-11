package com.demoshop.utils;

import com.github.javafaker.Faker;

public class CheckoutUtils {
	
	public static Faker faker = new Faker();
	

	public static String getCompanyName() {
		return faker.company().name();
	}
	
	public static String getCityName() {
		return faker.address().cityName();
	}
	
	public static String getAddress1() {
		return faker.address().fullAddress();
	}
	
	public static String getPostalCode() {
		return faker.address().zipCode();
	}
	
	public static String getPhoneNo() {
		return faker.phoneNumber().phoneNumber();
	}
	
}
