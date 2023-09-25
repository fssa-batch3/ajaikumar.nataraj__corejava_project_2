package com.fssa.rishi.services;

import java.util.List;

import com.fssa.rishi.dao.CartDAO;
import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Cart;
import com.fssa.rishi.model.Order;
import com.fssa.rishi.services.exceptions.ServiceException;

public class CartService {

   
    // Create a new cart and add it to the database
    public boolean createCart(Cart cart) throws ServiceException {
    	CartDAO cartDao = new CartDAO();
        try {
        	cartDao.checkProductExistOrNot(cart.getProductId(), cart.getBuyerId());
            if(cartDao.createCart(cart)) {
            	return true;
            } else {
            	return false;
            }
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    // Retrieve a cart by its ID
    public List<Cart> getCartById(long cartId) throws ServiceException {
    	CartDAO cartDao = new CartDAO();

        try {
            return cartDao.getCartsByUserId(cartId);
        } catch (DAOException e) {
            throw new ServiceException("There is no products in your cart");
        }
    }

    

    // Update an existing cart
    public boolean updateCart(Cart cart) throws ServiceException {
    	CartDAO cartDao = new CartDAO();

        try {
            return cartDao.updateCart(cart);
        } catch (DAOException e) {
            throw new ServiceException("Error updating cart");
        }
    }

    // Delete a cart by its ID
    public boolean deleteCart(long id) throws ServiceException {
    	CartDAO cartDao = new CartDAO();

        try {
            return cartDao.deleteCart(id);
        } catch (DAOException e) {
            throw new ServiceException("Error deleting cart by ID");
        }
    }
}

