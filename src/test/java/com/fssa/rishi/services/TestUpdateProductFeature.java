package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.validation.exceptions.InvalidProductException;

 class TestUpdateProductFeature {

	@Test 
	void testUpdateProduct() {
		Date uploadDate = Date.valueOf("2003-08-01");
		long id = 1693154157311L;
		long seller_id = 1693153795167L;

		ProductDetails product = new ProductDetails(id, "Orange", 40, 30, "It is a nice product", null, "Trichy",
				"Fruit", "Gobi", seller_id, 456789, uploadDate);

		ProductService productService = new ProductService();
		try {
			productService.UpdateProduct(product);
		} catch (InvalidProductException e) { 
			e.printStackTrace();
		}
	} 
 
	@Test 
	void testvalidUpdateSucces() {
		ProductService productService = new ProductService();
		Date uploadDate = Date.valueOf("2003-08-01");
		long id = 1693154157311L;
		long seller_id = 1693153795167L;

		ProductDetails product = new ProductDetails(id, "Orange", 40, 30, "It is a nice product", null, "Trichy",
				"Fruit", "Gobi", seller_id, 456789, uploadDate);

		try {
			assertTrue(productService.UpdateProduct(product));
		} catch (InvalidProductException e) {
			e.printStackTrace(); 
		}
	}

	@Test
	void testInavalidUpdateFailures() {
		ProductService productService = new ProductService();
		Date uploadDate = Date.valueOf("2003-08-01");

		ProductDetails invalidProduct = new ProductDetails(00000000000, "74t677", -10, -50,
				"Invalid product description", null, "8978656756", "good fruit", "767ghjbygfyug7647", 987654321, 456789,
				uploadDate);

		try {
			assertFalse(productService.UpdateProduct(invalidProduct));
		} catch (InvalidProductException e) {
			e.printStackTrace();
		}
	}

}
