package Question19;

import java.util.ArrayList;
import java.util.Arrays;


public class NumberList {

   static boolean isPrime(int n) {
       // only even prime
       if(n==2) {
           return true;
       } // if false we proceed
       int i, m = 0;

       m = n / 2;  //
       for (i = 2; i <= m; i++) {
           if (n % i == 0) {
               return false;
           }
       }
       return true;
   }

   public static void main(String args[]) {
       ArrayList<Integer> list = new ArrayList<>(); //create an arraylist with the generic type integer 
       for (int i = 1; i <= 10; i++)
           list.add(i); //populate it with intergers 1 to 10

       int sumEven = 0, sumOdd = 0;
       for (int n : list) {
           if (n % 2 == 0) // use the % to check if the number is even or not
               sumEven += n;
           else
               sumOdd += n;
       }
       //displays 1 to 10
       System.out.println("List: " + Arrays.toString(list.toArray())); 
       //sumEven displays the added sum
       System.out.println("Even number sum: " + sumEven);
       //display sumOdd
       System.out.println("Odd number sum: " + sumOdd);
      
       
       System.out.println("\nRemoving prime number: ");
       
       //our prime numbers should be 2, 3, 5, 7
       
       for(int i=1; i<=10; i++) {
           if(isPrime(i)) {  
        	   //calls this method to check if this is an prime number or not
               list.remove(new Integer(i));
               //If it is true the int gets remove from the arraylist
           }
       }

       System.out.println("List: " + Arrays.toString(list.toArray()));
      

   }
}

