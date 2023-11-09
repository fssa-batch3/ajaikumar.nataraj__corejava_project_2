package com.fssa.rishi.services;

import java.util.List;

import com.fssa.rishi.dao.UserDAO;
import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;
import com.fssa.rishi.validation.UserValidator;
import com.fssa.rishi.validation.exceptions.InvalidUserException;

public class UserService {
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			userDAO.checkUserDataExistOrNot(user.getEmail());
			return (userDAO.createUser(user));

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean logInUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateLogIn(user);
			return (userDAO.checkUserLogin(user.getEmail(), user.getPassword()));

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public List<User> readUserDetails(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUserDetailReadFeature(user);
			return userDAO.readUser();
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean updateUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUpdateUser(user);
			return (userDAO.updateUser(user));

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public long findIdByEmail(String email) throws ServiceException {
		try {
			return (UserDAO.findIdByEmail(email));
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public int findTypeByEmail(String email) throws ServiceException {
		try {
			return (UserDAO.findTypeByEmail(email));
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public User findUserById(long id) throws ServiceException {
		try {
			return (UserDAO.findUserById(id));
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean deleteUser(String userEmail) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			return (userDAO.deleteUser(userEmail));
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
