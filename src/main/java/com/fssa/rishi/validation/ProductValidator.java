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
			System.out.println("Valid URL.");
			return true;
		} else {
			throw new InvalidProductException("Enter valid URL");
		}

		
	}

	public static boolean validatePrice(int price) throws InvalidProductException {
		String str = Integer.toString(price);

		if (str == null)
			throw new InvalidProductException("Price should not be empty");

		String patternString = "^\\d{2,5}$";

	boolean	match = Pattern.matches(patternString, str);

		if (match) {
			System.out.println("Valid price.");
			return true;
		} else {
			throw new InvalidProductException("Invalid price eg: Rs.1 to Rs.99999");
		}


	}

	public static boolean validateQuantity(int quantity) throws InvalidProductException {
		String str = Integer.toString(quantity);
		
		if (str == null)
			throw new InvalidProductException("Quantity should not be null");

		String patternString = "^\\d{2,5}$";

		boolean match = Pattern.matches(patternString, str);

		if (match) {
			System.out.println("Valid quantity.");
			return true;
		} else {
			throw new InvalidProductException("Enter valid quantity eg: Rs.1 to Rs.99999");
		}

	
	}

	public static boolean validateProductName(String name) throws InvalidProductException {
		if (name == null)
			throw new InvalidProductException("Name should not be null");

		String patternString = "^[a-zA-Z\\s_-]+$";

		boolean match = Pattern.matches(patternString, name);

		if (match) {
			System.out.println("Valid product name");
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
			System.out.println("Valid product type");
			return true;
		} else {
			throw new InvalidProductException(
					"Enter valid product type Fruit or Vegetable or Tea & Coffee or Cereals & Grains");
		}

		
	}

	public static boolean validateProductPincode(int pincode) throws InvalidProductException {
		String pincodeStr = Integer.toString(pincode);

		String patternString = "^\\d{6}$";

		boolean match = Pattern.matches(patternString, pincodeStr);

		if (match) {
			System.out.println("Valid pin code");
			return true;
		} else {
			throw new InvalidProductException("Enter valid pincode only six digits and numbers");
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
			System.out.println("Valid id");
			return true;
		} else {
			throw new InvalidProductException("Invalid User id");
		}

	}

}
