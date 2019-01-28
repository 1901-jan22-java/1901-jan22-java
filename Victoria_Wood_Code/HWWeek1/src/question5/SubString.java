package question5;

public class SubString {
	
	public static void main(String[] args) {
		System.out.println(subString("hello", 2)); //test subString method 
		System.out.println(subString("victoria", 5));
	}

	public static String subString(String str, int idx) {
		String sub = ""; //new string to store substring in
		for(int i = 0; i < idx; i++) {
			sub += str.charAt(i); //adds each char to sub up until idx-1 inclusive
		}
		return sub;
	}
}
