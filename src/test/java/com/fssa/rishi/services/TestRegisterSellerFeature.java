 package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.Seller;
import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

class TestRegisterSellerFeature {
	@Test
	void TestRegisterSellerSuccess() {
		Date dob = Date.valueOf("2003-08-01");
		long phoneNo = 9876543289L;
		long uniqueID = System.currentTimeMillis();
		String email = "yogeshwaran@gmail.com"; 

		UserService userService = new UserService();
	     User user1 = new User(email, "AjaiKumar", "Kumar@12345", phoneNo, null,
	             "12, gandhi street, gobi", uniqueID, dob, 987654, false, false); 

		try {
			assertTrue(userService.registerUser(user1)); 

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
		String email = "yogeshwaran@gmail.com"; 


		UserService userService = new UserService();
	     User user1 = new User(email, "AjaiKumar", "Kumar@12345", phoneNo, null,
	             "12, gandhi street, gobi", uniqueID, dob, 987654, false, false); 

		try {
			assertFalse(userService.registerUser(user1));
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
