package question4;

public class Factorial {
	
	public static void main(String[] args) {
		System.out.println(fac(1)); //testing fac method on factorials of 1,3,5
		System.out.println(fac(3));
		System.out.println(fac(5));
	}
	
	public static int fac(int n) {
		int x = 1;
		for (int i = 2; i <= n; i++) { // set variable x to 1 and i to 2 to begin factorial sequence
			x = x * i; //multiply previous number by next number in sequence, store again in x for next loop
		}
		return x;
	}

}
