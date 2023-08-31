package com.fssa.rishi.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.validation.exceptions.InvalidUserException;

class TestValidatePassword {

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

}
