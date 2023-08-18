package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Seller;
import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestRegisterSellerFeature {
	public static void main(String[] args) {
		Date dob = Date.valueOf("2003-08-01");

		 Seller user1 = new Seller("ajain@gmail.com", "AjaiKumar", "Ajai@12345", "8870737614", "Erode", "TN", "12, gandhi street, gobi", "9876547678", dob, 987654, "Male", false, true);
			SellerService userService = new SellerService();

			try {
				userService.registerUser(user1);
			} catch (Exception e) {
				e.printStackTrace();
				fail();
			}
			
			
		
		Seller user2 = new Seller("ajain@gmail.com", null, null, "9876547678");
		//					public Seller(String email, String landAddress, String LandType, String id) {
		SellerService sellerService = new SellerService();

		try {
			sellerService.registerSeller(user2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	
	}

//	@Test
//	public void testRegistrationSuccess() {
//		Date dob = Date.valueOf("2003-08-01");
//
//		SellerService userService = new SellerService();
//		Seller user1 = new Seller("ajai@gmail.com", "Ajai", "Ajai@123", "887070909", "Erode", "TN", "12, gandhi street, gobi", "9876543210", dob, 987654, "Male", false, true);
//		try {
//			assertTrue(userService.registerUser(user1));
//		} catch (ServiceException e) {
//			e.printStackTrace();
//			
//		}
//	}
//
//	@Test
//	public void testInvalidPassword() {
//		Date dob = Date.valueOf("2003-08-01");
//
//		SellerService userService = new SellerService();
//		Seller user1 = new Seller("ajai@gmail.com", "Ajai", "Ajai@123", "887070909", "Erode", "TN", "12, gandhi street, gobi", "9876543210", dob, 987654, "Male", false, true);
//		try {
//			assertFalse(userService.registerUser(user1));
//		} catch (ServiceException e) {
//			e.printStackTrace();
//
//		}
//	}
//
//	@Test
//	public void testUserNull() {
//
//		SellerService userService = new SellerService();
//		Seller user1 = null;
//		try {
//			assertFalse(userService.registerUser(user1));
//		} catch (ServiceException e) {
//			e.printStackTrace();
//
//		}
//
//	}
}
