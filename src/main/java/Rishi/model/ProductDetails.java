package Rishi.model;

import java.sql.Date;

public class ProductDetails {

	private int id;
	private String name;
	private int price;
	private int quantity;
	private String description;
	private String url;
	private String district;
	private String type;
	private String city;
	private int userId;
	private int pincode;
	private Date uploadDate;
	

	public ProductDetails(int id, String name, int price, int quantity, String description, String url, String district, String type, String city, int userId, int pincode, Date uploadDate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.district = district;
		this.description = description;
		this.url = url;
		this.district = district;
		this.type = type;
		this.city = city;
		this.userId = userId;
		this.pincode = pincode;
		this.uploadDate = uploadDate;
	}
	
	
	
	public ProductDetails(int id) {
		this.id = id;
	}



	public void setEmail(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	

	
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getDistrict() {
		return district;
	}
	public String getCity() {
		return city;
	}
	public String getDescription() {
		return description;
	}
	public String getUrl() {
		return url;
	}
	public String getType() {
		return type;
	}
	public int getUserId() {
		return userId;
	}
	public int getPincode() {
		return pincode;
	}
	public Date getUploadDate() {
		return uploadDate;
	}

//	@Override
//	public String toString() {
//		return "User [email=" + email + ", username=" + username + ", password=" + password + ", PhoneNumber=" + phoneNo + ", Country=" + country + ", State=" + state + ", Address=" + address + "]";
//	}

}
