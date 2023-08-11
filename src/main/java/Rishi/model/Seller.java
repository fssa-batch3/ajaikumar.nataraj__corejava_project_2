package Rishi.model;

public class Seller {

	private String email;
	private String landAddress;
	private String id;
	private String LandType;
	
//	private Date dob;
//	private int pincode;
//	private String gender;
//	private String username;
//	private String password;
//	private int phoneNo;
//	private String district;
//	private String state;
//	private String homeAddress;

//	public Seller(String email, String username, String password, int phoneNo, String district, String state, String homeAddress, String landAddress, Date dob, int pincode, String gender, String LandType, String id) {
	
	public Seller(String email, String landAddress, String LandType, String id) {
		this.email = email;
		this.landAddress = landAddress;
		this.id = id;
		this.LandType = LandType;

//		this.username = username;
//		this.password = password;
//		this.phoneNo = phoneNo;
//		this.district = district;
//		this.state = state;
//		this.homeAddress = homeAddress;
		
//		this.dob = dob;
//		this.pincode = pincode;
//		this.gender = gender;
	}
	
//	public Seller(String email, String password) {
//		this.email = email;
//		this.password = password;
//	}
	
	
	public Seller(String email, String id) {
		this.email = email;
		this.id = id;
	}
	
	
	public Seller(String id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLandAddress(String landAddress) {
		this.landAddress = landAddress;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setLandType(String LandType) {
		this.LandType = LandType;
	}
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}
//	public void setPincode(int pincode) {
//		this.pincode = pincode;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public void setPhoneNo(int phoneNo) {
//		this.phoneNo = phoneNo;
//	}
//	public void setCountry(String district) {
//		this.district = district;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
//	public void setHomeAddress(String homeAddress) {
//		this.homeAddress = homeAddress;
//	}
	

	
	
	
	public String getEmail() {
		return email;
	}
	public String getLandType() {
		return LandType;
	}
	public String getLandAddress() {
		return landAddress;
	}
	public String getId() {
		return id;
	}
//	public Date getDob() {
//		return dob;
//	}
//	public int getPincode() {
//		return pincode;
//	}
//	public String getGender() {
//		return gender;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public int getPhoneNumber() {
//		return phoneNo;
//	}
//	public String getDistrict() {
//		return district;
//	}
//	public String getState() {
//		return state;
//	}
//	public String getHomeAddress() {
//		return homeAddress;
//	}
	

	

	

//	@Override
//	public String toString() {
//		return "User [email=" + email + ", username=" + username + ", password=" + password + ", PhoneNumber=" + phoneNo + ", Country=" + country + ", State=" + state + ", Address=" + address + "]";
//	}

}
