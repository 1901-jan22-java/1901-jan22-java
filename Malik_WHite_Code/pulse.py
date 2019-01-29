
import java.util.ArrayList;
import java.util.Arrays;

public class inClassChallenge{




public static void main (String [] args){



 int [ ] numbers  = {2, 4, 6, 8};

targetCheck(numbers, 7);



}

static void targetCheck (int [] x, int n){

boolean checker = false;

int temp2;

ArrayList <Integer> temp = new ArrayList <Integer> ();
for (int i = 0; i < x.length; i++){

temp2 = x[i];
temp.add(temp2);


}

for (int i = 0; i < x.length; i++){

for (int j = 0; j < x.length; j++){

if (x[i] + temp.get(j) == n){
checker = true;
}

}


}


System.out.println(checker);







}





}



