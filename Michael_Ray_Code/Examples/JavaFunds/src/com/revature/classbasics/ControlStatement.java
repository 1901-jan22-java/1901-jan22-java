package com.revature.classbasics;

public class ControlStatement {
public static void main(String[] args) {
	
	System.out.println(intToHex(16));
	
	System.out.println(isAnagram("pie","ipe"));
	
}
public static boolean isAnagram(String a, String b){

	if(a.length() == b.length()){
		int length = a.length();

		for(int i = 0; i < length; i++)
		{
			boolean hit = false;
			for(int j = 0; j < length; j++)
			{
				if(a.charAt(i) == b.charAt(j)){
					hit = true;
					break;					
				}
			}	
			if(!hit){
				return false;
			}
		}
	}
	else{
		return false;
	}
	return true;
}

public static String intToHex(int num)
{
	int divide = num;
	int mod = 0;
	String returnString = "";
	do{
		mod = divide % 16;
		divide /= 16;


			switch(mod)
			{
			case 10:
				returnString = "" + returnString + "A";
			case 11:
				returnString = "" + returnString + "B";
			case 12:
				returnString = "" + returnString + "C";
			case 13:
				returnString = "" + returnString + "D";
			case 14:
				returnString = "" + returnString + "E";
			case 15:
				returnString = "" + returnString + "F";
				default:
					returnString = "" + returnString + mod;
			}

	}while(divide > 0);
	
	return returnString;
}
}
