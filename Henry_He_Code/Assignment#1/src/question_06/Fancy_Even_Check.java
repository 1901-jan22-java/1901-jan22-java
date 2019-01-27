package question_06;

public class Fancy_Even_Check {

	
	// This isEven method actually checks for powers of two...
//	static boolean isEven(int n) {
//		return (n & n-1) == 0;
//	}
	
	static boolean isEven(int n) {
		// Had an interesting discussion with Malik where he checked if
		// n/2 * 2 == n <- exploits the property of even numbers
//		return ( (n/2)*2 == n);
		
		//I had a different idea (see below)
		String binary = Integer.toBinaryString(n);
		System.out.println(binary.charAt(binary.length()-1));
		return binary.charAt(binary.length()-1) == '0';
		
		// Should be able to just do this:
		// return Integer.lowestOneBit(n) == 0;
		// For some reason, it's not working as intended.
		
	}
	
	static public void main(String args[]) {
		System.out.println(isEven(32));
		System.out.print(isEven(31));
	}
}
