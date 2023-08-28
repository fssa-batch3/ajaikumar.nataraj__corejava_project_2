package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.validation.exceptions.InvalidProductException;

class TestRegisterProductFeature {

	@Test
	void testRegisterProduct() {
		Date dob = Date.valueOf("2003-08-01");
		long uniqueID = System.currentTimeMillis();

		ProductDetails product = new ProductDetails(uniqueID, "Apple", 50, 120, "It is a good product", null, "Erode",
				"Fruit", "Gobi", 1692694755142L, 456789, dob);
		ProductService productService = new ProductService();

		try {
			productService.registerProduct(product);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test
	 void testRegistrationSuccess() {
		Date dob = Date.valueOf("2003-08-01");

		ProductService productService = new ProductService();
		ProductDetails product = new ProductDetails(987653210, "Ajai", 50, 120, "", null, "Erode", "Fruit", "Gobi",
				987654321, 456789, dob);
		try {
			assertTrue(productService.registerProduct(product));
		} catch (InvalidProductException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testProductNull() {

		ProductService productService = new ProductService();
		ProductDetails product = null;
		try {
			assertFalse(productService.registerProduct(product));
		} catch (InvalidProductException e) {
			e.printStackTrace();
		}

	}

}
