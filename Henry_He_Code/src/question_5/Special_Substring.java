package question_5;

import java.util.Arrays;

public class Special_Substring {

	static String substring(String str, int n) {
		if(str.length() < n) return null;
		char[] arr = str.toCharArray();
		return new String( Arrays.copyOf(arr,n) );
	}
	
	public static void main(String args[]) {
		String str = "Will this even work? It's rather contrived.";
		System.out.print( substring(str, 10) );
	}
	
}
