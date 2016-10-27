package com.coveros.exercise.creditcard;

public class CreditCard {

	private static String string;

	// Default Constructor
	public CreditCard() {}

	// Constructor
	public CreditCard(String string) {CreditCard.string = string; }

	public static int calculateCheckDigit(String string) {return 0;}

	public static CreditCardType getCardType() {
		String[] digits = string.split("\\D");
		
		if(digits[0].equals('4') && (digits.length == 13 || digits.length == 16)) {
			return CreditCardType.VISA;
		}
		
		else if(digits[0].equals('5') && (digits[1].equals('0') && digits.length == 16)) {
			return CreditCardType.MASTERCARD;
		}

		else if(digits[0].equals('5') && (digits[1].equals('1') && digits.length == 16)) {
			return CreditCardType.MASTERCARD;
		}
		
		else if(digits[0].equals('5') && (digits[1].equals('2') && digits.length == 16)) {
			return CreditCardType.MASTERCARD;
		}
		
		else if(digits[0].equals('5') && (digits[1].equals('3') && digits.length == 16)) {
			return CreditCardType.MASTERCARD;
		}
		
		else if(digits[0].equals('5') && (digits[1].equals('4') && digits.length == 16)) {
			return CreditCardType.MASTERCARD;
		}
		
		else if(digits[0].equals('5') && (digits[1].equals('5') && digits.length == 16)) {
			return CreditCardType.MASTERCARD;
		}

		else if(digits[0].equals('3') && (digits[1].equals('4') && (digits.length == 15)))) {
			return CreditCardType.AMERICAN_EXPRESS;
		}

		else if(digits[0].equals('3') && (digits[1].equals('7') && (digits.length == 15)))) {
			return CreditCardType.AMERICAN_EXPRESS;
		}
		
		else if(digits[0].equals('6') && (digits[1].equals('0') && (digits[2].equals('1') && (digits[3].equals('1') && (digits.length == 15))))) {
			return CreditCardType.DISCOVER_CARD;
		}
		
		else if(digits[0].equals('6') && (digits[1].equals('5') && (digits.length == 15))) {
			return CreditCardType.DISCOVER_CARD;
		}
		
		else if(digits.length > 11 && digits.length < 20) {return CreditCardType.UNKNOWN; } 
		
		else {return null; }
//		else if(digits[0].equals('5') && (digits[1].equals('0') || (digits[1].equals('1') 
//				|| (digits[1].equals('2') || (digits[1].equals('3') || (digits[1].equals('4') 
//						|| (digits[1].equals('5') && digits.length == 16))))))) {
//			return CreditCardType.MASTERCARD;
//		}
//		
//		else if(digits[0].equals('3') && (digits[1].equals('4') || (digits[1].equals('7') && (digits.length == 15)))) {
//			return CreditCardType.AMERICAN_EXPRESS;
//		}
//		else if(digits[0].equals('6') && (digits[1].equals('0') && (digits[2].equals('1') && (digits[3].equals('1') 
//				|| ((digits[0].equals('6') && (digits[1].equals('5')) && (digits.length == 15))))))) {
//			return CreditCardType.DISCOVER_CARD;
//		}
		
				
	}

	public static void main(String[] args) {

	}


}