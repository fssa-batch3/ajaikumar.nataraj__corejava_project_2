package com.fssa.rishi.services;

import com.fssa.rishi.dao.SellerDAO;
import com.fssa.rishi.dao.UserDAO;
import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Seller;
import com.fssa.rishi.services.exceptions.ServiceException;
import com.fssa.rishi.validation.SellerValidator;
import com.fssa.rishi.validation.exceptions.InvalidUserException;

public class SellerService {
	public boolean registerUser(Seller seller) throws ServiceException {
		SellerDAO sellerDAO = new SellerDAO();
		UserDAO userDAO = new UserDAO();

		try {
			SellerValidator.validateUser(seller);
			userDAO.checkUserDataExistOrNot(seller.getEmail());
			return (sellerDAO.createSeller(seller));

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

}
