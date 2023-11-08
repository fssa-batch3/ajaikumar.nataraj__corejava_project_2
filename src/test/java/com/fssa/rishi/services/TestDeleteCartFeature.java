package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.services.exceptions.ServiceException;

class TestDeleteCartFeature {

	@Test
	void testDeleteCart() {
		long id = 1698900054771L;

		CartService cartService = new CartService();

		try {
			assertTrue(cartService.deleteCart(id));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
}
