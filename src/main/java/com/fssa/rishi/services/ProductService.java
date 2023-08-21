package com.fssa.rishi.services;

import com.fssa.rishi.DAO.ProductDAO;
import com.fssa.rishi.DAO.exceptions.DAOException;
import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.services.exceptions.ServiceException;
import com.fssa.rishi.validation.ProductValidator;

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

		} catch (DAOException e) {
			throw new ServiceException(e);
		} 

	} 

//	public boolean readProduct(ProductDetails product) throws ServiceException {
//	    ProductDAO productDAO = new ProductDAO();
//	    try {
//	        // Call the DAO method to read the product details by ID
//			ProductValidator.validateProduct(product);
//
//	        if (product != null) {
//	            System.out.println("Product with ID " + product + " found.");
//	        } else {
//	            System.out.println("Product with ID " + product + " not found.");
//	        }
//
//	        return product != null;
//	    } catch (ServiceException e) {
//	        throw new ServiceException(e);
//	    }
//	}

	
	public boolean UpdateProduct(ProductDetails product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateProduct(product);
			if (productDAO.updateProduct(product)) {
				System.out.println(product.getId() + " Products are Successfully Modified!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	public boolean DeleteProduct(ProductDetails product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateDeleteProduct(product);
			if (productDAO.deleteProduct(product)) {
				System.out.println(product.getId() + " Products are Successfully deleted!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

}
