package Rishi.services;

import Rishi.model.Seller;

public class TestDeleteSellerFeature {
	public static void main(String[] args) {
		Seller user1 = new Seller("ajaikumar@gmail.com");

		SellerService sellerService = new SellerService();

		try {
			sellerService.DeleteSeller(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
