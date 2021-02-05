package com.coveros.exercise.creditcard;

import org.junit.Test;

public class InvalidCardNumberException extends Exception {
	
	public InvalidCardNumberException(String message) {
		super(message);
	}	
}

class BadCheckDigitException extends InvalidCardNumberException {

	public BadCheckDigitException(String message) {
		super(message); 
		// TODO Auto-generated constructor stub
	}
}

class InvalidCardLengthException extends InvalidCardNumberException{

	public InvalidCardLengthException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}