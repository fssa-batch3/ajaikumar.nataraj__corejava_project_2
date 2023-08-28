package com.fssa.rishi.validation;

import java.util.regex.Pattern;

import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.services.exceptions.ServiceException;
import com.fssa.rishi.validation.exceptions.InvalidProductException;
import com.fssa.rishi.validation.exceptions.InvalidUserException;

public class ProductValidator {

	public static boolean validateProduct(ProductDetails product) throws InvalidProductException {

		if (product != null &&
		// validateURL(product.getUrl()) &&
				validatePrice(product.getPrice()) && validateQuantity(product.getQuantity())
				&& validateProductName(product.getName()) && validateProductType(product.getType()) && validateProductPincode(product.getPincode())) {
			return true;
		} else {
			throw new InvalidProductException("Product details not valid");
		}
	} 
	 
	
	public static boolean validateDeleteProduct(ProductDetails product) throws InvalidProductException {
		if (product != null) {
			return true;
		} else {
			throw new InvalidProductException("Product is not valid");

		}
	}

	public static boolean validateURL(String url) throws InvalidProductException {
		boolean match = false;
		if (url == null)
			return false;

		// Regular expression pattern for URL validation
		String patternString = "^(https?|ftp)://([a-zA-Z0-9.-]+(:[a-zA-Z0-9.&%$#?=_]+)?@)?([a-zA-Z0-9.-]+)(:[0-9]+)?(/[a-zA-Z0-9.-/]*)?(\\?[a-zA-Z0-9%&.-=]+)?$";

		match = Pattern.matches(patternString, url);

		if (match) {
			System.out.println("Valid URL.");
		} else {
			throw new InvalidProductException("Enter valid URL");
		}

		return match;
	}

	public static boolean validatePrice(int price) throws InvalidProductException {
		String str = Integer.toString(price);
		boolean match = false;
		if (str == null)
			return false;

		String patternString = "^[1-9]\\d*(\\.\\d{1,2})?$";

		match = Pattern.matches(patternString, str);

		if (match) {
			System.out.println("Valid price.");
		} else {
			throw new InvalidProductException("Enter valid Price");
		}
 
		return match;
	}

	public static boolean validateQuantity(int quantity) throws InvalidProductException {
		String str = Integer.toString(quantity);
		boolean match = false;
		if (str == null)
			return false;

		String patternString = "^[1-9]\\d*(\\.\\d{1,2})?$";

		match = Pattern.matches(patternString, str);

		if (match) {
			System.out.println("Valid quantity.");
		} else {
			throw new InvalidProductException("Enter valid quantity");
		}

		return match;
	}

	public static boolean validateProductName(String name) throws InvalidProductException {
		if (name == null)
			return false;

		String patternString = "^[a-zA-Z0-9\\s_-]+$";

		boolean match = Pattern.matches(patternString, name);

		if (match) {
			System.out.println("Valid product name");
		} else {
			throw new InvalidProductException("Enter valid name only letters");
		}

		return match;
	}

	public static boolean validateProductType(String type) throws InvalidProductException {
		if (type == null)
			return false;

		String patternString = "Fruit|Vegetable|Tea & Coffee|Cereals & Grains";

		boolean match = Pattern.matches(patternString, type);

		if (match) {
			System.out.println("Valid product type");
		} else {
			throw new InvalidProductException("Enter valid product type Fruit or Vegetable or Tea & Coffee or Cereals & Grains");
		}

		return match;
	}
	
	public static boolean validateProductPincode(int pincode) throws InvalidProductException {
	    String pincodeStr = Integer.toString(pincode);

	    String patternString = "^[0-9]{6}$";

	    boolean match = Pattern.matches(patternString, pincodeStr);

	    if (match) {
	        System.out.println("Valid pin code");
	    } else {
			throw new InvalidProductException("Enter valid pincode only six digits and numbers");
	    }

	    return match;
	}
}
