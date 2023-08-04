package Rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import Rishi.model.Seller;
import Rishi.services.exceptions.ServiceException;

public class TestUpdateFeatureSeller {
	public static void main(String[] args) {
		Date dob = Date.valueOf("2003-08-01");

		Seller user1 = new Seller("ajai@gmail.com", "Ajai", "Ajai@123", 887070909, "Erode", "TN", "12, gandhi street, gobi", "12, gandhi street, gobi", dob, 987654, "Male", "Own",  "9877776543456765");

		SellerService sellerService = new SellerService();

		try {
			sellerService.UpdateSeller(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateSuccess() {
		SellerService sellerService = new SellerService();
		Date dob = Date.valueOf("2003-08-01");

		Seller user1 = new Seller("ajaikumarnatarajan@gmail.com", "Ajai", "Ajai@123", 887070909, "Erode", "TN", "12, gandhi street, gobi", "12, gandhi street, gobi", dob, 987654, "Male", "Own",  "9877776543456765");

		try {
			assertTrue(sellerService.logInSeller(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
	
	@Test
	public void testInavalidUpdateSuccess() {
		SellerService userService = new SellerService();
		Date dob = Date.valueOf("2003-08-01");

		Seller user1 = new Seller("ajaikumarnatarajan@gmail.com", "Ajai", "Ajai@123", 887070909, "Erode", "TN", "12, gandhi street, gobi", "12, gandhi street, gobi", dob, 987654, "Male", "Own",  "9877776543456765");

		try {
			assertFalse(userService.logInSeller(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
}
