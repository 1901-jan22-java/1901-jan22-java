package com.revature.app;

public class HW5_SubString {
public static void main(String[] args) {
	String word = "Pizzzzzzaaa";
	System.out.println(word);
	
	word = SubString(word, 5);
	System.out.println(word);
}

public static String SubString(String mainString, int index){
	String subString = "";
	
	if(index <= 0){
		return subString;
	}
	else if(index >= mainString.length()){
		return mainString;
	}
	
	for(int i = 0; i < index; i++){
		subString += "" + mainString.charAt(i);
	}
	
	return subString;
	
}
}
