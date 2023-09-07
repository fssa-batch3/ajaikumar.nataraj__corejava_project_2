package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.User;

 class TestDeleteBuyerFeature {
	@Test
    void testDeleteUser() {
		User user1 = new User("ajai@gmail.com", true);

		UserService userService = new UserService();

		try {
			assertTrue(userService.deleteUser(user1));
		} catch (Exception e) {  
			e.printStackTrace();  
			fail("Invalid User detail");
		}
	}
}   