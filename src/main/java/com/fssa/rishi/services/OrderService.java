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

	// Create a new Order and add it to the database
	public boolean createOrder(Order order) throws ServiceException {
		OrderDAO createOrderDAO = new OrderDAO();
		try {
			return createOrderDAO.createOrder(order);
		} catch (DAOException e) {
			// throw new ServiceException("Error creating Order");
			e.printStackTrace();
			return false;

		}
	}

	public boolean createOrders(List<Order> orders) throws ServiceException {
		OrderDAO createOrderDAO = new OrderDAO();
		System.out.println("orderservice : " + orders);
		try {
			return createOrderDAO.createOrders(orders);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Error creating Orders");
		}
	}

	// Retrieve a Order by its ID
	public List<Order> getOrdersByUserId(long userId, int status) throws ServiceException {
		OrderDAO orderDAO = new OrderDAO();
		try {
			return orderDAO.getOrdersByUserId(userId, status);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("You don't have any Order");
		}
	}

	// Retrieve a Order by its ID for Notification
	public List<Order> getOrdersByUserIdForPendingOrderNotification(long userId) throws ServiceException {
		OrderDAO orderDAO = new OrderDAO();
		try {
			return orderDAO.getOrdersByUserIdForPendingOrderNotification(userId);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("You don't have any Order");
		}
	}

	// Retrieve a Order by its ID for Notification
	public List<Order> getOrdersByUserIdForAcceptedOrderNotification(long userId) throws ServiceException {
		OrderDAO orderDAO = new OrderDAO();
		try {
			return orderDAO.getOrdersByUserIdForAcceptedOrderNotification(userId);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("You don't have any Order");
		}
	}

	// Retrieve a Order by its ID for Notification
	public List<Order> getOrdersByUserIdForRejectedOrderNotification(long userId) throws ServiceException {
		OrderDAO orderDAO = new OrderDAO();
		try {
			return orderDAO.getOrdersByUserIdForRejectedOrderNotification(userId);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("You don't have any Order");
		}
	}

	// Update an existing Order
	public boolean updateOrder(Order Order) throws ServiceException {
		OrderDAO orderDAO = new OrderDAO();

		try {
			return orderDAO.updateOrder(Order);
		} catch (DAOException e) {
			throw new ServiceException("Error updating Order");
		}
	}

	// Update an existing Order
	public boolean updateUserDetailInOrder(Order Order) throws ServiceException {
		OrderDAO orderDAO = new OrderDAO();

		System.out.println(Order);
		try {
			return orderDAO.updateUserDetailInOrder(Order);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Error updating Order");
		}
	}

	// Delete a Order by its ID
	public boolean deleteOrder(long OrderId) throws ServiceException {
		OrderDAO createOrderDAO = new OrderDAO();

		try {
			return createOrderDAO.deleteOrder(OrderId);
		} catch (DAOException e) {
			throw new ServiceException("Error deleting Order by ID");
		}
	}

	public boolean NotificationAccept(long id) throws ServiceException {
		OrderDAO createOrderDAO = new OrderDAO();
		try {

			if (createOrderDAO.NotificationAccept(id)) {
				System.out.println(id + " Order Successfully Accepted!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean NotificationReject(long id) throws ServiceException {
		OrderDAO createOrderDAO = new OrderDAO();
		try {

			if (createOrderDAO.NotificationReject(id)) {
				System.out.println(id + " Order Successfully Accepted!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
