package com.fssa.rishi.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.rishi.dao.UserDAO;
import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.User;

 class TestReadBuyerFeature {

	 @Test
		void testListSellerNotEmptyTrue() throws DAOException {
		 UserDAO userDAO = new UserDAO();

			try {
				List<User> user = userDAO.listUsers();
				Assertions.assertNotNull(user, "List of User is null");
				Assertions.assertTrue(!user.isEmpty(), "List of User is empty.");
			} catch (DAOException e) {
				throw new DAOException(e);
			} 
		}

		@Test
		void testListSeller() throws DAOException {
			UserDAO userDAO = new UserDAO();

			try {
				List<User> user = userDAO.listUsers();
				Assertions.assertNotNull(user, "List of User is null.");
				Assertions.assertFalse(user.isEmpty(), "List of User is not empty.");
			} catch (DAOException e) {
				throw new DAOException(e);
			}
		}

	 
	
}

