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
		try {
			SellerValidator.validateSeller(seller);
			sellerDAO.checkUserDataExistOrNot(seller.getEmail());
			if (sellerDAO.createSeller(seller)) {
				System.out.println(seller.getId() + " Successfully registered!");
				return true;
			} else {
				return false; 
			}
			
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}
	
	public boolean registerSeller(Seller seller) throws ServiceException {
		SellerDAO sellerDAO = new SellerDAO();
		try {
			SellerValidator.validateSeller(seller);
			if (sellerDAO.createUser(seller)) {
				System.out.println(seller.getId() + " Successfully registered!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	
	public boolean updateSeller(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUpdateUser(user);
			if (userDAO.updateUser(user)) {
				System.out.println(user.getEmail() + " Details are Successfully Modified!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
	}
		
		public boolean updateSeller(Seller user2) throws ServiceException {

		SellerDAO sellerDAO = new SellerDAO();
		try {
			SellerValidator.validateUpdateSeller(user2);
			if (sellerDAO.updateUser(user2)) {
				System.out.println(user2.getEmail() + " Details are Successfully Modified!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
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

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	
}
