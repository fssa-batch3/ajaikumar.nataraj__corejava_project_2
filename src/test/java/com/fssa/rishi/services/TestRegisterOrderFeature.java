package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Order;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestRegisterOrderFeature {

	@Test
	void testRegisterOrderSuccess() {
		long uniqueID = System.currentTimeMillis();
		long product_id = 1695630238564L;
		long buyer_id = 1695623361104L;
		LocalDate currentDate = LocalDate.now();

		Order order = new Order(uniqueID, buyer_id, product_id, "Apple", 50, 120, "10, gandhi street, gobi", "Erode",
				638313, currentDate);
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
