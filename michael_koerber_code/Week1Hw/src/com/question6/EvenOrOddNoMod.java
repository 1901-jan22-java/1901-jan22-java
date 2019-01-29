package com.question6;

public class EvenOrOddNoMod {

	public static void main(String[] args) {
		bitwiseCheck(406);
	}
	 static void bitwiseCheck(int n){           
	     // 1 in binary is 0001, odd
		 // If the binary number passed ends in 1, it will return 1 because 1 is on both sides of the operator, therefore odd
		 // If the number passed ends in a 0, the and operator will return 0 on one side making the operator return true, indicating an even number
	     if((n & 1) == 0){
	    	 System.out.print("Even");
	     } else {
	    	 System.out.print("Odd");
	     }
	 } 
}
