import java.util.Scanner;  

public class evenCheck {


public void divisibleByTwo () {

Scanner keyboard = new Scanner(System.in); 

int n; 
System.out.println("Hello Enter a number and i'll tell you if its even! "); 
n = keyboard.nextInt(); 
int x; 
x = n; 
n = n/2; 

if (n*2 != x  ){

System.out.println (x + " is Not an Even Number"); }

else 

System.out.println(x + " is Even Number"); 


}


public static void main (String [] args ){

//System.out.print(3/2); 
evenCheck maw = new evenCheck(); 

maw.divisibleByTwo(); 
// maw.divisibleByTwo(10); 



}



}