package question_09;

public class HundredPrimes {
	
	static boolean isPrime(int n) {
		if(n <= 2) return false;
		int x = 2;
		// If the square of i is greater than n, I think we can stop
		// As there's no way values greater than i could be a factor of i
		while( x*x <= n) {
			if(n % x == 0) return false;
			x++;
		}
		return true;
	}

	public static void main(String[] args) {
		for(int i=0; i<100; i++)
			if( isPrime(i) ) System.out.println(i);
	}
}
