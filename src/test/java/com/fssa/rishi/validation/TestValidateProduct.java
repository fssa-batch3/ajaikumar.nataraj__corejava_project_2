package com.fssa.rishi.validation;

import java.util.regex.Pattern;

import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.validation.exceptions.InvalidUserException;

public class TestValidateProduct {
	public static boolean validateProduct(ProductDetails product) throws InvalidUserException {

		if (product != null &&
		// validateURL(product.getUrl()) &&
				validatePrice(product.getPrice()) && validateQuantity(product.getQuantity())
				&& validateProductName(product.getName()) && validateProductType(product.getType()) && validateProductPincode(product.getPincode())) {
			return true;
		} else {
			throw new InvalidUserException("Product details not valid");
		}
	}
	
	
	public static boolean validateDeleteProduct(ProductDetails product) throws InvalidUserException {
		if (product != null) {
			return true;
		} else {
			throw new InvalidUserException("Product is not valid");

		} 
	}

	public static boolean validateURL(String url) {
		boolean match = false;
		if (url == null)
			return false;

		// Regular expression pattern for URL validation
		String patternString = "^(https?|ftp)://([a-zA-Z0-9.-]+(:[a-zA-Z0-9.&%$#?=_]+)?@)?([a-zA-Z0-9.-]+)(:[0-9]+)?(/[a-zA-Z0-9.-/]*)?(\\?[a-zA-Z0-9%&.-=]+)?$";

		match = Pattern.matches(patternString, url);

		if (match) {
			System.out.println("Valid URL.");
		} else {
			System.out.println("Invalid URL.");
		}

		return match;
	}

	public static boolean validatePrice(int price) {
		String str = Integer.toString(price);
		boolean match = false;
		if (str == null)
			return false;

		String patternString = "^[1-9]\\d*(\\.\\d{1,2})?$";

		match = Pattern.matches(patternString, str);

		if (match) {
			System.out.println("Valid price.");
		} else {
			System.out.println("Invalid price.");
		}

		return match;
	}

	public static boolean validateQuantity(int quantity) {
		String str = Integer.toString(quantity);
		boolean match = false;
		if (str == null)
			return false;

		String patternString = "^[1-9]\\d*(\\.\\d{1,2})?$";

		match = Pattern.matches(patternString, str);

		if (match) {
			System.out.println("Valid quantity.");
		} else {
			System.out.println("Invalid quantity.");
		}

		return match;
	}

	public static boolean validateProductName(String name) {
		if (name == null)
			return false;
 
		String patternString = "^[a-zA-Z0-9\\s_-]+$";

		boolean match = Pattern.matches(patternString, name);

		if (match) {
			System.out.println("Valid product name");
		} else {
			System.out.println("Invalid product name");
		}

		return match;
	}

	public static boolean validateProductType(String type) {
		if (type == null)
			return false;

		String patternString = "Fruit|Vegetable|Tea & Coffee|Cereals & Grains";

		boolean match = Pattern.matches(patternString, type);

		if (match) {
			System.out.println("Valid product type");
		} else {
			System.out.println("Invalid product type");
		}

		return match;
	}
	
	public static boolean validateProductPincode(int pincode) {
	    String pincodeStr = Integer.toString(pincode);

	    String patternString = "^[0-9]{6}$";

	    boolean match = Pattern.matches(patternString, pincodeStr);

	    if (match) {
	        System.out.println("Valid pin code");
	    } else {
	        System.out.println("Invalid pin code");
	    }

	    return match;
	}
}
