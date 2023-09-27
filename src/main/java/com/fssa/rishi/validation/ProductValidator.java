package com.fssa.rishi.validation;

import java.util.regex.Pattern;

import com.fssa.rishi.model.ProductDetails;
import com.fssa.rishi.validation.exceptions.InvalidProductException;

public class ProductValidator {

	public static boolean validateProduct(ProductDetails product) throws InvalidProductException {

		if (product != null &&
		// validateURL(product.getUrl()) &&
				validatePrice(product.getPrice()) && validateQuantity(product.getQuantity())
				&& validateProductName(product.getName()) && validateProductType(product.getType())
				&& validateProductPincode(product.getPincode())) {
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

		if (url == null)
			throw new InvalidProductException("url should not be empty");

		// Regular expression pattern for URL validation
		String patternString = "^(https?|ftp)://([a-zA-Z0-9.-]+(:[a-zA-Z0-9.&%$#?=_]+)?@)?([a-zA-Z0-9.-]+)(:\\d+)?(/[a-zA-Z0-9.-/]*)?(\\?[a-zA-Z0-9%&.-=]+)?$";

		boolean match = Pattern.matches(patternString, url);

		if (match) {
			return true;
		} else {
			throw new InvalidProductException("Enter valid URL");
		}

	}

	public static boolean validatePrice(int price) throws InvalidProductException {
		if (price < 1 || price > 1000) {
			throw new InvalidProductException("Invalid price eg: Rs.1 to Rs.99999");
		}
		return true;

	}

	public static boolean validateQuantity(int quantity) throws InvalidProductException {
		if (quantity < 1 || quantity > 1000) {
			throw new InvalidProductException("Enter a valid quantity between 1 and 1000.");
		}
		return true;
	}

	public static boolean validateProductName(String name) throws InvalidProductException {
		if (name == null)
			throw new InvalidProductException("Name should not be null");

		String patternString = "^[A-Za-z]+(\\s[A-Za-z]+)?$";

		boolean match = Pattern.matches(patternString, name);

		if (match) {
			return true;
		} else {
			throw new InvalidProductException("Invalid name (Only alphabets)");
		}

	}

	public static boolean validateProductType(String type) throws InvalidProductException {
		if (type == null)
			throw new InvalidProductException("Type should not be null");

		String patternString = "Fruit|Vegetable|Tea & Coffee|Cereals & Grains";

		boolean match = Pattern.matches(patternString, type);

		if (match) {
			return true;
		} else {
			throw new InvalidProductException("Enter valid product type");
		}

	}

	public static boolean validateProductPincode(int pincode) throws InvalidProductException {
	    String pincodeStr = String.valueOf(pincode);

	    if (pincodeStr.length() == 6 && pincodeStr.matches("^[0-9]+$")) {
	        return true;
	    } else {
	        throw new InvalidProductException("Enter a valid pincode with exactly six digits");
	    }
	}


	public static boolean validateProductDetailReadFeature(ProductDetails productDetails)
			throws InvalidProductException {
		if (productDetails != null && validateId(productDetails.getId())) {
			return true;
		} else {
			throw new InvalidProductException("User detail is null");

		}
	}

	private static boolean validateId(long id) throws InvalidProductException {
		String pincodeStr = Long.toString(id);

		String patternString = "^\\d{13}$";

		boolean match = Pattern.matches(patternString, pincodeStr);

		if (match) {
			return true;
		} else {
			throw new InvalidProductException("Invalid User id");
		}

	}

}
