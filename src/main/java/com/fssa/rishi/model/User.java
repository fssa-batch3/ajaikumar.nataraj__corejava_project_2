package com.fssa.rishi.model;

import java.sql.Date;

public class User {

	private String email;
	private String username;
	private String password;
	private long phoneNumber;
	private String district;
	private String state;
	private String address;
	private long id;
	private Date dob;
	private int pincode;
	private String gender;
	private boolean isDeleted;
	private boolean isSeller;

	public User() {

	}

	public User(String email, String username, String password, long phoneNumber, String district, String state,
			String address, long id, Date dob, int pincode, String gender, boolean isDeleted, boolean isSeller) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.district = district;
		this.state = state;
		this.address = address;
		this.id = id;
		this.dob = dob;
		this.pincode = pincode;
		this.gender = gender;
		this.isDeleted = isDeleted;
		this.isSeller = isSeller;
	}

	public User(String email, String username, String password, long phoneNumber, String district, String state,
			String address, Date dob, int pincode, String gender) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.district = district;
		this.state = state;
		this.address = address;
		this.dob = dob;
		this.pincode = pincode;
		this.gender = gender;
	}

	public User(long id, String email, String username, String password, long phoneNumber, String district,
			String state, String address, Date dob, int pincode, String gender) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.district = district;
		this.state = state;
		this.address = address;
		this.dob = dob;
		this.pincode = pincode;
		this.gender = gender;
	}

	public User(String email, boolean isDeleted) {
		this.email = email;
		this.isDeleted = isDeleted;
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

	public void setPhoneNo(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setDistrict(String district) {
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
		this.isDeleted = isDeleted;
	}

	public void setIsSeller(boolean isSeller) {
		this.isSeller = isSeller;
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
		return phoneNumber;
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
		return isDeleted;
	}

	public boolean getIsSeller() {
		return isSeller;
	}
	
	@Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone_number=" + phoneNumber +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", pincode=" + pincode +
                ", gender='" + gender + '\'' +
                '}';
    }

	public void setIsSeller(Seller sellerResult) {
		// TODO Auto-generated method stub
		
	}

}

