package com.fssa.rishi.model;

public class Cart {
	private long id;
	private long buyerId;
	private long sellerId;
	private long productId;
	private String name;
	private int price;
	private int quantity;
	private String url;
	

	// Constructors, getters, and setters for each field
	// Constructor
	public Cart(long id, long buyerId, long sellerId, long productId, String url, String name, int price, int quantity) {
		this.id = id;
		this.buyerId = buyerId;
		this.setSellerId(sellerId);
		this.productId = productId;
		this.url = url;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		
	}

	public Cart(long id) {
		this.id = id;

	}

	public Cart(long id, int quantity) {
		this.id = id;
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
		return "Cart [id=" + id + ", productId=" + productId +  ", buyerId=" + buyerId + ", url=" + url +  ", name=" + name + ", price=" + price + ", quantity="
				+ quantity + "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}
}
