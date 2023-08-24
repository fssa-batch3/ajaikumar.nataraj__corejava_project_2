package com.fssa.rishi.services;

import com.fssa.rishi.model.ProductDetails;

public class TestDeleteProductFeature {
	public static void main(String[] args) {
		long id = 1692694901440L;
		ProductDetails user1 = new ProductDetails(id);

		ProductService productService = new ProductService();

		try {
			productService.DeleteProduct(user1);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
}   