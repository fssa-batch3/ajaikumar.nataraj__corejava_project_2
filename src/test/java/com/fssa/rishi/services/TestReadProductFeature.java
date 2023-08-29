package com.fssa.rishi.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.rishi.dao.ProductDAO;
import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.ProductDetails;

class TestReadProductFeature {

	 @Test
	    void testListProductNotEmptyTrue() throws DAOException {
	        ProductDAO productDAO = new ProductDAO();

	        try {
	            List<ProductDetails> product = productDAO.listProduct();
	            Assertions.assertNotNull(product, "List of products is null");
	            Assertions.assertTrue(!product.isEmpty(), "List of products is empty.");
	        } catch (DAOException e) {
	            throw new DAOException(e);
	        }
	    }

	    @Test
	    void testListProducts() throws DAOException {
	        ProductDAO productDAO = new ProductDAO();

	        try {
	            List<ProductDetails> product = productDAO.listProduct();
	            Assertions.assertNotNull(product, "List of products is null.");
	            Assertions.assertFalse(product.isEmpty(), "List of products is not empty.");
	        } catch (DAOException e) {
	            throw new DAOException(e);
	        }
		}
}
