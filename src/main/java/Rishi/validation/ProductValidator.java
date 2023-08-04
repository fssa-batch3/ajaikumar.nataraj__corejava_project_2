package Rishi.validation;

import java.util.regex.Pattern;

import Rishi.model.ProductDetails;
import Rishi.validation.exceptions.InvalidUserException;

public class ProductValidator {

	public static boolean validateProduct(ProductDetails product) throws InvalidUserException {

		if (product != null &&
			//	validateURL(product.getUrl()) &&
				validatePrice(product.getPrice())
				&& validateQuantity(product.getQuantity())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}
	
	public static boolean validateDeleteProduct(ProductDetails product) throws InvalidUserException {
		if (product != null ) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");

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
		String str =Integer.toString(price);
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
		String str =Integer.toString(quantity);
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



}
