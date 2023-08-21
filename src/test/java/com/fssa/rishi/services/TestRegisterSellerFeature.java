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
		long phoneNo = 9876543210L;
		long uniqueID = System.currentTimeMillis();

		 Seller user1 = new Seller("ajaikumar@gmail.com", "AjaiKumar", "Ajai@12345", phoneNo, "Erode", "TN", "12, gandhi street, gobi", uniqueID, dob, 987654, "Male", false, true);
			SellerService userService = new SellerService();

			try {
				userService.registerUser(user1);
			} catch (Exception e) {
				e.printStackTrace();
				fail();
			}
			
			
		
		Seller user2 = new Seller("ajaikumar@gmail.com", null, null, uniqueID);
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
		long phoneNo = 9876543210L;
		long uniqueID = System.currentTimeMillis();

		SellerService userService = new SellerService();
		 Seller user1 = new Seller("ajaikumar@gmail.com", "AjaiKumar", "Ajai@12345", phoneNo, "Erode", "TN", "12, gandhi street, gobi", uniqueID, dob, 987654, "Male", false, true);
		try {
			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			
		}
	}

	@Test
	public void testInvalidPassword() {
		Date dob = Date.valueOf("2003-08-01");
		long phoneNo = 9876543210L;
		long uniqueID = System.currentTimeMillis();

		SellerService userService = new SellerService();
		 Seller user1 = new Seller("ajaikumar@gmail.com", "AjaiKumar", "Ajai@12345", phoneNo, "Erode", "TN", "12, gandhi street, gobi", uniqueID, dob, 987654, "Male", false, true);
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testUserNull() {

		SellerService userService = new SellerService();
		Seller user1 = null;
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}
}
