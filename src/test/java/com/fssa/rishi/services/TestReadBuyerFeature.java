package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;

class TestReadBuyerFeature {
	@Test
	void testReadUserProfileDetails() {
		User user1 = new User("ajaikumar@gmail.com", "Ajai@1234!");
		UserService userService = new UserService();
		try {
			List<User> result = userService.readUserDetails(user1);
			for (User u : result) {
				System.out.println(u);
			}
			assertNotNull(result);

		} catch (ServiceException e) {
			e.printStackTrace();
			fail();

		} 
	}
		 
}
