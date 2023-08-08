package Rishi.model;

import java.sql.Date;

public class User {

	private String email;
	private String username;
	private String password;
	private String phoneNumber;
	private String district;
	private String state;
	private String address;
	private String id;
	private Date dob;
	private int pincode;
	private String gender;
	private boolean isDeleted;

	public User(String email, String username, String password, String phoneNumber, String district, String state, String address, String id, Date dob, int pincode, String gender, boolean isDeleted) {
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
	public void setPhoneNo(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public void setId(String id) {
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

	
	
	
	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getPhoneNumber() {
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
	public String getId() {
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

	

//	@Override
//	public String toString() {
//		return "User [email=" + email + ", username=" + username + ", password=" + password + ", PhoneNumber=" + phoneNo + ", Country=" + country + ", State=" + state + ", Address=" + address + "]";
//	}

}
