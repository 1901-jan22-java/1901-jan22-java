package Question15;

public class MyClass_Test {

	public static void main(String[] args) {
		MyClass_Interface q=new MyClass_Interface();
		//passing in my values
		System.out.println("Addition of 4 and 2 is : "+q.addition(4, 2));  //calls my addition method
		System.out.println("Subtraction of 2 from 4 is : "+q.subtraction(4, 2)); // calls my subtraction method
		System.out.println("Multiplication of 4 and 2 is : "+q.multiplication(4, 2)); // calls my multiplication method
		System.out.println("Division of 4 by 2 is : "+q.division(4, 2)); // division method is called
		

	}

}
