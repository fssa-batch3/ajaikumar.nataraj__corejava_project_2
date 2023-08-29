package com.fssa.rishi.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.rishi.dao.SellerDAO;
import com.fssa.rishi.dao.exceptions.DAOException;
import com.fssa.rishi.model.Seller;

class TestReadSellerFeature {

	@Test
	void testListSellerNotEmptyTrue() throws DAOException {
		SellerDAO sellerDAO = new SellerDAO();

		try {
			List<Seller> seller = sellerDAO.listSellers();
			Assertions.assertNotNull(seller, "List of architects is null.");
			Assertions.assertTrue(!seller.isEmpty(), "List of architects is empty.");
		} catch (DAOException e) {
			throw new DAOException(e);
		}
	}

	@Test
	void testListSeller() throws DAOException {
		SellerDAO sellerDAO = new SellerDAO();

		try {
			List<Seller> seller = sellerDAO.listSellers();
			Assertions.assertNotNull(seller, "List of architects is null.");
			Assertions.assertFalse(seller.isEmpty(), "List of architects is not empty.");
		} catch (DAOException e) {
			throw new DAOException(e);
		}
	}

}
