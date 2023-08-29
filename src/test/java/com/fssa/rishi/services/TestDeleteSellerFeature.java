package com.fssa.rishi.services;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.User;

 class TestDeleteSellerFeature {
	@Test
	void testDeleteUser() {
		User user1 = new User("ajaikumaran@gmail.com", true);

		UserService sellerService = new UserService();

		try {
			sellerService.deleteUser(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 