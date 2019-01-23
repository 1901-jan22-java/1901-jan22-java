package com.revature.codingchallenges;

public class IntToHex {
	
	public static void main (String [] args) {

//					//String with decimal value
//					String string = "10"; 
//							// variable to hold parsed string to int 
//							int no = Integer.parseInt(string);
//							//string to hold value for new hexadecimal number 
//							String Hex = Integer.toHexString(no);
//							//print statement 
//							System.out.println("Hex value is " + Hex);
		
		//anagrams maw = new anagrams(); 
		anagrams.AnaCheck("cat","tac"); 
							
	}
	
	static class anagrams{
		
		
		public static boolean AnaCheck (String A, String B) {
			
			if (  A.length() == B.length() ) {
				System.out.println("Firts Step passed");
				
				int goal = A.length ( ); 
				int goalCheck = 0; 
				
				for (int i = 0; i < A.length(); i++) {
					
					for (int j = 0; j < A.length(); j++) {
					if (A.charAt(i) == B.charAt(j)) {
						
						goalCheck++; 
						
					}}
					
				}
				if (goal == goalCheck) {
					
					System.out.println("Is an Anagram");
					return true; 
				}
			}
			
			else {
				System.out.println("Not an Anagram");
			}
			
			return false; 
		} 
		
	}

}
