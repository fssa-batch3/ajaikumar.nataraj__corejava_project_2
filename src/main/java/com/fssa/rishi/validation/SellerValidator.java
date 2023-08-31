package com.fssa.rishi.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.rishi.model.Seller;
import com.fssa.rishi.model.User;
import com.fssa.rishi.validation.exceptions.InvalidUserException;

public class SellerValidator {

	public static boolean validateSeller(Seller user) throws InvalidUserException {

		if (user != null && validateEmail(user.getEmail())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}

	

	// Checking the validate update details

	public static boolean validateUpdateSeller(Seller user) throws InvalidUserException {
		if (user != null && validateName(user.getUsername()) && validatePassword(user.getPassword())
				&& validateEmail(user.getEmail())
				&& validatePhoneNumber(user.getPhoneNumber())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}

	public static boolean validateDeleteUser(Seller user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");

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
			System.out.println("The user name is valid.");
		} else {
			throw new InvalidUserException("The user name is not valid  eg:JohnDoe");
		}

		return match;
	}

	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match = false;
		if (password == null)
			return false;
		String pattern_string = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
		match = Pattern.matches(pattern_string, password);
		if (match) {
			System.out.println("Valid password.");
		} else {
			throw new InvalidUserException("Invalid password eg:PassWord@123!");
		}
		return match;
	}

	public static boolean validateEmail(String email) throws InvalidUserException {
		boolean isMatch = false;

		if (email == null)
			return false;
		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			throw new InvalidUserException("Invalid email eg:johndoe@gmail.com");
		}
		return isMatch;

	}

	public static boolean validatePhoneNumber(long phoneNo) throws InvalidUserException {
		boolean match = false;

		String phoneNumber = Long.toString(phoneNo);
		if (phoneNumber == null)
			return false;

		String regex = "^[6-9]{1}[1-9]{9}$";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phoneNumber);
		match = m.matches();

		if (match) {
			System.out.println("The phone number is valid");
		} else {
			throw new InvalidUserException("Invalid Phone Number eg:9876543210");
		}

		return match;
	}

	public static boolean validatePincode(int pincode) throws InvalidUserException {
	    String pincodeStr = Integer.toString(pincode);

	    String patternString = "^[0-9]{6}$";

	    boolean match = Pattern.matches(patternString, pincodeStr);

	    if (match) {
	        System.out.println("Valid pin code");
	    } else {
			throw new InvalidUserException("Enter valid pincode only six digits and numbers");
	    }

	    return match;
	}
	
	public static boolean validateUserDetailReadFeature (Seller user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail())) {
			return true;
		} else {
			throw new InvalidUserException("User detail is null");

		}
	}


}
