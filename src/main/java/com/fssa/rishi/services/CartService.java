package com.fssa.rishi.services;

import java.util.List;

import com.fssa.rishi.dao.CartDAO;
import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Cart;
import com.fssa.rishi.services.exceptions.ServiceException;

public class CartService {

	// Create a new cart and add it to the database
	public boolean createCart(Cart cart) throws ServiceException {
		CartDAO cartDao = new CartDAO();
		try {
			cartDao.checkProductExistOrNot(cart.getProductId(), cart.getBuyerId());
			return cartDao.createCart(cart);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	// Retrieve a cart by its ID
	public List<Cart> getCartByUserId(long userId) throws ServiceException {
		CartDAO cartDao = new CartDAO();

		try {
			return cartDao.getCartsByUserId(userId);
		} catch (DAOException e) {
			throw new ServiceException("There are no products in the user's cart");
		}
	}

	// Update an existing cart
	public boolean updateCart(long id, int qty) throws ServiceException {
		CartDAO cartDao = new CartDAO();

		try {
			return cartDao.updateCart(id, qty);
		} catch (DAOException e) {
			throw new ServiceException("Error updating cart");
		}
	}

	// Get a cart by its ID
	public Cart getCartById(long id) throws ServiceException {
		CartDAO cartDao = new CartDAO();

		try {
			return cartDao.getCartById(id);
		} catch (DAOException e) {
			throw new ServiceException("Error get cart by Cart ID");
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

	public boolean deleteCartByUserId(long userId) throws ServiceException {
		CartDAO cartDao = new CartDAO();

		try {
			return cartDao.deleteCartByUserId(userId);
		} catch (DAOException e) {
			throw new ServiceException("Error deleting cart by user ID");
		}
	}
}
