package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Seller;
import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

 class TestUpdateSellerFeature {
	@Test
	void testUpdateSeller() {
		Date dob = Date.valueOf("2003-08-01");
		long phoneNo = 9876543210L;
		long id = 1692694755142L;

		User user1 = new User(id, "ajaikumarnatarajan@gmail.com", "Kannan", "Ajai@12345", phoneNo, "Erode", "TN",
				"12, gandhi street, gobi", dob, 987654, "Male");
		UserService userService = new UserService();
		try {
			userService.UpdateUser(user1);
		} catch (Exception e) { 
			e.printStackTrace();
		} 

		Seller user2 = new Seller("ajaikumarnatarajan@gmail.com", "12, gandhi street, gobi", "Own", id);
		// public Seller(String email, String landAddress, String LandType, String id) {
		SellerService sellerService = new SellerService();
		try {
			sellerService.UpdateSeller(user2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void testUpdateSuccess() {
		UserService userService = new UserService();
		Date dob = Date.valueOf("2003-08-01");
		long phoneNo = 9876543210L;
		long id = 1693153795167L;

		User user1 = new User(id, "ajaikumarnatarajan@gmail.com", "Kannan", "Ajai@12345", phoneNo, "Erode", "TN",
				"12, gandhi street, gobi", dob, 987654, "Male");

		try {
			assertTrue(userService.UpdateUser(user1));
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
			assertFalse(userService.UpdateUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
}
