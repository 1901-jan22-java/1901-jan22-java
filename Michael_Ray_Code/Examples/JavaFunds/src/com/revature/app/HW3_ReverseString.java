package com.revature.app;

import java.util.Stack;

public class HW3_ReverseString {
public static void main(String[] args) {
	
	String line = ReverseString2("pizza");
	System.out.println(line);
	
}
 static Stack<String> reverseStack;
 
 static{
	 reverseStack = new Stack<String>();
 }
 
 static String ReverseString1(String myString){
	 
	 String reverse = "";
	 
	 for(int i = 0; i < myString.length(); i++){
		 reverseStack.push("" + myString.charAt(i));
	 }
	 
	 while(!reverseStack.isEmpty()){
		 reverse += reverseStack.pop();
	 }
	 
	 return reverse;	 
 }
 static String ReverseString2(String myString){
	 
	 for(int i = myString.length() -1; i >= 0; i--){
		 myString += myString.charAt(i);
	 }
	 
	 return myString.substring(myString.length()/2, myString.length());	 
 }
}
