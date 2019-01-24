package question_13;

import java.util.ArrayList;

public class Triangle {

	static void printTriangle(int n) {
		ArrayList<Integer> row = new ArrayList<>();
		for(int i=0; i<n; i++) {
			row.add( 0 , i%2 );
			for(int num : row) {
				System.out.print(num);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		printTriangle(10);
	}
	
}
