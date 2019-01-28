package com.revature.classbasics;

public class ControlStatements {
/*
 * Control statements affect the flow of your application.
 * This includes loops, ifs, whiles, switch, etc.
 * Outside of these code structures, it is important to know the keywords 
 * continue, break, and understand labels for blocks of code
 * */
	public static void main(String[] args) {
		//For loop
		for (int i = 0; i < args.length; i++)
		{
			System.out.println(args[i]);
		}
		
		//You don't need to put anything for loops
		int num = 1;
		for(; ;)//This is valid if there are bounds
		{
			num += 2;
			if(num == args.length) break;
		}
		
		//For each enhanced for loop
		for(String str: args)
		{
			System.out.println(str);
		}
		
		//While loop
		while(num > 1)
		{
			System.out.println("This works");
		}
		//Do while
		do
		{
			System.out.println("This executes once");
		} while(num > 1);
		
		//If statements
		if(num == 1)
		{
			System.out.println("num is 1");
		}
		else if(num == 5)
		{
			System.out.println("num is 5");
		}
		else//You always need an else statement in a if statement 
		{
			System.out.println("Wrong input");
		}
		
		//Switch statement
		//Switch can only be used for Strings, enums, and values that be cast to int
		//int, short, byte, char and their respective wrapper classes
		switch(num)
		{
		case 1:
			System.out.println("num is 1");
			break;
		case 5:
			System.out.println("num is 5");
			break;
		default:
			System.out.println("Wrong input");
			 break;
		}
		/*
		 * Break vs Continue
		 * break will exit the loop or the block of code
		 * continue will move on to the next iteration
		 * */
	}
}
