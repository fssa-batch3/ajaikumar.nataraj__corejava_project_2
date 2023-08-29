package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

class TestUpdateBuyerFeature {

		@Test 
		void TestUpdateBuyer() {
			Date dob = Date.valueOf("2003-08-01");
			long phoneNo = 9876543210L;
			long id = 1693153795167L;

			User user1 = new User(id, "ajainataraj@gmail.com", "Kannan", "Ajai@12345", phoneNo, "Erode", "TN",
					"12, gandhi street, gobi", dob, 987654, "Male");

			UserService userService = new UserService();

			try {
				userService.updateUser(user1);
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

		User user1 = new User(id, "ajainataraj@gmail.com", "Kannan", "Ajai@12345", phoneNo, "Erode", "TN",
				"12, gandhi street, gobi", dob, 987654, "Male");

		try {
			assertTrue(userService.updateUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace(); 
			fail();
		} 
	}

	@Test
	void testInvalidUpdate() {
		UserService userService = new UserService();
		Date dob = Date.valueOf("2033-08-01");
		long phoneNo = 987654310L;
		long id = 1693153795167L;

		User user1 = new User(id, "ajaingmailcom", null, "Aj45", phoneNo, null, null, "12, gandhi street, gobi", dob,
				98754, "Male");
		try {
			assertFalse(userService.updateUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
}
