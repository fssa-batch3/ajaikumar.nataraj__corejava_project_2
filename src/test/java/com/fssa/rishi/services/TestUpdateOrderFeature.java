package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Order;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestUpdateOrderFeature {
	@Test 
	void testUpdateOrderSuccess() throws ServiceException {
		long id = 1695644255823L;
		long user_id = 1695644170054L;
		long product_id = 1695584103703L;
		LocalDate currentDate = LocalDate.now();

		long phone = 9876543214L;
		Order order = new Order(id, user_id, product_id, "Apple", 50, 120, phone, "10, gandhi street, gobi", "Erode",
				638313, currentDate, 0);
		OrderService Service = new OrderService();
		try {
			Service.updateOrder(order);
		} catch (ServiceException e) {  
			e.printStackTrace();
			fail();
		}   
	}  
}
