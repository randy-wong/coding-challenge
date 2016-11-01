// By Randy Wong
// For Coveros
package com.coveros.exercise.creditcard;

public class CreditCard {

	private static String string;
	private static CreditCardType type;

	// Default Constructor
	public CreditCard() {}

	// Constructor
	public CreditCard(String string) throws InvalidCardNumberException {
		CreditCard.string = string.replaceAll("-", "").replaceAll(" ", "");
		if (CreditCard.calculateCheckDigit(CreditCard.string) == 0) { throw new BadCheckDigitException( CreditCard.string + ": is an invalid digit sequence"); }
		getCardType();
//		// VISA Check
//		if (CreditCard.string.charAt(0) == '4') {
//			System.out.println(CreditCard.string.length());
//			if (CreditCard.string.length() != 13 && CreditCard.string.length() != 16) { 
//				throw new InvalidCardLengthException(""); }
//		}
//		
//		// MASTERCARD Check
//		if (CreditCard.subtring(0 , 1))
	}

	// Taken this method from online http://stackoverflow.com/questions/20740444/check-credit-card-validity-using-luhn-algorithm
	public static int calculateCheckDigit(String string) {
		string = string.replaceAll("-", "").replaceAll(" ", "");
		int sum = 0;
		boolean alternate = false;
		for (int i = string.length() - 1; i >= 0; i--)
		{
			int n = Integer.parseInt(string.substring(i, i + 1));
			if (alternate)
			{
				n *= 2;
				if (n > 9)
				{
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}
		if(sum % 10 == 0) { return 1; }
		else { return 0; }
	}

	public CreditCardType getCardType() throws InvalidCardNumberException {
//		String[] digits = string.split("\\D");
		String[] digits = string.split("");
		
		if (digits[0].equals("4")) {
			if (digits.length == 13 || digits.length == 16) {
				type = CreditCardType.VISA;
				return CreditCard.type;
			}
			else { throw new InvalidCardLengthException(type + " card must be 13 or 16 digits long ");}
		}
		
		else if (digits[0].equals("5")) {
			if (digits[1].equals("0") || digits[1].equals("1") || digits[1].equals("2") ||
					digits[1].equals("3") || digits[1].equals("4") || digits[1].equals("5")) {
				type = CreditCardType.MASTERCARD;
				if (digits.length == 16 ) {	
					return CreditCard.type;
				}
				else { throw new InvalidCardLengthException(type + " card must be 16 digits long");}
			}
		}
		
//		else if (digits[0].equals("5") && (digits[1].equals("0") && digits.length == 16)) {
//			System.out.println("MASTERCARD TEST 1");
//			return CreditCardType.MASTERCARD;
//		}
//
//		else if (digits[0].equals("5") && (digits[1].equals("1") && digits.length == 16)) {
//			System.out.println("MASTERCARD TEST 2");
//			return CreditCardType.MASTERCARD;
//		}
//		
//		else if (digits[0].equals("5") && (digits[1].equals("2") && digits.length == 16)) {
//			System.out.println("MASTERCARD TEST 3");
//			return CreditCardType.MASTERCARD;
//		}
//		
//		else if (digits[0].equals("5") && (digits[1].equals("3") && digits.length == 16)) {
//			System.out.println("MASTERCARD TEST 4");
//			return CreditCardType.MASTERCARD;
//		}
//		
//		else if (digits[0].equals("5") && (digits[1].equals("4") && digits.length == 16)) {
//			System.out.println("MASTERCARD TEST 5");
//			return CreditCardType.MASTERCARD;
//		}
//		
//		else if (digits[0].equals("5") && (digits[1].equals("5") && digits.length == 16)) {
//			System.out.println("MASTERCARD TEST 6");
//			return CreditCardType.MASTERCARD;
//		}
		
		else if (digits[0].equals("3")) {
			if(digits[1].equals("4") || digits[1].equals("7")) {
				type = CreditCardType.AMERICAN_EXPRESS;
				if (digits.length == 15) {
					return CreditCard.type;
				}
				else { 
					throw new InvalidCardLengthException(type + " card must be 15 digits long");
				}
			}
		}
//
//		else if (digits[0].equals("3") && (digits[1].equals("4") && (digits.length == 15))) {
//			System.out.println("AMERICAN_EXPRESS TEST 1");
//			return CreditCardType.AMERICAN_EXPRESS;
//		}
//
//		else if (digits[0].equals("3") && (digits[1].equals("7") && (digits.length == 15))) {
//			System.out.println("AMERICAN_EXPRESS TEST 2");
//			return CreditCardType.AMERICAN_EXPRESS;
//		}
		
		else if (digits[0].equals("6") && (digits[1].equals("0") && (digits[2].equals("1") && (digits[3].equals("1"))))) {
			type = CreditCardType.DISCOVER_CARD;
			if (digits.length == 16) { 
				return CreditCardType.DISCOVER_CARD;
			}
			else {
				throw new InvalidCardLengthException(type + " card must be 16 digits long");
			}
		}

		else if (digits[0].equals("6") && (digits[1].equals("5"))) {
			type = CreditCardType.DISCOVER_CARD;
			if (digits.length == 16) { 
				return type;
			}
			else {
				throw new InvalidCardLengthException(type + " card must be 16 digits long");
			}
		}
		
//		else if (digits[0].equals("6") && (digits[1].equals("5") && (digits.length == 16))) {
//			System.out.println("DISCOVER_CARD TEST 2");
//			return CreditCardType.DISCOVER_CARD;
//		}
		
		else if(digits.length > 11 && digits.length < 20) {
			type = CreditCardType.UNKNOWN;
			return type; 
		}

		throw new InvalidCardLengthException("Incorrect number of digits");
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

	public static void main(String[] args) throws InvalidCardNumberException {

	}


}