package com.coveros.exercise.creditcard;

import org.junit.Test;

public class InvalidCardNumberException extends Exception {
	
	@Test(expected = BadCheckDigitException.class)
	public InvalidCardNumberException() {
		
		
	}
	@Test(expected = BadCheckDigitException.class)
	private class BadCheckDigitException{}
	@Test(expected = BadCheckDigitException.class)
	private class InvalidCardLengthException{}
	
}
