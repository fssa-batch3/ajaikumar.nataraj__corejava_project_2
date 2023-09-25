package com.fssa.rishi.services;

import java.util.List;

import com.fssa.rishi.dao.OrderDAO;
import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Order;
import com.fssa.rishi.services.exceptions.ServiceException;

public class OrderService {
	private OrderDAO OrderDao; // Assuming you have a OrderDao class

	// Create a new Order and add it to the database
	public boolean createOrder(Order order) throws ServiceException {
		OrderDAO createOrderDAO = new OrderDAO();
		try {
			return createOrderDAO.createOrder(order);
		} catch (DAOException e) {
			throw new ServiceException("Error creating Order");
		}
	}

	// Retrieve a Order by its ID
	public List<Order> getOrdersByUserId(long userId) throws ServiceException {
		OrderDAO orderDAO = new OrderDAO();
		try {
			return orderDAO.getOrdersByUserId(userId);
		} catch (DAOException e) {
			throw new ServiceException("You don't have any Order");
		}
	}

//
//    // Retrieve all Orders
//    public List<Order> getAllOrders() throws ServiceException {
//        try {
//            return OrderDao.getAllOrders();
//        } catch (DAOException e) {
//            throw new ServiceException("Error retrieving all Orders");
//        }
//    }

	// Update an existing Order
	public boolean updateOrder(Order Order) throws ServiceException {
		try {
			return OrderDao.updateOrder(Order);
		} catch (DAOException e) {
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
}
