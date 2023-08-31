package com.fssa.rishi.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.validation.exceptions.InvalidUserException;

class TestValidateSeller {
	// For validate Name
	@Test
	void testValidName() throws InvalidUserException {
		assertTrue(SellerValidator.validateName("Ajaikumar"));
	}

	@Test
	void testInvalidNameWithSpecialCharacters() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> SellerValidator.validateName("Ajaikumar@!"));
		assertEquals("The user name is not valid  eg:JohnDoe", result.getMessage());
	}

//	@Test
//	void testInvalidNameWithNumbers() throws InvalidUserException {
//		InvalidUserException result = assertThrows(InvalidUserException.class,
//				() -> SellerValidator.validateName("Ajaikumar123"));
//		assertEquals("The user name is not valid  eg:JohnDoe", result.getMessage());
//	}

//	@Test
//	void testInvalidNameWithoutCapitalLetters() throws InvalidUserException {
//		InvalidUserException result = assertThrows(InvalidUserException.class,
//				() -> SellerValidator.validateName("ajaikumar"));
//		assertEquals("Name should contain Capital Letters", result.getMessage());
//	}

//	@Test
//	void testInvalidNameWithoutSmallLetters() throws InvalidUserException {
//		InvalidUserException result = assertThrows(InvalidUserException.class,
//				() -> SellerValidator.validateName("AJAIKUMAR"));
//		assertEquals("Name should contain Small letters", result.getMessage());
//	}

	@Test
	void testInvalidNameWithgap() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> SellerValidator.validateName("Ajai Kumar"));
		assertEquals("The user name is not valid  eg:JohnDoe", result.getMessage());
	}

	// For validate Password
	@Test
	void testValidPassword() throws InvalidUserException {
		assertTrue(SellerValidator.validatePassword("Password@123"));
	}

	@Test
	void testInvalidPasswordWithoutSpecialCharacters() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> SellerValidator.validatePassword("Password123"));
		assertEquals("Invalid password eg:PassWord@123!", result.getMessage());
	}

	@Test
	void testInvalidPasswordWithoutNumbers() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> SellerValidator.validatePassword("Password@"));
		assertEquals("Invalid password eg:PassWord@123!", result.getMessage());
	}

	@Test
	void testInvalidPasswordWithoutCapitalLetters() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> SellerValidator.validatePassword("password123"));
		assertEquals("Invalid password eg:PassWord@123!", result.getMessage());

	}

	@Test
	void testInvalidPasswordWithoutSmallLetters() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> SellerValidator.validatePassword("PASSWORD@123"));
		assertEquals("Invalid password eg:PassWord@123!", result.getMessage());

	}

	@Test
	void testInvalidPasswordShorterLength() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> SellerValidator.validatePassword("Pa@12"));
		assertEquals("Invalid password eg:PassWord@123!", result.getMessage());
	}

	// For validate Phone Number
	@Test
	void testValidPhoneNumber() throws InvalidUserException {
		assertTrue(UserValidator.validatePhoneNumber(8876543216L));
	}

	@Test
	void testInvalidPhoneNumberLessThanTenDigits() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> SellerValidator.validatePhoneNumber(987654321L));
		assertEquals("Invalid Phone Number eg:9876543210", result.getMessage());
	}

	// For validate Email
	@Test
	void testValidEmail() throws InvalidUserException {
		assertTrue(SellerValidator.validateEmail("ajai@gmail.com"));
	}

	@Test
	void testInvalidEmailWithOutAtAndDot() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> SellerValidator.validateEmail("ajaigmailcom"));
		assertEquals("Invalid email eg:johndoe@gmail.com", result.getMessage());
	}

	// For validate Pincode
	@Test
	void testValidPincode() throws InvalidUserException {
		assertTrue(SellerValidator.validatePincode(654321));
	}

	@Test
	void testInvalidPincodeDigitLessThanSix() throws InvalidUserException {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> SellerValidator.validatePincode(54321));
		assertEquals("Enter valid pincode only six digits and numbers", result.getMessage());
	}

}
