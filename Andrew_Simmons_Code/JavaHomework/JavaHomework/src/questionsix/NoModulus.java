package questionsix;

class NoModulus {

	// Returns true if n
	// is even, else odd
	static boolean isEven(int n) {
		boolean isEven = true;

		for (int i = 1; i <= n; i++) // variable assigned below
			System.out.println(i);
		isEven = !isEven;

		return isEven;
	}

	// main
	public static void main(String args[]) {

		int n = 11; // assigning a variable to check if it will be even or not
		if (isEven(n)) // isEven method is called passing the int variable 101 in
			System.out.println("Even");
		else
			System.out.println("Odd");

	}
}
