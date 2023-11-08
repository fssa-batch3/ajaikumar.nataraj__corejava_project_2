package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Cart;
import com.fssa.rishi.services.exceptions.ServiceException;

class TestRegisterCartFeature {

	@Test
	void testAddCartSuccess() {
		long uniqueID = System.currentTimeMillis();
		long product_id = 1698212647692L;
		long buyer_id = 1697770993380L;
		long sellerId = 1697771072477L;
		Cart cart = new Cart(uniqueID, buyer_id, sellerId, product_id, null, "Apple", 50, 120);
		// (long id, long productId, long buyerId, String name, int price, int quantity)
		CartService Service = new CartService();

		try {
			assertTrue(Service.createCart(cart));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

	}

}
