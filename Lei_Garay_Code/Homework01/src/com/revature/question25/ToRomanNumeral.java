package com.revature.question25;

public class ToRomanNumeral {

	//The Roman numeral Sys can be thought of as the the decimal system split in 2
	  // with the added peculiarity of the pattern breaking numbers 4 and 9 
	  //in their corresponding numerical units, tens, hundreds 
	  //(i.e. IV(4), IX(9), XL(40), XC(90) ...)
	  //thus the RN Sys can be organized in 2 groups
	  // group 0                       group 1
	  // 0 = nothing or RN[0]          5 = V or RN[2]  <-- in RN array
	  // 1 = nothing + 1 I or RN[1]    6 = V + 1 I
	  // 2 = nothing + 2 I's           7 = V + 2 I's
	  // 3 = nothing + 3 I's           8 = V + 3 I's
	  // 4 = 1 I + next Numeral (V)    9 = 1 I + next Numeral (X) 
	  //         
	  //             or RN[2]                or RN[3]  <-- in RN array
	

	static String NumToRoman(int input){
		String [] RN = 
			{"","I","V","X","L","C","D","M","[V]","[X]","[L]","[C]","[D]","[M]"};
		String inputString = String.valueOf(input);
		String out = "";
		
		for(int i=inputString.length()-1;i>=0;i--) //iterate from L to R to get units
			  // then tens then hundreds and so on
			  {
			    int group = 0; //establishes group 0 as default (if num is less than 5)
			    int n = i+1;
			    int column = (inputString.length()-1-i)*2+1;//determines default position of 
			    // numerical order and maps it onto the RN array
			    String output  = ""; // final string container
			    
			    if(Integer.parseInt(String.valueOf(inputString.charAt(i)))>4)
			      { 
			        group++; //add 1 to group value if number goes over 4
			        n = (Integer.parseInt(String.valueOf(inputString.charAt(i)))-5); //sets the new number based on group
			      }
			    // n is the number that will detetermine how the new Roman numeral will be formed
			    if(n==4 ) //handles peculiarities 4 & 9(or 4 in group 1 <-> 9-5=4)
			      { 
			        output = RN[column]+RN[column+1+group];
			      }
			    else // handles the rest
			      {
			        if(group==1)
			        {output = RN[column+group];}//adjusts based on group
			        String holder = "";
			        for(int j=0;j<n;j++){holder+=RN[column];}
			        output = output+holder;
			      }
			    out = output + out; //concatenates to the right
			  } 
			  return out;
			}

	public static void main(String[] args) {
		System.out.println(NumToRoman(1234567));
	}
}