package com.fssa.rishi.services;

import java.util.List;

import com.fssa.rishi.dao.SellerDAO;
import com.fssa.rishi.dao.UserDAO;
import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Seller;
import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;
import com.fssa.rishi.validation.UserValidator;

public class UserService {
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			if (userDAO.createUser(user)) {
				System.out.println(user.getUsername() + " Successfully registered!");
				return true;
			} else {
				return false; 
			} 
 
		} catch (DAOException e) {
			throw new ServiceException(e);
		} 

	}

	public boolean logInUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateLogIn(user);
			if (userDAO.checkUserLogin(user.getEmail(), user.getPassword())) {
				System.out.println(user.getEmail() + " Successfully Logged In!");
				return true;
			} else {
				return false;
	 		}

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
  
	}
	
	 public List<User> listUsers() throws ServiceException {
	        UserDAO userDAO = new UserDAO();

	        try {
	            return userDAO.listUsers();
	        } catch (DAOException e) {
	            throw new ServiceException(e);
	        }
	    }
	
	
	
	public boolean updateUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUpdateUser(user);
			if (userDAO.updateUser(user)) {
				System.out.println(user.getEmail() + " Details are Successfully Modified!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	public boolean deleteUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateDeleteUser(user);
			if (userDAO.deleteUser(user)) {
				System.out.println(user.getEmail() + " Details are Successfully deleted!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

}
