package com.fssa.rishi.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.validation.exceptions.InvalidUserException;

class TestValidateBuyer {

	// For validate Name
	@Test
	void testValidName() throws InvalidUserException {
		assertTrue(UserValidator.validateName("Ajaikumar"));
	}

	@Test
	void testInvalidNameWithSpecialCharacters() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> UserValidator.validateName("Ajaikumar@!"));
		assertEquals("The user name is not valid  eg:JohnDoe", result.getMessage());
	}

	@Test
	void testInvalidNameWithgap() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> UserValidator.validateName("Ajai Kumar"));
		assertEquals("The user name is not valid  eg:JohnDoe", result.getMessage());
	}

	// For validate Password 
	@Test
	void testValidPassword() throws InvalidUserException {
		assertTrue(UserValidator.validatePassword("Password@123"));
	}

	@Test
	void testInvalidPasswordWithoutSpecialCharacters() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> UserValidator.validatePassword("Password123"));
		assertEquals("Invalid password eg:PassWord@123!", result.getMessage());
	}

	@Test
	void testInvalidPasswordWithoutNumbers() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> UserValidator.validatePassword("Password@"));
		assertEquals("Invalid password eg:PassWord@123!", result.getMessage());
	}

	@Test
	void testInvalidPasswordWithoutCapitalLetters() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> UserValidator.validatePassword("password123"));
		assertEquals("Invalid password eg:PassWord@123!", result.getMessage());

	}

	@Test
	void testInvalidPasswordWithoutSmallLetters() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> UserValidator.validatePassword("PASSWORD@123"));
		assertEquals("Invalid password eg:PassWord@123!", result.getMessage());

	}

	@Test
	void testInvalidPasswordShorterLength() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> UserValidator.validatePassword("Pa@12"));
		assertEquals("Invalid password eg:PassWord@123!", result.getMessage());
	}

	// For validate Phone Number
	@Test
	void testValidPhoneNumber() throws InvalidUserException {
		assertTrue(UserValidator.validatePhoneNumber(9876543216L));
	}

	@Test
	void testInvalidPhoneNumberLessThanTenDigits() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> UserValidator.validatePhoneNumber(987654321L));
		assertEquals("Invalid Phone Number eg:9876543210", result.getMessage());
	}

	// For validate Email
	@Test
	void testValidEmail() throws InvalidUserException {
		assertTrue(UserValidator.validateEmail("ajai@gmail.com"));
	}

	@Test
	void testInvalidEmailWithOutAtAndDot() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> UserValidator.validateEmail("ajaigmailcom"));
		assertEquals("Invalid email eg:johndoe@gmail.com", result.getMessage());
	}

	

	// For validate Pincode
	@Test
	void testValidPincode() throws InvalidUserException {
		assertTrue(UserValidator.validatePincode(654321));
	}

	@Test
	void testInvalidPincodeDigitLessThanSix() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> UserValidator.validatePincode(54321));
		assertEquals("Enter valid pincode only six digits and numbers", result.getMessage());
	}

}
