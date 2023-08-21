package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestRegisterBuyerFeature {

	
	public static void main(String[] args) {
		Date dob = Date.valueOf("2003-08-01");
		long uniqueID = System.currentTimeMillis();
		long phoneNo = 8876543210L;


        User user1 = new User("ajainataraj@gmail.com", "AjaiKumar", "Ajai@12345", phoneNo, "Erode", "TN", "12, gandhi street, gobi", uniqueID, dob, 987654, "Male", false, false);
		UserService userService = new UserService();

		try {
			userService.registerUser(user1);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void testRegistrationSuccess() {
		Date dob = Date.valueOf("2003-08-01");
		long uniqueID = System.currentTimeMillis();
		long phoneNo = 9876543210L;

		UserService userService = new UserService();
        User user1 = new User("ajainataraj@gmail.com", "AjaiKumar", "Ajai@12345", phoneNo, "Erode", "TN", "12, gandhi street, gobi", uniqueID, dob, 987654, "Male", false, false);
		try {
			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testInvalidPassword() {
		Date dob = Date.valueOf("2003-08-01");
		long uniqueID = System.currentTimeMillis();
		long phoneNo = 9876543210L;

		UserService userService = new UserService();
        User user1 = new User("ajainataraj@gmail.com", "AjaiKumar", "Ajai@12345", phoneNo, "Erode", "TN", "12, gandhi street, gobi", uniqueID, dob, 987654, "Male", false, false);
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testUserNull() {

		UserService userService = new UserService();
		User user1 = null;
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

	}

}
