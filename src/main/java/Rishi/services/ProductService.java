package Rishi.services;

import Rishi.DAO.ProductDAO;
import Rishi.DAO.exceptions.DAOException;
import Rishi.model.ProductDetails;
import Rishi.services.exceptions.ServiceException;
import Rishi.validation.ProductValidator;
import Rishi.validation.exceptions.InvalidUserException;

public class ProductService {
	public boolean registerProduct(ProductDetails product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateProduct(product);
			if (productDAO.createProduct(product)) {
				System.out.println(product.getId() + " Successfully registered!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		} 

	}

	
	public boolean UpdateProduct(ProductDetails product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateProduct(product);
			if (productDAO.updateProduct(product)) {
				System.out.println(product.getId() + " Details are Successfully Modified!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	public boolean DeleteProduct(ProductDetails product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateDeleteProduct(product);
			if (productDAO.deleteProduct(product)) {
				System.out.println(product.getId() + " Details are Successfully deleted!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

}
