
public class reverseString {


   //. Reverse a string without using a temporary variable. Do NOT use reverse() in the
   
   static String product = " ";
   
   public static void main (String [ ]args){
   
   String tester = "Backwards"; 
   
   StringReverse(tester); 
   
   
   }
   
   static void StringReverse(String x) {
   
   char  [] stack = new char [x.length()]; 
   
   for (int i = 0; i < x.length(); i ++){
   
   stack[i] = x.charAt(i); 
   
   }
   
   for(int i = x.length() -1 ; i >-1; i --){
   
    
   product += stack[i]; 
   //System.out.println(stack[i]+ " "); 
   }
   
   
         System.out.print("Your original String was " + x + " and now your reversed one is " + product); 

   }





}



