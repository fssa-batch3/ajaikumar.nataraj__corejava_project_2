package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestRegisterProductFeature {

	
	public static void main(String[] args) {
		Date dob = Date.valueOf("2003-08-01");

		ProductDetails product = new ProductDetails(98765511, "Apple", 50, 120, "It is a good product", null, "Erode", "Fruit", "Gobi", 987654321, 456789, dob);
		ProductService productService = new ProductService();

		try {
			productService.registerProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testRegistrationSuccess() {
		Date dob = Date.valueOf("2003-08-01");

		ProductService productService = new ProductService();
		ProductDetails product = new ProductDetails(987653210, "Ajai", 50, 120, "", null, "Erode", "Fruit", "Gobi", 987654321, 456789, dob);
		try {
			assertTrue(productService.registerProduct(product));
		} catch (ServiceException e) {
			e.printStackTrace();
			
		}
	}

	@Test
	public void testInvalidPassword() {
		Date dob = Date.valueOf("2003-08-01");

		ProductService productService = new ProductService();
		ProductDetails product = new ProductDetails(987653210, "Ajai", 50, 120, "", null, "Erode", "Fruit", "Gobi", 987654321, 456789, dob);
		try {
			assertFalse(productService.registerProduct(product));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testProductNull() {

		ProductService productService = new ProductService();
		ProductDetails product = null;
		try {
			assertFalse(productService.registerProduct(product));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

}
