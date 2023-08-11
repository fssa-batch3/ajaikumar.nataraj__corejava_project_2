package Rishi.services;

import Rishi.DAO.SellerDAO;
import Rishi.DAO.UserDAO;
import Rishi.DAO.exceptions.DAOException;
import Rishi.model.Seller;
import Rishi.model.User;
import Rishi.services.exceptions.ServiceException;
import Rishi.validation.SellerValidator;
import Rishi.validation.UserValidator;
import Rishi.validation.exceptions.InvalidUserException;

public class SellerService {
	public boolean registerSeller(User seller) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(seller);
			if (userDAO.createUser(seller)) {
				System.out.println(seller.getUsername() + " Successfully registered!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	public boolean logInSeller(User seller) throws ServiceException {
		UserDAO sellerDAO = new UserDAO();
		try {
			UserValidator.validateLogIn(seller);
			if (sellerDAO.checkUserLogin(seller.getEmail(), seller.getPassword())) {
				System.out.println(seller.getEmail() + " Successfully Logged In!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}
	
	public boolean UpdateSeller(User seller) throws ServiceException {
		SellerDAO sellerDAO = new SellerDAO();
		try {
			SellerValidator.validateUpdateSeller(seller);
			if (sellerDAO.updateUser(seller)) {
				System.out.println(seller.getEmail() + " Details are Successfully Modified!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	public boolean DeleteUser(User user) throws ServiceException {
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
			throw new ServiceException(e);
		}

	}

	
}
