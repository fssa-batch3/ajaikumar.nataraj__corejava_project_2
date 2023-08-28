package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

 class TestLoginBuyerFeature {

	@Test
	void testLoginBuyer() {
		User user1 = new User("ajaikumar@gmail.com", "Ajai@12345");
		UserService userService = new UserService();

		try {
			userService.logInUser(user1);
		} catch (Exception e) {
			e.printStackTrace(); 

		}

	}

	@Test
	void testLoginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("ajaikumar@gmail.com", "Ajai@12345");
		try {
			assertTrue(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testLoginFailure() {
		UserService userService = new UserService();
		User user1 = new User("ajai@gmail.com", "Aji@12");

		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testEmailPasswordNull() {
		UserService userService = new UserService();
		User user1 = null;
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
	void testInvalidPassword() {
		UserService userService = new UserService();
		User user1 = new User("ajaikumarnatarajan@gmail.com", "Aja45");
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	void testInvalidEmail() {
		UserService userService = new UserService();
		User user1 = new User("ajaigmail", "Ajai@123");
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}
