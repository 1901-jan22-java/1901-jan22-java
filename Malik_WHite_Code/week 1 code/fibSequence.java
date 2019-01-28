
public class fibSequence {



public static void main (String [ ] args ) {


calc();

}


static void calc (){

int zero = 0;
int one = 1;
int fibNum = 0;

System.out.print(one + " ");

for(int i = 0; i < 25; i++){


fibNum = zero + one;
zero = one;
one = fibNum; 
System.out.print(fibNum + " ");


}


}






}



