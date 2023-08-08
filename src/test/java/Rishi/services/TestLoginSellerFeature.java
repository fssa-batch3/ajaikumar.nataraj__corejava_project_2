package Rishi.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import Rishi.model.Seller;
import Rishi.services.exceptions.ServiceException;

public class TestLoginSellerFeature {

	public static void main(String[] args) {
		Seller user1 = new Seller("ajaikumarnataraj@gmail.com", "Ak@123");
		SellerService sellerService = new SellerService();

		try {
			sellerService.logInSeller(user1);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testLoginSuccess() {
		SellerService sellerService = new SellerService();
		Seller user1 = new Seller("ajai@gmail.com", "Ajai@123");
		try {
			assertTrue(sellerService.logInSeller(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
	
	@Test
	public void testLoginFailure() {
		SellerService sellerService = new SellerService();
		Seller user1 = new Seller("ajai@gmail.com", "Aji@23");
		try {
			assertFalse(sellerService.logInSeller(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testEmailPasswordNull() {
		SellerService sellerService = new SellerService();
		Seller user1 = null;
		try {
			assertFalse(sellerService.logInSeller(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testInvalidPassword() {
		SellerService sellerService = new SellerService();
		Seller user1 = new Seller("ajaikumarnatarajan@gmail.com", "Ajai@12345");
		try {
			assertFalse(sellerService.logInSeller(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testInvalidEmail() {
		SellerService sellerService = new SellerService();
		Seller user1 = new Seller("ajai@gmail.com", "Ajai@123");
		try {
			assertFalse(sellerService.logInSeller(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}
