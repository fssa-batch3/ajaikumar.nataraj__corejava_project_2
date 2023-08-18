package Rishi.services;

import com.fssa.rishi.seller;
import Rishi.DAO.UserDAO;
import Rishi.DAO.exceptions.DAOException;
import Rishi.model.Seller;
import Rishi.model.User;
import Rishi.services.exceptions.ServiceException;
import Rishi.validation.SellerValidator;
import Rishi.validation.UserValidator;
import Rishi.validation.exceptions.InvalidUserException;

public class SellerService {
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
	
	public boolean UpdateSeller(Seller user2) throws ServiceException {
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
