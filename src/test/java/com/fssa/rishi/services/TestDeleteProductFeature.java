package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.services.exceptions.ServiceException;

 class TestDeleteProductFeature {
	public static void main(String[] args) {
		long id = 1693879162918L;
		ProductDetails user1 = new ProductDetails(id);

		ProductService productService = new ProductService();

		try {
			assertTrue(productService.deleteProduct(user1));
		} catch (ServiceException e) {
			e.printStackTrace(); 
			fail(); 
		}
	}
}  