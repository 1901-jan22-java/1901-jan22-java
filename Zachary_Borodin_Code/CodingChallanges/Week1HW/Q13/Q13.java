package com.revature.hw1.Q13;
//display the triangle
public class Q13 {
public static void main(String[] args) {
	int zero = 0;// will be printed when b is false
	int one = 1; // will be printed when b is true
	
	//boolean variable that will be used to determine what will be printed
	//in each position in the row and will change value every time something is printed
	boolean b = false;
	for(int i=0;i<4; i++) {
		for(int j=0; j<i+1;j++) {
			if(b==false) {
				System.out.print(zero + " ");
				//current output was 0
				//change b so next output will be 1
				b = true;
			}
			else {
				System.out.print(one + " ");
				//current output was 1
				//change b so next output will be 0
				b=false;

			}
			
		}
		System.out.println();
		
	}
}
}
