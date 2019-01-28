package question15;

public class TestOperators {
	
	public static void main(String[] args) {
		
		Operators o = new Operators();
		if(4+5 == o.add(4, 5)) {
			System.out.println("Addition works");
		}
		if (12-7 == o.subtract(12, 7)) {
			System.out.println("Subtraction works");
		}
		if (5*9 == o.multiply(5, 9)) {
			System.out.println("Multiplication works");
		}
		if (20/9 == o.divide(20, 9)) {
			System.out.println("Division works");
		}
	}

}
