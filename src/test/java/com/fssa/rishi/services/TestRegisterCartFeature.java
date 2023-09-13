package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Cart;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestRegisterCartFeature {

	@Test
	void testAddCartSuccess() {
		LocalDate orderDate = LocalDate.now();
		long uniqueID = System.currentTimeMillis();
		long product_id = 1693980967758L;
		long buyer_id = 1693980967758L;
//		Cart cart = new Cart(uniqueID, product_id, buyer_id, "Apple", 50, 120, null, orderDate, "10, gandhi street, gobi");
//		// (long id, long productId, long buyerId, String name, int price, int quantity, String url, Date orderDate,String buyAddress)
//		CartService Service = new CartService(cart);
//
//		try {
//			assertTrue(Service.createCart(cart));
//		} catch (ServiceException e) {
//			e.printStackTrace();  
//			fail();
//		}  
 
	}
	
}
