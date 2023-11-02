package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Order;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestUpdateOrderFeature {
	@Test 
	void testUpdateOrderSuccess() throws ServiceException {
		long id = 1698830180948L;
		long user_id = 1697771072477L;
		long product_id = 1698216798106L;
		long sellerId = 1697771072477L;
		LocalDate currentDate = LocalDate.now();

		long phone = 9876543214L;
		Order order = new Order(id, user_id, sellerId, product_id, null, "Apple", 50, 120, phone, "10, gandhi street, gobi", "Erode",
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
