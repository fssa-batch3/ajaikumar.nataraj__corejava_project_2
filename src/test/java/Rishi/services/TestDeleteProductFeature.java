package Rishi.services;

import Rishi.model.ProductDetails;

public class TestDeleteProductFeature {
	public static void main(String[] args) {
		ProductDetails user1 = new ProductDetails(98765320);

		ProductService productService = new ProductService();

		try {
			productService.DeleteProduct(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}