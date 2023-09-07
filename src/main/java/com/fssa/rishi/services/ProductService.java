package com.fssa.rishi.services;

import java.util.List;

import com.fssa.rishi.dao.ProductDAO;
import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.services.exceptions.ServiceException;
import com.fssa.rishi.validation.ProductValidator;
import com.fssa.rishi.validation.exceptions.InvalidProductException;

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
  
		} catch ( DAOException | InvalidProductException e) { 
			throw new ServiceException(e.getMessage());
		} 
 
	}   
 
	public List<ProductDetails> readProductDetails() throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
				List<ProductDetails> userList = productDAO.readProduct();
				

			return userList;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public boolean updateProduct(ProductDetails product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateProduct(product);
			if (productDAO.updateProduct(product)) {
				System.out.println(product.getId() + " Products are Successfully Modified!");
				return true;
			} else {
				return false;
			}
 
		} catch (DAOException | InvalidProductException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public static ProductDetails findProductById(long productId) throws ServiceException {
		ProductDetails products;
		try {
			products = ProductDAO.findProductById(productId);

		} catch (DAOException e) {
			throw new ServiceException("Failed to retrieve product by ID");
		}
		return products;
	}

	public boolean deleteProduct(ProductDetails product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateDeleteProduct(product);
			if (productDAO.deleteProduct(product)) {
				System.out.println(product.getId() + " Products are Successfully deleted!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidProductException e) {
			throw new ServiceException(e.getMessage());
		}

	}

}
