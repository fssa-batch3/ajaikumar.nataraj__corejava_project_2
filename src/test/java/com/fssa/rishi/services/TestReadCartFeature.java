package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Cart;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestReadCartFeature {
	@Test
	void testReadUserCart() {
		long userId = 1697771072477L;
		CartService Service = new CartService();
		try {
			List<Cart> result = Service.getCartByUserId(userId);
			for (Cart output : result) {
				System.out.println(output.toString());
			} 
			assertNotNull(result);

		} catch (ServiceException e) { 
			e.printStackTrace();  
			fail(); 
 
		} 
	}
}
