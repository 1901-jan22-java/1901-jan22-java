package question_19;

import java.util.ArrayList;
import java.util.List;

public class AL_Shenanigans {
	
	static boolean isPrime(int n) {
		if(n <= 2) return false;
		int x = 2;
		while( x*x <= n) {
			if(n % x == 0) return false;
			x++;
		}
		return true;
	}

	public static void main(String[] args) {
		List<Integer> alFunsies = new ArrayList<>();
		int evenSum = 0;
		int oddSum = 0;
		for(int i=1; i<11; i++) alFunsies.add(i);
		for(int i=0; i<alFunsies.size(); i++) {
			int element = alFunsies.get(i);
			if(element%2 == 0)
				evenSum+=element;
			else oddSum+=element;
			if(isPrime(element)) alFunsies.remove(i);
		}
		System.out.print("evenSum="+evenSum+" : "+"oddSum="+oddSum+" : "+alFunsies);
	}
	
}
