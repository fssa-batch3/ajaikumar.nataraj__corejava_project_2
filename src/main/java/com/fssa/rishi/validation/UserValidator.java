package com.fssa.rishi.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.rishi.model.User;
import com.fssa.rishi.validation.exceptions.InvalidUserException;

public class UserValidator {

	public static boolean validateUser(User user) throws InvalidUserException {

		if (user != null && validateName(user.getUsername()) && validatePassword(user.getPassword())
				&& validateEmail(user.getEmail()) && validatePincode(user.getPincode())
				&& validatePhoneNumber(user.getPhoneNumber())) {
			return true;
		} else {
		 	throw new InvalidUserException("User details not valid for register");
		}
	} 
  
	// Checking the loginUser present or not

	public static boolean validateLogIn(User user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail()) && validatePassword(user.getPassword())) {
			return true;
		} else {
			throw new InvalidUserException("Invalid Login Credentials");

		} 
	}

	// Checking the validate update details

	public static boolean validateUpdateUser(User user) throws InvalidUserException {
		if (user != null && validateName(user.getUsername()) && validatePassword(user.getPassword())
				&& validateEmail(user.getEmail()) && validatePhoneNumber(user.getPhoneNumber())) {
			return true;
		} else {
			throw new InvalidUserException("Invalid details for update");
		}
	}

	public static boolean validateDeleteUser(User user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail())) {
			return true;
		} else {
			throw new InvalidUserException("Invalid email for delete");

		}
	}

	public static boolean validateName(String name) throws InvalidUserException {
		boolean match = false;

		if (name == null)
			return false;

		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException("The user name is not valid  eg:JohnDoe");
		}

		
	}

	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match = false;
		if (password == null)
			return false;
		String pattern_string = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=.*[a-zA-Z]).{8,}$";
		match = Pattern.matches(pattern_string, password);
		if (match) {
			return true;
		} else {
			throw new InvalidUserException("Invalid password eg:PassWord@123!");
		}
		
	}

	public static boolean validateEmail(String email) throws InvalidUserException {
		boolean isMatch = false;

		if (email == null)
			return false;
		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException("Invalid email eg:johndoe@gmail.com");
		}

	}

	public static boolean validatePhoneNumber(long phoneNo) throws InvalidUserException {
		boolean match = false;

		String phoneNumber = Long.toString(phoneNo);
		if (phoneNumber == null)
			return false;

		String regex = "^[6-9][0-9]{9}$";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phoneNumber);
		match = m.matches();

		if (match) {
			return true;
		} else {
			throw new InvalidUserException("Invalid Phone Number eg:9876543210");
		}

		
	}

	public static boolean validatePincode(int pincode) throws InvalidUserException {
		String pincodeStr = Integer.toString(pincode);

		String patternString = "^\\d{6}$";

		boolean match = Pattern.matches(patternString, pincodeStr);

		if (match) {
			return true;
		} else {
			throw new InvalidUserException("Enter valid pincode only six digits and numbers");
		}

		
	}

	public static boolean validateUserDetailReadFeature (User user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail())) {
			return true;
		} else {
			throw new InvalidUserException("User detail is null");

		}
	}

}
