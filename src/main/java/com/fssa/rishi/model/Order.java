package com.fssa.rishi.model;

import java.time.LocalDate;

public class Order {
	private long id;
	private long productId;
	private long buyerId;
	private String name;
	private int price;
	private int quantity;
	private String url;
	private LocalDate orderDate;
	private String buyAddress;

	// Constructors, getters, and setters for each field
	// Constructor
	public Order(long id, long productId, long buyerId, String name, int price, int quantity, String url, LocalDate orderDate,
			String buyAddress) {
		this.id = id;
		this.productId = productId;
		this.buyerId = buyerId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.url = url;
		this.orderDate = orderDate;
		this.buyAddress = buyAddress;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDate getorderDate() {
		return orderDate;
	}

	public void setorderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getBuyAddress() {
		return buyAddress;
	}

	public void setBuyAddress(String buyAddress) {
		this.buyAddress = buyAddress;
	}

	// Override toString() for debugging or display purposes
	@Override
	public String toString() {
		return "Order [id=" + id + ", productId=" + productId +  ", buyerId=" + buyerId + ", name=" + name + ", price=" + price + ", quantity="
				+ quantity + ", url=" + url + ", orderDate=" + orderDate + ", buyAddress=" + buyAddress + "]";
	}
}
