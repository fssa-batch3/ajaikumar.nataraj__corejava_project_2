package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestLoginBuyerFeature {

	public static void main(String[] args) {
		User user1 = new User("ajaikumar@gmail.com", "Ajai@12345");
		UserService userService = new UserService();

		try {
			userService.logInUser(user1);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
 
	@Test
	public void testLoginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("ajai@gmail.com", "Ajai@123");
		try {
			assertTrue(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
	
	@Test
	public void testLoginFailure() {
	    UserService userService = new UserService();
	    User user1 = new User("ajai@gmail.com", "Aji@12");

	    try {
	        assertFalse(userService.logInUser(user1));
	    } catch (ServiceException e) {
	        e.printStackTrace();
	    }
	}


	@Test
	public void testEmailPasswordNull() {
		UserService userService = new UserService();
		User user1 = null;
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testInvalidPassword() {
		UserService userService = new UserService();
		User user1 = new User("ajaikumarnatarajan@gmail.com", "Ajai@12345");
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testInvalidEmail() {
		UserService userService = new UserService();
		User user1 = new User("ajai@gmail.com", "Ajai@123");
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}
