package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

 class TestRegisterBuyerFeature {

	 @Test
	 void testRegistrationSuccess() {
	     Date dob = Date.valueOf("2003-08-01");
	     long uniqueID = System.currentTimeMillis();
	     long phoneNo = 9876543678L;
	     String email = "gokul@gmail.com"; 

	     UserService userService = new UserService();
	     User user1 = new User(email, "AjaiKumar", "Gokul@12345", phoneNo, null,
	             "12, gandhi street, gobi", uniqueID, null, 987654, false, false);
	     try {
	         assertTrue(userService.registerUser(user1));
	     } catch (ServiceException e) {
	         e.getMessage(); 
	         fail();  
	     }
	 }
 
	 @Test
	 void testRegistrationFail() {
	     Date dob = Date.valueOf("2003-08-01");
	     long uniqueID = System.currentTimeMillis();
	     long phoneNo = 1876543677L;

	     UserService userService = new UserService();
	     User user1 = new User("ajaigmailcom", "ajai@123", "Aji", phoneNo, "Erode",
	             "12, gandhi street, gobi", uniqueID, dob, 000000, false, false);
	     try {
	         assertFalse(userService.registerUser(user1));
	     } catch (ServiceException e) {
	         e.printStackTrace();
	     }
	 } 


	@Test
	void testUserNull() {

		UserService userService = new UserService();
		User user1 = null;
		try {
			Assertions.assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
