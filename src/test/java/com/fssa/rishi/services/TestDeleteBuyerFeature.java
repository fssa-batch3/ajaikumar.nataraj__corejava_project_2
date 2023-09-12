package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.model.User;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDeleteBuyerFeature {
    @Test
    void testDeleteUser() {
        String userEmail = "kannan@gmail.com";

        UserService userService = new UserService();

        try {
            // Assuming your deleteUser method in UserService returns void or throws exceptions
            userService.deleteUser(userEmail);

            // If it doesn't throw exceptions, consider the operation successful
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Invalid User detail");
        }
    }
}
