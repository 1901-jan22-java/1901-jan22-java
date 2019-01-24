package question_10;

public class TernaryMin {

	static int min(int a, int b) {
		return (a<b) ? a : b;
	}
	
	public static void main(String[] args) {
		// Structure of Ternary: condition ? exprTrue : exprFalse
		System.out.println( min(99, 10) );
		System.out.print( min(65, 99) );
	}
}
