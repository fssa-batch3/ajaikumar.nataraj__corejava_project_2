package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

class TestReadProductFeature {
	@Test
	void testReadUserProductDetails() {
		ProductService productService = new ProductService();
		try {
			List<ProductDetails> result = productService.readProductDetails();
			for (ProductDetails output : result) {
				System.out.println(output.toString());
			}
			assertNotNull(result);

		} catch (ServiceException e) {
			e.printStackTrace(); 
			fail(); 

		} 
	}
}
