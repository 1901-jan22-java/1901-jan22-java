package com.revature.codingchallenges;

public class IntToHex {
	
	public static void main (String [] args) {

					//String with decimal value
					String string = "10"; 
							// variable to hold parsed string to int 
							int no = Integer.parseInt(string);
							//string to hold value for new hexadecimal number 
							String Hex = Integer.toHexString(no);
							//print statement 
							System.out.println("Hex value is " + Hex);
							
	}

}
