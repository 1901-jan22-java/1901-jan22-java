package question_25;

public class Integer_to_Roman {
	
	static final int[] num = {1000,900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	static final String[] symbol = {"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	
	
	static StringBuilder conversion(int n) {
		StringBuilder str = new StringBuilder("");
		if(n == 0) return str;
		for(int i=0; i<num.length; i++) {
			if(n>=num[i]) {
				str.append(symbol[i]);
				n-=num[i];
				break;
			}
		}
		return str.append(conversion(n));
	}
	
	public static void main(String[] args) {
		int n = 1024;
		System.out.println(conversion(n).toString());
	}
	
}
