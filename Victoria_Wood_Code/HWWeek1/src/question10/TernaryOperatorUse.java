package question10;

public class TernaryOperatorUse {
	
	public static void main(String[] args) {
		System.out.println("The minimum of 3 and 1 is: " + findMin(3,1));
		System.out.println("The minimum of 4000 and 4 is: " +findMin(4000, 4));
		System.out.println("The minimum of 2 and 2 is: " + findMin(2, 2));
		
	}
	
	public static int findMin(int a, int b) {
		return a < b ? a : b;
	}

}
