package question_06;

public class Fancy_Even_Check {

	/* It's fortunate that I've encountered this problem before...
	 * Hint: 32 = 10000
	 *       31 = 01111
	 */
	static boolean isEven(int n) {
		return (n & n-1) == 0;
	}
	
	static public void main(String args[]) {
		System.out.println(isEven(32));
		System.out.print(isEven(31));
	}
}
