
/** Write a substring method that accepts a string str and an integer idx and returns the
substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing
substring methods in the String, StringBuilder, or StringBuffer APIs. **/ 

public class subStringTest {


public static void main (String [] args){

System.out.print(subString("Malik", 4));

}


static String subString (String str, int idx){

String sub = ""; 

for(int i = 0; i < idx-1; i ++){

sub += str.charAt(i); 

}


return  sub; 
} 


}



