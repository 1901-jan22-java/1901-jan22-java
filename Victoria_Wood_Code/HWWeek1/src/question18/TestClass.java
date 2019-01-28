package question18;

public class TestClass {
	
	public static void main(String[] args) {
		SubClass sc = new SubClass();
		
		System.out.println(sc.hasUpper("hello World"));
		System.out.println(sc.convertToUpper("hello world"));
		sc.toInt("hello world");
	}

}
