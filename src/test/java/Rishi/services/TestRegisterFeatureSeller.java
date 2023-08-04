package Rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import Rishi.model.Seller;
import Rishi.services.exceptions.ServiceException;

public class TestRegisterFeatureSeller {
	public static void main(String[] args) {
		Date dob = Date.valueOf("2003-08-01");

		Seller user1 = new Seller("ajai@gmail.com", "Ajai", "Ajai@123", 887070909, "Erode", "TN", "12, gandhi street, gobi", "12, gandhi street, gobi", dob, 987654, "Male", "Own",  "9877776543456765");
		SellerService userService = new SellerService();

		try {
			userService.registerSeller(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testRegistrationSuccess() {
		Date dob = Date.valueOf("2003-08-01");

		SellerService userService = new SellerService();
		Seller user1 = new Seller("ajaikumarnatarajan@gmail.com", "Ajai", "Ajai@123", 887070909, "Erode", "TN", "12, gandhi street, gobi", "12, gandhi street, gobi", dob, 987654, "Male", "Own",  "9877776543456765");
		try {
			assertTrue(userService.registerSeller(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			
		}
	}

	@Test
	public void testInvalidPassword() {
		Date dob = Date.valueOf("2003-08-01");

		SellerService userService = new SellerService();
		Seller user1 = new Seller("ajaikumarnatarajan@gmail.com", "Ajai", "Ajai@123", 887070909, "Erode", "TN", "12, gandhi street, gobi", "12, gandhi street, gobi", dob, 987654, "Male", "Own",  "9877776543456765");
		try {
			assertFalse(userService.registerSeller(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testUserNull() {

		SellerService userService = new SellerService();
		Seller user1 = null;
		try {
			assertFalse(userService.registerSeller(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}
}
