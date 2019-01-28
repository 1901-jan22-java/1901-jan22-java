package question_21;

public class Death_to_Duplicate_Chars {

	static String noDuplicateString(String str) {
		boolean[] chars = new boolean[256];
		StringBuilder newStr = new StringBuilder("");
		for(char c : str.toCharArray()) {
			if(chars[c]) continue;
			else {
				chars[c] = true;
				newStr.append(c);
			}
		}
		return newStr.toString();
	}
	
	public static void main(String[] args) {
		String str = "Running out of jokes yet?";
		System.out.println(noDuplicateString(str));
	}
	
}
