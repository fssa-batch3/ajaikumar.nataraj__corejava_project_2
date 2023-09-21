package com.fssa.rishi.model;

public class Cart {
	private long id;
	private long buyerId;
	private long productId;
	private String name;
	private int price;
	private int quantity;
	

	// Constructors, getters, and setters for each field
	// Constructor
	public Cart(long id, long buyerId, long productId, String name, int price, int quantity) {
		this.id = id;
		this.buyerId = buyerId;
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		
	}

	// Getters and setters for all fields
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	// Override toString() for debugging or display purposes
	@Override
	public String toString() {
		return "Cart [id=" + id + ", productId=" + productId +  ", buyerId=" + buyerId + ", name=" + name + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
}
