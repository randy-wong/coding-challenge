package com.coveros.exercise.creditcard;

public class CreditCard {

	private static String string;

	// Default Constructor
	public CreditCard() {}

	// Constructor
	public CreditCard(String string) {
		CreditCard.string = string.replaceAll("-", "").replaceAll(" ", ""); 
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

	public CreditCardType getCardType() {
//		String[] digits = string.split("\\D");
		String[] digits = string.split("");
		
	    for(int i=0;i<digits.length;i++)
	        System.out.println(i + " " + digits[i]);
		
		if(digits[0].equals("4") && (digits.length == 13 || digits.length == 16)) {
			System.out.println("VISA TEST 1");
			return CreditCardType.VISA;
		}
		
		else if(digits[0].equals("5") && (digits[1].equals("0") && digits.length == 16)) {
			System.out.println("MASTERCARD TEST 1");
			return CreditCardType.MASTERCARD;
		}

		else if(digits[0].equals("5") && (digits[1].equals("1") && digits.length == 16)) {
			System.out.println("MASTERCARD TEST 2");
			return CreditCardType.MASTERCARD;
		}
		
		else if(digits[0].equals("5") && (digits[1].equals("2") && digits.length == 16)) {
			System.out.println("MASTERCARD TEST 3");
			return CreditCardType.MASTERCARD;
		}
		
		else if(digits[0].equals("5") && (digits[1].equals("3") && digits.length == 16)) {
			System.out.println("MASTERCARD TEST 4");
			return CreditCardType.MASTERCARD;
		}
		
		else if(digits[0].equals("5") && (digits[1].equals("4") && digits.length == 16)) {
			System.out.println("MASTERCARD TEST 5");
			return CreditCardType.MASTERCARD;
		}
		
		else if(digits[0].equals("5") && (digits[1].equals("5") && digits.length == 16)) {
			System.out.println("MASTERCARD TEST 6");
			return CreditCardType.MASTERCARD;
		}

		else if(digits[0].equals("3") && (digits[1].equals("4") && (digits.length == 15))) {
			System.out.println("AMERICAN_EXPRESS TEST 1");
			return CreditCardType.AMERICAN_EXPRESS;
		}

		else if(digits[0].equals("3") && (digits[1].equals("7") && (digits.length == 15))) {
			System.out.println("AMERICAN_EXPRESS TEST 2");
			return CreditCardType.AMERICAN_EXPRESS;
		}
		
		else if(digits[0].equals("6") && (digits[1].equals("0") && (digits[2].equals("1") && (digits[3].equals("1") && (digits.length == 16))))) {
			System.out.println("DISCOVER_CARD TEST 1");
			return CreditCardType.DISCOVER_CARD;
		}
		
		else if(digits[0].equals("6") && (digits[1].equals("5") && (digits.length == 16))) {
			System.out.println("DISCOVER_CARD TEST 2");
			return CreditCardType.DISCOVER_CARD;
		}
		
		else if(digits.length > 11 && digits.length < 20) {
			System.out.println("UNKNOWN TEST1");
			return CreditCardType.UNKNOWN; 
		}

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