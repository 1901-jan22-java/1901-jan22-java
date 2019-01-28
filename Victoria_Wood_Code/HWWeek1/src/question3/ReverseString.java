package question3;

public class ReverseString {
	
	public static void main(String[] args) { 
		System.out.println(reverse("cat")); //test reverse with two strings
		System.out.println(reverse("hello world"));
		
	}
	
	public static String reverse(String s) { 
		for(int i = 0; i < s.length(); i++) { //with each loop, string is re-ordered, reference variable s is reassigned to new reordered string
			s = s.substring(1, s.length()-i) // puts non-reversed part of string at beginning, excluding first character
			+ s.substring(0,1)//places first character at end of string
			+ s.substring(s.length()-i, s.length()); // adds what has already been reversed on to end of string
	}
		//essentially shifting string, taking the first character and placing it on the end with each iteration
		
		return s;
	}

}
