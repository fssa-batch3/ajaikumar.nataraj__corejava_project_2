package com.fssa.rishi.services;

import com.fssa.rishi.model.User;

public class TestDeleteBuyerFeature {
	public static void main(String[] args) {
		User user1 = new User("ajain@gmail.com", true);

		UserService userService = new UserService();

		try {
			userService.DeleteUser(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}