
  //Write a program to compute N factorial.
 
  public class factorial {
 
 
  public static void main (String [] args){
 
 
  computeN(10);

 }


 static void computeN (int n){

 int max = n;
 int product = 1;
 int [] x = new int [max];

 for (int i = 0; i < max; i++){
 x[i] = n - i;
 }

 // for(int i = 0; i < max; i++){
 // System.out.print(x[i]);}
 //
 // }

 for (int i =0; i < max; i++){

  product *= x[i] ;

 }

 System.out.print(n + "! = " + product);

 }}
 



