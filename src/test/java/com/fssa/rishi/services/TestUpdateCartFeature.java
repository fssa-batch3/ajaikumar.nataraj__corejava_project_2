package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Cart;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestUpdateCartFeature {
	@Test 
	void testUpdateCartrSuccess() throws ServiceException {
		long id = 1695919204112L;
		
		int qty = 40;


		CartService productService = new CartService();
		try {
			productService.updateCart(id, qty);
		} catch (ServiceException e) {  
			e.printStackTrace();
			fail();
		}   
	}  
}
