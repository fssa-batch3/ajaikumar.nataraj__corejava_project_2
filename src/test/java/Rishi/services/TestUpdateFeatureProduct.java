package Rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import Rishi.model.ProductDetails;
import Rishi.services.exceptions.ServiceException;

public class TestUpdateFeatureProduct {

	public static void main(String[] args) {
		Date dob = Date.valueOf("2003-08-01");

		ProductDetails product = new ProductDetails(98765321, "Ajai", 50, 120, "It is a nice product", null, "Erode", "Fruit", "Gobi", 987654321, 456789, dob);

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
		Date dob = Date.valueOf("2003-08-01");

		ProductDetails product = new ProductDetails(98765321, "Ajai", 50, 120, "It is a good product", null, "Erode", "Fruit", "Gobi", 987654321, 456789, dob);

		try {
			assertTrue(productService.UpdateProduct(product));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
	
	@Test
	public void testInavalidUpdateSuccess() {
		ProductService productService = new ProductService();
		Date dob = Date.valueOf("2003-08-01");

		ProductDetails product = new ProductDetails(98765321, "Ajai", 50, 120, "It is a good product", null, "Erode", "Fruit", "Gobi", 987654321, 456789, dob);

		try {
			assertFalse(productService.UpdateProduct(product));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
}
