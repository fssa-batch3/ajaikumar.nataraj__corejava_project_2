package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

class TestLoginSellerFeature {

	@Test
	void testLoginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("ajainataraj@gmail.com", "Ajai@1234!");
		try {
			assertTrue(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail(); 
		}
	}

	@Test
	void testLoginFailure() {
		UserService sellerService = new UserService();
		User user1 = new User("ajagmail.com", "Aji@23");
		try {
			assertFalse(sellerService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	void testEmailPasswordNull() {
		UserService sellerService = new UserService();
		User user1 = null;
		try {
			assertFalse(sellerService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
	void testInvalidPassword() {
		UserService sellerService = new UserService();
		User user1 = new User("ajaikumarnatarajan@gmail.com", "Aj45");
		try {
			assertFalse(sellerService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	void testInvalidEmail() {
		UserService sellerService = new UserService();
		User user1 = new User("ajgmailcom", "Ajai@123");
		try {
			assertFalse(sellerService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}
