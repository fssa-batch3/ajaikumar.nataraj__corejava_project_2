package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.services.exceptions.ServiceException;

class TestRegisterProductFeature {

	@Test
	void testRegisterProductSuccess() {
		LocalDate uploadDate = LocalDate.now();
		long uniqueID = System.currentTimeMillis();

		ProductDetails product = new ProductDetails(uniqueID, "Apple", 50, 120, "It is a good product", null, "Erode",
				"Fruit", "Gobi", 1693567910255L, 456789, uploadDate);
		ProductService productService = new ProductService();

		try {
			assertTrue(productService.registerProduct(product));
		} catch (ServiceException e) {
			e.printStackTrace(); 
			fail();
		}  
 
	}  

	@Test
	void testRegisterProductFailure() {
		LocalDate uploadDate = LocalDate.now();
		long uniqueID = System.currentTimeMillis();

		ProductDetails product = new ProductDetails(uniqueID, "App123", 50, -120, "It is a good product", null, "gobi",
				"fruit", "Tn5t5", 1693240825858L, 000000, uploadDate);
		ProductService productService = new ProductService();

		try {
			assertFalse(productService.registerProduct(product));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testProductNull() throws ServiceException {

		ProductService productService = new ProductService();
		ProductDetails product = null;
		try {
			assertFalse(productService.registerProduct(product));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
