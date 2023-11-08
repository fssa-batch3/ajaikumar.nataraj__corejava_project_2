package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Order;
import com.fssa.rishi.services.exceptions.ServiceException;

class TestRegisterOrderFeature {

	@Test
	void testRegisterOrderSuccess() {
		long uniqueID = System.currentTimeMillis();
		long product_id = 1698216798106L;
		long buyer_id = 1697771072477L;
		long sellerId = 1697771072477L;
		LocalDate currentDate = LocalDate.now();

		long phone = 9876543214L;
		Order order = new Order(uniqueID, buyer_id, sellerId, product_id, null, "Apple", 50, 120, phone, "10, gandhi street, gobi", "Erode",
				638313, currentDate, 0);
		// (long id, long productId, long buyerId, String name, int price, int quantity)
		OrderService Service = new OrderService();
 
		try {
			assertTrue(Service.createOrder(order));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

	}
}
