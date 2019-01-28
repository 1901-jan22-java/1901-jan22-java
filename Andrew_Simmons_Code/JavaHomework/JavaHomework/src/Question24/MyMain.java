package Question24;

import java.util.Scanner;
class MyMain
{
    public static void main(String args[])
    {
      Scanner input = new Scanner( System.in );
      System.out.print("Enter a decimal number that is base 10 : ");
      int num =input.nextInt();
        
      // calling method toHexString()
      //The Java.lang.Integer.toHexString() is a built-in function in Java which returns 
      //a string representation of the integer argument as an unsigned integer in base 16.
      String str = Integer.toHexString(num);
      System.out.println("Method 1: Decimal to hexadecimal: "+str);
    }
}