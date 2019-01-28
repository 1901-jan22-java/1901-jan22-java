package Question10;

public class FindSmallest {

	public static void main(String[] args) {
		 // variable declaration  
	    int n1 = 5, n2 = 10, min;  
	      
	    // Smallest among n1 and n2  using tenary operator to check if condition is true or not
	    min = (n1 < n2) ? n1 : n2;  
	      
	    // Print the Smallest number  
	    System.out.println("Smallest number between " + n1 +  
	                  " and " + n2 + " is " + min + ". " );  
	}

}
