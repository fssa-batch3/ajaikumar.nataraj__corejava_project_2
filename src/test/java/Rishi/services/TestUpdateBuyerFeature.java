package Rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import Rishi.model.User;
import Rishi.services.exceptions.ServiceException;

public class TestUpdateBuyerFeature {

	public class Main {
	    public static void main(String[] args) {
	        Date dob = Date.valueOf("2003-08-01");

	        User user1 = new User("ajai@gmail.com", "AjaiKumar", "Ajai@12345", "887073761", "Erode", "TN", "12, gandhi street, gobi", "987654765", dob, 987654, "Male", false, false);

	        UserService userService = new UserService();

	        try {
	            userService.UpdateUser(user1);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Test
	public void testUpdateSuccess() {
		UserService userService = new UserService();
		Date dob = Date.valueOf("2003-08-01");

        User user1 = new User("ajai@gmail.com", "AjaiKumar", "Ajai@12345", "887073761", "Erode", "TN", "12, gandhi street, gobi", "987654765", dob, 987654, "Male", false, false);

		try {
			assertTrue(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
	
	@Test
	public void testInvalidUpdateSuccess() {
		UserService userService = new UserService();
		Date dob = Date.valueOf("2003-08-01");

        User user1 = new User("ajai@gmail.com", "AjaiKumar", "Ajai@12345", "887073761", "Erode", "TN", "12, gandhi street, gobi", "987654765", dob, 987654, "Male", false, false);

		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
}
