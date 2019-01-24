package question_03;

public class StringReverse {

	/*
	 * Not particularly fond of this problem - but takes some thinking...
	 * You could just concatenate the reverse of the string character by character...
	 * thus, you don't make use of a new variable. Still, it's very inefficient.
	 */
	static String reverse(String str) {
		int mid = str.length();
		for(int i=mid-1; i>=0; i--) {
			str += str.charAt(i);
		}
		return str.substring(mid);
	}
	
	public static void main(String[] args) {
		System.out.print(reverse("The quick brown fox jumped over the lazy dog."));
	}
}
