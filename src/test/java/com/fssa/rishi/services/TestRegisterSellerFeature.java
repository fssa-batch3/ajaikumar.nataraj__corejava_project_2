package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Seller;
import com.fssa.rishi.services.exceptions.ServiceException;

class TestRegisterSellerFeature {
	@Test
	void TestRegisterSellerSuccess() {
		Date dob = Date.valueOf("2003-08-01");
		long phoneNo = 9876543210L;
		long uniqueID = System.currentTimeMillis();

		Seller user1 = new Seller("ajaikumaran@gmail.com", "AjaiKumar", "Ajai@12345", phoneNo, "Erode", "TN",
				"12, gandhi street, gobi", uniqueID, dob, 987654, "Male", false, true);
		SellerService sellerService = new SellerService();

		try {
			assertTrue(sellerService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

		Seller user2 = new Seller("ajaikumaran@gmail.com", null, null, uniqueID);
		// public Seller(String email, String landAddress, String LandType, String id) {
		SellerService sellerService1 = new SellerService();

		try {
			assertTrue(sellerService1.registerSeller(user2));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	void TestRegisterSellerFailure() {
		Date dob = Date.valueOf("2003-08-01");
		long phoneNo = 9876543210L;
		long uniqueID = System.currentTimeMillis();

		Seller user1 = new Seller("ajaikumarangmailcom", "Ajai1234", "Ajai12345", phoneNo, "Erode", "TN",
				"12, gandhi street, gobi", uniqueID, dob, 000000, "M", false, true);
		SellerService sellerService = new SellerService();

		try {
			assertFalse(sellerService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		Seller user2 = new Seller("ajaikumarangmailcom", null, null, uniqueID);
		SellerService sellerService1 = new SellerService();

		try {
			assertFalse(sellerService1.registerSeller(user2));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testUserNull() {
		SellerService sellerService = new SellerService();
		Seller user1 = null;
		try {
			Assertions.assertFalse(sellerService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}
}
