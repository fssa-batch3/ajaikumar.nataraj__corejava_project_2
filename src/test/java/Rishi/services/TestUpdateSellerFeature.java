package Rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import Rishi.model.Seller;
import Rishi.model.User;
import Rishi.services.exceptions.ServiceException;

public class TestUpdateSellerFeature {
	public static void main(String[] args) {
		Date dob = Date.valueOf("2003-08-01");

		User user1 = new User("ajai@gmail.com", "Ajai", "Ajai@123", "887070909", "Erode", "TN", "12, gandhi street, gobi", "9876543210", dob, 987654, "Male", false, true);

		UserService sellerService = new UserService();

		try {
			sellerService.UpdateUser(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Seller user2 = new Seller("ajai@gmail.com", "12, gandhi street, gobi", "Own", "9876543210");
		//					public Seller(String email, String landAddress, String LandType, String id) {
		SellerService userService = new SellerService();

		try {
			userService.UpdateSeller(user2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testUpdateSuccess() {
		SellerService sellerService = new SellerService();
		Date dob = Date.valueOf("2003-08-01");

		User user1 = new User("ajai@gmail.com", "Ajai", "Ajai@123", "887070909", "Erode", "TN", "12, gandhi street, gobi", "9876543210", dob, 987654, "Male", false, true);

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

		User user1 = new User("ajai@gmail.com", "Ajai", "Ajai@123", "887070909", "Erode", "TN", "12, gandhi street, gobi", "9876543210", dob, 987654, "Male", false, true);

		try {
			assertFalse(userService.logInSeller(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
}
