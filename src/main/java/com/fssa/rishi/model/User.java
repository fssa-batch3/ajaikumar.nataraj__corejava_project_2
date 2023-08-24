package com.fssa.rishi.model;

import java.sql.Date;

public class User {

	private String email;
	private String username;
	private String password;
	private long phone_number;
	private String district;
	private String state;
	private String address;
	private long id;
	private Date dob;
	private int pincode;
	private String gender;
	private boolean is_deleted;
	private boolean is_seller;

	public User(String email, String username, String password, long phone_number, String district, String state, String address, long id, Date dob, int pincode, String gender, boolean is_deleted, boolean is_seller) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.phone_number = phone_number;
		this.district = district;
		this.state = state;
		this.address = address; 
		this.id = id;
		this.dob = dob;
		this.pincode = pincode;
		this.gender = gender;
		this.is_deleted = is_deleted;
		this.is_seller = is_seller;
	}
	
	public User(String email, String username, String password, long phone_number, String district, String state, String address,  Date dob, int pincode, String gender) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.phone_number = phone_number;
		this.district = district;
		this.state = state;
		this.address = address;
		this.dob = dob;
		this.pincode = pincode;
		this.gender = gender;
	}
	public User(long id, String email, String username, String password, long phone_number, String district, String state, String address,  Date dob, int pincode, String gender) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phone_number = phone_number;
		this.district = district;
		this.state = state;
		this.address = address;
		this.dob = dob;
		this.pincode = pincode;
		this.gender = gender;
	}
	
	public User(String email, boolean isDeleted) {
		this.email = email;
		this.is_deleted = isDeleted;
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
 
 
	
 
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhoneNo(long phone_number) {
		this.phone_number = phone_number;
	}
	public void setCountry(String district) {
		this.district = district;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setIsDeleted(boolean isDeleted) {
		this.is_deleted = isDeleted;
	}
	public void setIsSeller(boolean isSeller) {
		this.is_seller = isSeller;
	}

	
	
	
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public long getPhoneNumber() {
		return phone_number;
	}
	public String getDistrict() {
		return district;
	}
	public String getState() {
		return state;
	}
	public String getAddress() {
		return address;
	}
	public long getId() {
		return id;
	}
	public Date getDob() {
		return dob;
	}
	public int getPincode() {
		return pincode;
	}
	public String getGender() {
		return gender;
	}
	public boolean getIsDeleted() {
		return is_deleted;
	}
	public boolean getIsSeller() {
		return is_seller;
	}

}
