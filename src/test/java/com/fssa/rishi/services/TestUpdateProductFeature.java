package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestUpdateProductFeature {

	public static void main(String[] args) {
		Date uploadDate = Date.valueOf("2003-08-01");

		ProductDetails product = new ProductDetails(98765511, "Apple", 40, 30, "It is a nice product", null, "Trichy", "Fruit", "Gobi", 987654321, 456789, uploadDate);

		ProductService productService = new ProductService();
		try {
			productService.UpdateProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateSuccess() {
		ProductService productService = new ProductService();
		Date uploadDate = Date.valueOf("2003-08-01");

		ProductDetails product = new ProductDetails(98765321, "Ajai", 50, 120, "It is a good product", null, "Erode", "Fruit", "Gobi", 987654321, 456789, uploadDate);

		try {
			assertTrue(productService.UpdateProduct(product));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
	
	@Test
	public void testInavalidUpdateSuccess() {
		ProductService productService = new ProductService();
		Date uploadDate = Date.valueOf("2003-08-01");

		ProductDetails product = new ProductDetails(98765321, "Apple", 50, 120, "It is a good product", null, "Erode", "Fruit", "Gobi", 987654321, 456789, uploadDate);

		try { 
			assertFalse(productService.UpdateProduct(product));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInavalidUpdateFailures() {
	    ProductService productService = new ProductService();
	    Date uploadDate = Date.valueOf("2003-08-01");

	    ProductDetails invalidProduct = new ProductDetails(00000000000, "74t677", -10, -50, "Invalid product description",
	            null, "8978656756", "good fruit", "767ghjbygfyug7647", 987654321, 456789, uploadDate);

	    try {
	        assertFalse(productService.UpdateProduct(invalidProduct));
	    } catch (ServiceException e) {
	        e.printStackTrace();
	    }
	}

}
