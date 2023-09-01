package com.fssa.rishi.model;

import java.util.Date;

public class Seller {

	private String email;
	private String landAddress;
	private long id;
	private String landType;
	private Date dob;
	private int pincode;
	private String gender;
	private String username;
	private String password;
	private long phoneNumber;
	private String district;
	private String state;
	private String homeAddress;
	private boolean isSeller;

	public Seller(String email, String landAddress, String LandType, long id) {
		this.email = email;
		this.landAddress = landAddress;
		this.id = id; 
		this.landType = LandType;
	}


	
	public Seller() {
		
	}

	public Seller(String email, String username, String password, long phoneNumber, String district, String state,
			String address, long id, Date dob, int pincode, String gender, boolean is_deleted, boolean isSeller) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.district = district;
		this.state = state;
		this.homeAddress = address;
		this.id = id;
		this.dob = dob;
		this.pincode = pincode;
		this.gender = gender;
		this.isSeller = isSeller;
	}

	public Seller(String email, String username, String password, long phoneNumber, String district, String state,
			String address, long id, int pincode, String gender,  boolean isSeller) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.district = district;
		this.state = state;
		this.homeAddress = address;
		this.id = id; 
		this.pincode = pincode; 
		this.gender = gender;
		this.isSeller = isSeller;
	}

	public Seller(String email, String username, String password, long phoneNo, String district, String state, String homeAddress, String landAddress, Date dob, int pincode, String gender, String LandType, long id) {
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNo;
		this.district = district;
		this.state = state; 
		this.homeAddress = homeAddress;
		this.dob = dob;
		this.pincode = pincode;
		this.gender = gender;
		this.landType = LandType;
		this.id = id;
		this.email = email;
	}

	public Seller(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Seller(String email, long id) {
		this.email = email;
		this.id = id;
	}

	public Seller(long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLandAddress(String landAddress) {
		this.landAddress = landAddress;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLandType(String LandType) {
		this.landType = LandType;
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

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNo(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setCountry(String district) {
		this.district = district;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public void setIsSeller(boolean isSeller) {
		this.isSeller = isSeller;
	}

	public String getEmail() {
		return email;
	}

	public String getLandType() {
		return landType;
	}

	public String getLandAddress() {
		return landAddress;
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

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public String getDistrict() {
		return district;
	}

	public String getState() {
		return state;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public boolean getIsSeller() {
		return isSeller;
	}



}
