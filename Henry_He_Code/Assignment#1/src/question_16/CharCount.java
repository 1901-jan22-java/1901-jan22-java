package question_16;

public class CharCount {

	public static void main(String[] args) {
		
		String str = args[0];
		System.out.println(str);
		int[] chars = new int[256];
		for(char c : str.toCharArray())
			chars[c]++;
		for(int i=0; i<256; i++) 
			System.out.println( (char)i + ":" + chars[i] + "," );
		
	}
	
}
