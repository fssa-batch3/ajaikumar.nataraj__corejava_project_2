package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestLoginSellerFeature {

	public static void main(String[] args) {
		User user1 = new User("ajaiknataraj@gmail.com", "Ak@12345");
		UserService sellerService = new UserService();

		try {
			sellerService.logInUser(user1);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testLoginSuccess() {
		UserService sellerService = new UserService();
		User user1 = new User("ajai@gmail.com", "Ajai@123");
		try {
			assertTrue(sellerService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
	
	@Test
	public void testLoginFailure() {
		UserService sellerService = new UserService();
		User user1 = new User("ajai@gmail.com", "Aji@23");
		try {
			assertFalse(sellerService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testEmailPasswordNull() {
		UserService sellerService = new UserService();
		User user1 = null;
		try {
			assertFalse(sellerService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testInvalidPassword() {
		UserService sellerService = new UserService();
		User user1 = new User("ajaikumarnatarajan@gmail.com", "Ajai@12345");
		try {
			assertFalse(sellerService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testInvalidEmail() {
		UserService sellerService = new UserService();
		User user1 = new User("ajai@gmail.com", "Ajai@123");
		try {
			assertFalse(sellerService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}
