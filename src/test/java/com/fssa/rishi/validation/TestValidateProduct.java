package com.fssa.rishi.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.validation.exceptions.InvalidProductException;

class TestValidateProduct {
	// For validate Name
	@Test
	void testValidName() throws InvalidProductException {
		assertTrue(ProductValidator.validateProductName("Apple"));
	}

	@Test
	void testInvalidNameWithSpecialCharacters() throws InvalidProductException {
		InvalidProductException result = assertThrows(InvalidProductException.class,
				() -> ProductValidator.validateProductName("Apple@!"));
		assertEquals("Invalid name (Only alphabets)", result.getMessage());
	}

	

	// For validate Type
	@Test
	void testValidFruitProductType() throws InvalidProductException {
		assertTrue(ProductValidator.validateProductType("Fruit"));
	}

	@Test
	void testValidVegetableProductType() throws InvalidProductException {
		assertTrue(ProductValidator.validateProductType("Vegetable"));
	}

	@Test
	void testValidTeaAndCoffeeProductType() throws InvalidProductException {
		assertTrue(ProductValidator.validateProductType("Tea & Coffee"));
	}

	@Test
	void testValidCerealsAndGrainsProductType() throws InvalidProductException {
		assertTrue(ProductValidator.validateProductType("Cereals & Grains"));
	}

	

	// For validate Pincode
	@Test
	void testValidPincode() throws InvalidProductException {
		assertTrue(ProductValidator.validateProductPincode(654321));
	}

	@Test
	void testInvalidPincodeDigitLessThanSix() throws InvalidProductException {
		InvalidProductException result = assertThrows(InvalidProductException.class,
				() -> ProductValidator.validateProductPincode(543218));
		assertEquals("Enter valid pincode only six digits and numbers", result.getMessage());
	}

}
