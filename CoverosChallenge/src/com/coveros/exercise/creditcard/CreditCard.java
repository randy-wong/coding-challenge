// By Randy Wong
// For Coveros
package com.coveros.exercise.creditcard;

public class CreditCard {
	
	// String for card digits
	private static String string;
	// CreditCardType for the type of credit card
	private static CreditCardType type;

	// Default Constructor
	public CreditCard() {}

	// Constructor that takes in the digits as strings, validates with Luhn Algorithm and sets card type
	public CreditCard(String string) throws InvalidCardNumberException {
		// Gets rid of all the extra typing, possible to use stronger string rules
		CreditCard.string = string.replaceAll("-", "").replaceAll(" ", "");
		// Throw error if Luhn Algorithm is incorrect
		if (CreditCard.calculateCheckDigit(CreditCard.string) == 0) { throw new BadCheckDigitException( CreditCard.string + ": is an invalid digit sequence"); }
		getCardType();
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
		// Convert digit string to an array because it is easier to write with array methods
		String[] digits = string.split("");
		
		// If first number is a 4, then it is considered a VISA
		if (digits[0].equals("4")) {
			// Set card to VISA
			if (digits.length == 13 || digits.length == 16) {
				type = CreditCardType.VISA;
				return CreditCard.type;
			}
			else {
				// Throw error if card type is invalid
				throw new InvalidCardLengthException(type + " card must be 13 or 16 digits long ");
			}
		}
		
		// Similar check to VISA but for MASTERCARD
		else if (digits[0].equals("5")) {
			if (digits[1].equals("0") || digits[1].equals("1") || digits[1].equals("2") ||
					digits[1].equals("3") || digits[1].equals("4") || digits[1].equals("5")) {
				if (digits.length == 16 ) {	
					type = CreditCardType.MASTERCARD;
					return CreditCard.type;
				}
				else { throw new InvalidCardLengthException(type + " card must be 16 digits long");}
			}
		}

		else if (digits[0].equals("3")) {
			if(digits[1].equals("4") || digits[1].equals("7")) {
				if (digits.length == 15) {
					type = CreditCardType.AMERICAN_EXPRESS;
					return CreditCard.type;
				}
				else { 
					throw new InvalidCardLengthException(type + " card must be 15 digits long");
				}
			}
		}

		else if (digits[0].equals("6") && (digits[1].equals("0") && (digits[2].equals("1") && (digits[3].equals("1"))))) {
			if (digits.length == 16) { 
				type = CreditCardType.DISCOVER_CARD;
				return CreditCardType.DISCOVER_CARD;
			}
			else {
				throw new InvalidCardLengthException(type + " card must be 16 digits long");
			}
		}

		else if (digits[0].equals("6") && (digits[1].equals("5"))) {
			if (digits.length == 16) { 
				type = CreditCardType.DISCOVER_CARD;
				return type;
			}
			else {
				throw new InvalidCardLengthException(type + " card must be 16 digits long");
			}
		}

		else if(digits.length > 11 && digits.length < 20) {
			type = CreditCardType.UNKNOWN;
			return type; 
		}
		
		// Error
		throw new InvalidCardLengthException("Incorrect number of digits, Invalid Card");
	}

	public static void main(String[] args) throws InvalidCardNumberException {

	}


}