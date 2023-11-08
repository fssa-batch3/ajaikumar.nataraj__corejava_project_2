package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.services.exceptions.ServiceException;

class TestDeleteOrderFeature {
	@Test
	void testDeleteOrder() {
		long id = 1698830180948L;

		OrderService Service = new OrderService();

		try {
			assertTrue(Service.deleteOrder(id));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
}
