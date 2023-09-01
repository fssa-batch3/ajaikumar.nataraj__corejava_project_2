package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Seller;
import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

 class TestUpdateSellerFeature {
	@Test
	void testUpdateSellerSuccess() {
		Date dob = Date.valueOf("2003-08-01");
		long phoneNo = 8876543256L;
		long id = 1693450051273L;
		String email = "kannan@gmail.com";

		User user1 = new User(id, email, "Kannan", "Ajai@12345", phoneNo, "Erode", "TN",
				"12, gandhi street, gobi", dob, 987654, "Male");
		Seller user2 = new Seller(email, "12, gandhi street, gobi", "Own", id);

		UserService userService = new UserService();
		SellerService sellerService = new SellerService();

		try {
			assertTrue(userService.updateUser(user1));
			assertTrue(sellerService.updateSeller(user2));

		} catch (ServiceException e) { 
			e.printStackTrace();
		} 
	}

	

	@Test
	void testInavalidUpdateFailure() {
		UserService userService = new UserService();
		Date dob = Date.valueOf("2020-08-01");
		long phoneNo = 98763210L;

		User user1 = new User("ajaimailcom", "Ajai", "Aja45", phoneNo, null, null, "12, gandhi street, gobi", dob,
				000000, "Other");
		try {
			assertFalse(userService.updateUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
}
