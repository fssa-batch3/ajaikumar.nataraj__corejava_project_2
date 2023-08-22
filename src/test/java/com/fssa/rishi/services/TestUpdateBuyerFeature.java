package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

public class TestUpdateBuyerFeature {

	public class Main {
	    public static void main(String[] args) {
	        Date dob = Date.valueOf("2003-08-01");
			long phoneNo = 9876543210L;


	        User user1 = new User("ajainataraj@gmail.com", "Kannan", "Ajai@12345", phoneNo, "Erode", "TN", "12, gandhi street, gobi", dob, 987654, "Male");
	    	// public User(String email, String username, String password, long phoneNumber, String district, String state, String address,  Date dob, int pincode, String gender, boolean isDeleted, boolean isSeller) {

	         
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
		long phoneNo = 9876543210L;


        User user1 = new User("ajainataraj@gmail.com", "AjaiKumar", "Ajai@12345", phoneNo, "Erode", "TN", "12, gandhi street, gobi", dob, 987654, "Male");

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
		long phoneNo = 9876543210L;


        User user1 = new User("ajainataraj@gmail.com", "AjaiKumar", "Ajai@12345", phoneNo, "Erode", "TN", "12, gandhi street, gobi", dob, 987654, "Male");

		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
}
