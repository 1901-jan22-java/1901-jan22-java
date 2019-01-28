package question_24;

public class Hexadecawhattamis {
	
	static String decimal_to_hexadecimal(int num) {
		StringBuilder str = new StringBuilder("");
		char[] hex = {'a','b','c','d','e','f'};
		while(num > 0){
			int remainder = num % 16;
			if(remainder>9){
				str.append(hex[remainder-10]);
			} else str.append(remainder);
			num /= 16;
		}
		return str.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(decimal_to_hexadecimal(817849812));
	}
	
}
