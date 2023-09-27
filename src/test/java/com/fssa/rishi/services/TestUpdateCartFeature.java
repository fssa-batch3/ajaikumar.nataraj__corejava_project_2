package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Cart;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestUpdateCartFeature {
	@Test 
	void testUpdateCartrSuccess() throws ServiceException {
		long id = 1695650668031L;
		long user_id = 1695558515538L;
		long product_id = 1695644497779L;

		Cart product = new Cart(id, user_id, product_id, "Orange", 40, 30);

		CartService productService = new CartService();
		try {
			productService.updateCart(product);
		} catch (ServiceException e) {  
			e.printStackTrace();
			fail();
		}   
	}  
}
