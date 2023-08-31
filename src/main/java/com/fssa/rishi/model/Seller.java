package com.fssa.rishi.model;

import java.util.Date;

public class Seller {

	private String email;
	private String land_address;
	private long id;
	private String land_type;
	private Date dob;
	private int pincode;
	private String gender;
	private String username;
	private String password;
	private long phone_number;
	private String district;
	private String state;
	private String home_address;
	private boolean is_deleted;
	private boolean is_seller;

	public Seller(String email, String land_address, String LandType, long id) {
		this.email = email;
		this.land_address = land_address;
		this.id = id; 
		this.land_type = LandType;
	}

//	public Seller(String email, String land_address, String LandType) {
//		this.email = email;
//		this.land_address = land_address;
//		this.land_type = LandType;
//	}
	
	public Seller() {
		
	}

	public Seller(String email, String username, String password, long phone_number, String district, String state,
			String address, long id, Date dob, int pincode, String gender, boolean is_deleted, boolean is_seller) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.phone_number = phone_number;
		this.district = district;
		this.state = state;
		this.home_address = address;
		this.id = id;
		this.dob = dob;
		this.pincode = pincode;
		this.gender = gender;
		this.is_deleted = is_deleted;
		this.is_seller = is_seller;
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
		this.land_address = landAddress;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLandType(String LandType) {
		this.land_type = LandType;
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

	public void setPhoneNo(long phone_number) {
		this.phone_number = phone_number;
	}

	public void setCountry(String district) {
		this.district = district;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setHomeAddress(String homeAddress) {
		this.home_address = homeAddress;
	}

	public void setIsSeller(boolean is_seller) {
		this.is_seller = is_seller;
	}

	public String getEmail() {
		return email;
	}

	public String getLandType() {
		return land_type;
	}

	public String getLandAddress() {
		return land_address;
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
		return phone_number;
	}

	public String getDistrict() {
		return district;
	}

	public String getState() {
		return state;
	}

	public String getHomeAddress() {
		return home_address;
	}

//	public String getIsDeleted() {
//		return homeAddress;
//	}
	public boolean getIsSeller() {
		return is_seller;
	}

//	@Override
//	public String toString() {
//		return "User [email=" + email + ", username=" + username + ", password=" + password + ", PhoneNumber=" + phoneNo + ", Country=" + country + ", State=" + state + ", Address=" + address + "]";
//	}

}
