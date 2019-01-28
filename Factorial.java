package hw1.q4;

public class Factorial {
public int nFactorial(int n) {
	int num=1;
	for(int i=1;i<=n;i++) {
		 num=num*i;
	}
	return num;
}
}
