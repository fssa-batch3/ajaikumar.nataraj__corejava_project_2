package com.fssa.rishi.validation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.rishi.model.User;
import com.fssa.rishi.validation.exceptions.InvalidUserException;

public class TestValidateBuyer {
	public static boolean validateUser(User user) throws InvalidUserException {

		if (user != null && validateName(user.getUsername()) && validatePassword(user.getPassword())
				&& validateEmail(user.getEmail()) &&  validateDob(user.getDob()) && validatePhoneNumber(user.getPhoneNumber())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		} 
	}

	// Checking the loginUser present or not

		public static boolean validateLogIn(User user) throws InvalidUserException {
			if (user != null && validateEmail(user.getEmail()) && validatePassword(user.getPassword())) {
				return true;
			} else {
				throw new InvalidUserException("User details not valid");

			}
		}
	
		
		// Checking the validate update details

		public static boolean validateUpdateUser(User user) throws InvalidUserException {
			if (user != null && validateName(user.getUsername()) && validatePassword(user.getPassword())
					&& validateEmail(user.getEmail()) && validateDob(user.getDob())
					//&& validatePhoneNo(user.getPhoneNumber())
					) {
				return true;
			} else {
				throw new InvalidUserException("User details not valid");
			}
		}

		public static boolean validateDeleteUser(User user) throws InvalidUserException {
			if (user != null && validateEmail(user.getEmail()) ) {
				return true;
			} else {
				throw new InvalidUserException("User details not valid");

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
		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			System.out.println("The email address is: Invalid");
		}
		return isMatch;

	}
	
	public static boolean validatePhoneNumber(long phoneNo) {
	    boolean match = false;

	    String phoneNumber = Long.toString(phoneNo);
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
