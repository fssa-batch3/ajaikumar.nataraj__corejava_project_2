package com.fssa.rishi.services;

import com.fssa.rishi.model.ProductDetails;

public class TestDeleteProductFeature {
	public static void main(String[] args) {
		ProductDetails user1 = new ProductDetails(1692547489070L);

		ProductService productService = new ProductService();

		try {
			productService.DeleteProduct(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} 