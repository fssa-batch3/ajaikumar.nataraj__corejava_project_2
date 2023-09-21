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
        	System.out.println(cart.toString());
            return cartDao.createCart(cart);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    // Retrieve a cart by its ID
    public Cart getCartById(long cartId) throws ServiceException {
    	CartDAO cartDao = new CartDAO();

        try {
            return cartDao.getCartById(cartId);
        } catch (DAOException e) {
            throw new ServiceException("Error retrieving cart by ID");
        }
    }

    // Retrieve all carts
    public List<Cart> getAllCarts() throws ServiceException {
    	CartDAO cartDao = new CartDAO();

        try {
            return cartDao.getAllCarts();
        } catch (DAOException e) {
            throw new ServiceException("Error retrieving all carts");
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
    public boolean deleteCart(long cartId) throws ServiceException {
    	CartDAO cartDao = new CartDAO();

        try {
            return cartDao.deleteCart(cartId);
        } catch (DAOException e) {
            throw new ServiceException("Error deleting cart by ID");
        }
    }
}

