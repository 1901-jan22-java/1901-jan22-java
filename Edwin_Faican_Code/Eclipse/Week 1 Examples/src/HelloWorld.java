//package com.revature.hello Package lines come first

//import java.util.List  Imports come second

//Class declaration comes next
public class HelloWorld {
  // This is a single line comment

  /*This is another form of comment where
  blocks of text are commented within slashes.*/

  public static void main(String[] args) {
    System.out.println("Hello World!");
    if(args.length == 1) {
      System.out.println("You passed in 1 parameter.");
    } else if(args.length != 0){
      System.out.println("You passed in " + args.length + " parameters.");
    } else {
      System.out.println("You didn't pass in any variables!");
    }

    
    A lambda = (a,b) -> a +b
  }
}

interface A {
	int hello(int a, int b);
}