package Rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import Rishi.model.User;
import Rishi.services.exceptions.ServiceException;

public class TestRegisterBuyerFeature {

	
	public static void main(String[] args) {
		Date dob = Date.valueOf("2003-08-01");

        User user1 = new User("ajai@gmail.com", "AjaiKumar", "Ajai@12345", "887073761", "Erode", "TN", "12, gandhi street, gobi", "987654765", dob, 987654, "Male", false, false);
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

		UserService userService = new UserService();
        User user1 = new User("ajai@gmail.com", "AjaiKumar", "Ajai@12345", "887073761", "Erode", "TN", "12, gandhi street, gobi", "987654765", dob, 987654, "Male", false, false);
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

		UserService userService = new UserService();
        User user1 = new User("ajai@gmail.com", "AjaiKumar", "Ajai@12345", "887073761", "Erode", "TN", "12, gandhi street, gobi", "987654765", dob, 987654, "Male", false, false);
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
