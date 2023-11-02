package com.fssa.rishi.services;

import java.util.List;

import com.fssa.rishi.dao.OrderDAO;
import com.fssa.rishi.dao.UserDAO;
import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Order;
import com.fssa.rishi.services.exceptions.ServiceException;
import com.fssa.rishi.validation.UserValidator;
import com.fssa.rishi.validation.exceptions.InvalidUserException;

public class OrderService {
	OrderDAO orderDAO = new OrderDAO();

	// Create a new Order and add it to the database
	public boolean createOrder(Order order) throws ServiceException {
		try {
			return orderDAO.createOrder(order);
		} catch (DAOException e) {
			 throw new ServiceException("Error creating Order");
		}
	}

	public boolean createOrders(List<Order> orders) throws ServiceException {
		try {
			return orderDAO.createOrders(orders);
		} catch (DAOException e) {
			throw new ServiceException("Error creating Orders");
		}
	}

	// Retrieve a Order by its ID
	public List<Order> getOrdersByUserId(long userId, int status) throws ServiceException {
		try {
			return orderDAO.getOrdersByUserId(userId, status);
		} catch (DAOException e) {
			throw new ServiceException("You don't have any Order");
		}
	}

	// Retrieve a Order by its ID for Notification
	public List<Order> getOrdersByUserIdForPendingOrderNotification(long userId) throws ServiceException {
		try {
			return orderDAO.getOrdersByUserIdForPendingOrderNotification(userId);
		} catch (DAOException e) {
			throw new ServiceException("You don't have any Order");
		}
	}

	// Retrieve a Order by its ID for Notification
	public List<Order> getOrdersByUserIdForAcceptedOrderNotification(long userId) throws ServiceException {
		try {
			return orderDAO.getOrdersByUserIdForAcceptedOrderNotification(userId);
		} catch (DAOException e) {
			throw new ServiceException("You don't have any Order");
		}
	}

	// Retrieve a Order by its ID for Notification
	public List<Order> getOrdersByUserIdForRejectedOrderNotification(long userId) throws ServiceException {
		try {
			return orderDAO.getOrdersByUserIdForRejectedOrderNotification(userId);
		} catch (DAOException e) {
			throw new ServiceException("You don't have any Order");
		}
	}

	// Update an existing Order
	public boolean updateOrder(Order Order) throws ServiceException {
		try {
			return orderDAO.updateOrder(Order);
		} catch (DAOException e) {
			throw new ServiceException("Error updating Order");
		}
	}

	// Update an existing Order
	public boolean updateUserDetailInOrder(Order Order) throws ServiceException {
		try {
			return orderDAO.updateUserDetailInOrder(Order);
		} catch (DAOException e) {
			throw new ServiceException("Error updating Order");
		}
	}

	// Delete a Order by its ID
	public boolean deleteOrder(long orderId) throws ServiceException {
		try {
			return orderDAO.deleteOrder(orderId);
		} catch (DAOException e) {
			throw new ServiceException("Error deleting Order by ID");
		}
	}

	public boolean NotificationAccept(long id) throws ServiceException {
		try {

			return orderDAO.notificationAccept(id);			

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean NotificationReject(long id) throws ServiceException {
		try {

			return orderDAO.notificationReject(id);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
