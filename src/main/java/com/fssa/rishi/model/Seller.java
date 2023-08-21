package com.fssa.rishi.model;

import java.util.Date;

public class Seller {

	private String email;
	private String landAddress;
	private long id;
	private String LandType;
	private Date dob;
	private int pincode;
	private String gender;
	private String username;
	private String password;
	private long phoneNo;
	private String district;
	private String state;
	private String homeAddress;
	// private boolean isDeleted;
	private boolean isSeller;
	

	
	public Seller(String email, String landAddress, String LandType, long id) {
		this.email = email;
		this.landAddress = landAddress;
		this.id = id;
		this.LandType = LandType;
	}
	
	public Seller(String email, String landAddress, String LandType) {
		this.email = email;
		this.landAddress = landAddress;
		this.LandType = LandType;
	}
	
	public Seller(String email, String username, String password, long phoneNumber, String district, String state, String address, long id, Date dob, int pincode, String gender, boolean isDeleted, boolean isSeller) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.phoneNo = phoneNumber;
		this.district = district;
		this.state = state;
		this.homeAddress = address;
		this.id = id;
		this.dob = dob;
		this.pincode = pincode;
		this.gender = gender;
		// this.isDeleted = isDeleted;
		this.isSeller = isSeller;
	}
	
//	public Seller(String email, String username, String password, String phoneNo, String district, String state, String homeAddress, String landAddress, Date dob, int pincode, String gender, String LandType, String id) {
//		this.username = username;
//		this.password = password;
//		this.phoneNo = phoneNo;
//		this.district = district;
//		this.state = state;
//		this.homeAddress = homeAddress;
//		this.dob = dob;
//		this.pincode = pincode;
//		this.gender = gender;
//		this.LandType = LandType;
//		this.id = id;
//		this.email = email;
//	}
	
//	public Seller(String email, String password) {
//		this.email = email;
//		this.password = password;
//	}
	
	
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
		this.LandType = LandType;
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
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
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
		return LandType;
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
		return phoneNo;
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
//	public String getIsDeleted() {
//		return homeAddress;
//	}
	public boolean getIsSeller() {
		return isSeller;
	}
	

	

	

//	@Override
//	public String toString() {
//		return "User [email=" + email + ", username=" + username + ", password=" + password + ", PhoneNumber=" + phoneNo + ", Country=" + country + ", State=" + state + ", Address=" + address + "]";
//	}

}
