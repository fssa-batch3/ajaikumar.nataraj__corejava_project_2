package com.fssa.rishi.model;

import java.time.LocalDate;

public class Order {

	private long id;
	private long productId;
	private long userId;
	private long sellerId;
	private String url;
	private String name;
	private int price;
	private int quantity;
	private long phoneNumber;
	private int pincode;
	private LocalDate orderedDate;
	private String userAddress;
	private String district;
	private int status;
	private String username;

	
	public Order(long id, long userId, long sellerId, long productId, String url, String name, int price, int quantity, long phone,
			String userAddress, String district, int pincode, LocalDate orderedDate, int status) {
		this.id = id;
		this.userId = userId;
		this.sellerId = sellerId;
		this.productId = productId;
		this.url = url;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.phoneNumber = phone;
		this.userAddress = userAddress;
		this.district = district;
		this.pincode = pincode;
		this.orderedDate = orderedDate;
		this.setStatus(status);
	}
	
	public Order(long id, long userId, long sellerId, long productId, String url, String name, int price, int quantity, long phone,
			String userAddress, String district, int pincode, LocalDate orderedDate, int status, String username) {
		this.id = id;
		this.userId = userId;
		this.sellerId = sellerId;
		this.productId = productId;
		this.url = url;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.phoneNumber = phone;
		this.userAddress = userAddress;
		this.district = district;
		this.pincode = pincode;
		this.orderedDate = orderedDate;
		this.setStatus(status);
		this.setusername(username);
	}


	public Order(long userId, long sellerId, long productId, String url, String name, int price, int quantity, LocalDate orderedDate) {
		this.productId = productId;
		this.userId = userId;
		this.sellerId = sellerId;
		this.url = url;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.orderedDate = orderedDate;
	}

	public Order(long userId, String address, String district, int pincode, long phone, LocalDate orderedDate) {
		this.userId = userId;
		this.userAddress = address;
		this.district = district;
		this.pincode = pincode;
		this.phoneNumber = phone;
		this.orderedDate = orderedDate;
	}

	

	// Getters and setters for all fields
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getproductId() {
		return productId;
	}

	public void setproductId(long productId) {
		this.productId = productId;
	}

	public long getuserId() {
		return userId;
	}

	public void setuserId(long userId) {
		this.userId = userId;
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

	public LocalDate getorderedDate() {
		return orderedDate;
	}

	public void setorderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}

	// Override toString() for debugging or display purposes}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getUser_address() {
		return userAddress;
	}

	public void setUser_address(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", product_id=" + productId + ", user_id=" + userId + ", name=" + name + ", price="
				+ price + ", quantity=" + quantity + ", pincode=" + pincode + ", ordered_date=" + orderedDate
				+ ", user_address=" + userAddress + ", district=" + district + "]";
	}

	public long getPhone_number() {
		return phoneNumber;
	}

	public void setPhone_number(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getSeller_id() {
		return sellerId;
	}

	public void setSeller_id(long sellerId) {
		this.sellerId = sellerId;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

}
