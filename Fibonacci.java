package hw1.q2;

public class Fibonacci {

	public void printFib() {
		int fib1=0; int fib2=1;
		
		for(int i=0;i<=25;i++) {
			System.out.print(""+fib2);
			int nextNum= fib1+fib2;
			fib1=fib2;
			fib2=nextNum;
		}
	}
}
