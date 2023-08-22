package com.fssa.rishi.validation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.rishi.model.Seller;
import com.fssa.rishi.model.User;
import com.fssa.rishi.services.exceptions.ServiceException;
import com.fssa.rishi.validation.exceptions.InvalidUserException;

public class SellerValidator {

	public static boolean validateSeller(Seller seller) throws ServiceException {

		if (seller != null && validateEmail(seller.getEmail())) {
			return true;
		} else {
			throw new ServiceException("User email is not valid");
		}
	}
 
	// Checking the loginUser present or not
	public static boolean validateLogIn(Seller seller) throws ServiceException {
		if (seller != null && validateEmail(seller.getEmail())) {
			return true;
		} else {
			throw new ServiceException("User email is not present");

		}
	}
 
	// Checking the validate update details

	public static boolean validateUpdateSeller(Seller seller) throws ServiceException {
		if (seller != null && validateEmail(seller.getEmail())) {
			return true;
		} else {
			throw new ServiceException("User details for update is invalid");

		}
	}

	public static boolean validateDeleteSeller(Seller seller) throws ServiceException {
		if (seller != null && validateEmail(seller.getEmail())) {
			return true;
		} else {
			throw new ServiceException("User details for delete is invalid");

		}
	}

	public static boolean validateName(String name) {
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
			System.out.println("The user name is not valid");
		}
		return match;
	}

	public static boolean validatePassword(String password) {
		boolean match = false;
		if (password == null)
			return false;
		String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(pattern_string, password);
		if (match) {
			System.out.println("Valid password.");
		} else {
			System.out.println("Invalid password.");
		}
		return match;
	}

	public static boolean validateEmail(String email) {
		boolean isMatch = false;

		if (email == null)
			return false;
		String regex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			System.out.println("The email address is: Invalid");
		}
		return isMatch;

	}

	public static boolean validatePhoneNumber(String phoneNumber) {
		boolean match = false;

		if (phoneNumber == null)
			return false;

		String regex = "^[1-9]\\d{9}$";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phoneNumber);
		match = m.matches();

		if (match) {
			System.out.println("The phone number is valid");
		} else {
			System.out.println("The phone number is not valid");
		}

		return match;
	}

	public static boolean validateDob(Date date) {
		if (date == null)
			return false;

		LocalDate dob = date.toLocalDate();

		// Perform your date of birth validation here
		LocalDate currentDate = LocalDate.now();
		LocalDate minDob = currentDate.minusYears(120);
		LocalDate maxDob = currentDate.minusYears(5);

		boolean isValidDob = (dob.isAfter(minDob) && dob.isBefore(maxDob));

		if (isValidDob) {
			System.out.println("The user date of birth is valid.");
		} else {
			System.out.println("The user date of birth is not valid");
		}

		return isValidDob;
	}

}
