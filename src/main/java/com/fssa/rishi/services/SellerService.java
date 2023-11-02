package com.fssa.rishi.services;

import com.fssa.rishi.dao.SellerDAO;
import com.fssa.rishi.dao.UserDAO;
import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Seller;
import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;
import com.fssa.rishi.validation.SellerValidator;
import com.fssa.rishi.validation.UserValidator;
import com.fssa.rishi.validation.exceptions.InvalidUserException;

public class SellerService {
	public boolean registerUser(Seller seller) throws ServiceException{
		SellerDAO sellerDAO = new SellerDAO();
		UserDAO userDAO = new UserDAO();

		try {
			SellerValidator.validateUser(seller);
			userDAO.checkUserDataExistOrNot(seller.getEmail());
			if (sellerDAO.createSeller(seller)) {
				return true;
			} else {
				return false;    
			}
			
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}
	
//	public boolean updateSeller(User user) throws ServiceException {
//		UserDAO userDAO = new UserDAO();
//		try {
//			UserValidator.validateUser(user);
//			if (userDAO.updateUser(user)) {
//				System.out.println(user.getEmail() + " Details are Successfully Modified!");
//				return true;
//			} else {
//				return false;
//			}
//
//		} catch (DAOException | InvalidUserException e) {
//			throw new ServiceException(e.getMessage());
//		}
//	}
//		
//	public boolean logInUser(User user) throws ServiceException {
//		SellerDAO userDAO = new SellerDAO();
//		try {
//			UserValidator.validateLogIn(user);
//			if (userDAO.checkUserLogin(user.getEmail(), user.getPassword())) {
//				System.out.println(user.getEmail() + " Successfully Logged In!");
//				return true;
//			} else {
//				return false;
//			}
//
//		} catch (DAOException | InvalidUserException e) {
//			throw new ServiceException(e.getMessage());
//		}
//
//	}
	

		


	
}
