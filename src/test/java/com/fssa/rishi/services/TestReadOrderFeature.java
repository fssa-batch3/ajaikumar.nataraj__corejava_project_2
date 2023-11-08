package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Order;
import com.fssa.rishi.services.exceptions.ServiceException;

class TestReadOrderFeature {
	@Test
	void testReadUserCart() {
		long userId = 1695644170054L;
		int status = 0;
		OrderService Service = new OrderService();
		try {
			List<Order> result = Service.getOrdersByUserId(userId, status);
			for (Order output : result) {
				System.out.println(output.toString());
			}
			assertNotNull(result);

		} catch (ServiceException e) {
			e.printStackTrace();
			fail();

		}
	}
}
