package Rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import Rishi.model.Seller;
import Rishi.model.User;
import Rishi.services.exceptions.ServiceException;

public class TestRegisterSellerFeature {
	public static void main(String[] args) {
		Date dob = Date.valueOf("2003-08-01");

		User user1 = new User("ajainat@gmail.com", "Ajai", "Ajai@123", "8870709091", "Erode", "TN", "12, gandhi street, gobi", "9876543210", dob, 987654, "Male", false, true);
		//    public User(String email, String username, String password, String phoneNumber, String district, String state, String address, String id, Date dob, int pincode, String gender, boolean isDeleted, boolean isSeller) {

		UserService userService = new UserService();

		try {
			userService.registerUser(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Seller user2 = new Seller("ajainat@gmail.com", "12, gandhi street, gobi", "Own", "8870709091");
		//					public Seller(String email, String landAddress, String LandType, String id) {
		SellerService sellerService = new SellerService();

		try {
			sellerService.registerSeller(user2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	
	}

	@Test
	public void testRegistrationSuccess() {
		Date dob = Date.valueOf("2003-08-01");

		SellerService userService = new SellerService();
		User user1 = new User("ajai@gmail.com", "Ajai", "Ajai@123", "887070909", "Erode", "TN", "12, gandhi street, gobi", "9876543210", dob, 987654, "Male", false, true);
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
		User user1 = new User("ajai@gmail.com", "Ajai", "Ajai@123", "887070909", "Erode", "TN", "12, gandhi street, gobi", "9876543210", dob, 987654, "Male", false, true);
		try {
			assertFalse(userService.registerSeller(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testUserNull() {

		SellerService userService = new SellerService();
		User user1 = null;
		try {
			assertFalse(userService.registerSeller(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}
}
