package com.fssa.rishi.model;

import java.time.LocalDate;

public class Order {

	private long id;
	private long product_id;
	private long user_id;
	private String name;
	private int price;
	private int quantity;
	private int pincode;
	private LocalDate ordered_date;
	private String user_address;
	private String district;

	// Constructors, getters, and setters for each field
	// Constructor
	public Order(long id, long user_id, long product_id, String name, int price, int quantity, String user_address,
			String district, int pincode, LocalDate ordered_date) {
		this.id = id;
		this.product_id = product_id;
		this.user_id = user_id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.user_address = user_address;
		this.district = district;
		this.pincode = pincode;
		this.ordered_date = ordered_date;
	}

	public Order(long id, long user_id, long product_id, String name, int price, int quantity) {
		this.id = id;
		this.product_id = product_id;
		this.user_id = user_id;
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

	public long getproductId() {
		return product_id;
	}

	public void setproductId(long product_id) {
		this.product_id = product_id;
	}

	public long getuser_id() {
		return user_id;
	}

	public void setuser_id(long user_id) {
		this.user_id = user_id;
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

	public LocalDate getordered_date() {
		return ordered_date;
	}

	public void setordered_date(LocalDate ordered_date) {
		this.ordered_date = ordered_date;
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
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", product_id=" + product_id + ", user_id=" + user_id + ", name=" + name + ", price="
				+ price + ", quantity=" + quantity + ", pincode=" + pincode + ", ordered_date=" + ordered_date
				+ ", user_address=" + user_address + ", district=" + district + "]";
	}

}
