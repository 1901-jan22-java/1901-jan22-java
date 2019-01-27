
/** Write a program that stores the following strings in an ArrayList and saves all the
palindromes in another ArrayList.
"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy",
"did" **/

import java.util.ArrayList;
public class palindSave {

public static void main (String [] args){

ArrayList <String> arr = new ArrayList <String> ();

//System.out.print(palinCheck("dam"));

arr.add("karan");
arr.add("madam");
arr.add("tom");
arr.add("civic");
arr.add("radar");
arr.add("sexes");
arr.add("jimmy");
arr.add("kayak");
arr.add("john");
arr.add("refer");
arr.add("billy"); 
arr.add("did"); 

scan(arr);

}


static void scan ( ArrayList <String> x  ){

ArrayList <String> palinArray = new ArrayList <String> ();

for(int i = 0; i < x.size(); i++){

//palinCheck(x.get(i));

if (palinCheck(x.get(i)) == true){

palinArray.add(x.get(i));


}


}

if (palinArray.size() == 0){

   System.out.print("None of These words are palindromes");
}

else {
   System.out.print("The palindromes are ");
   for(int i = 0; i < palinArray.size(); i++){
   System.out.print(palinArray.get(i) + " ");
   }


}

}

static boolean palinCheck (String s){

ArrayList <Character> reverse = new ArrayList <Character> ();
String reversedString = "";

for(int i = 0; i < s.length(); i++){

reverse.add(s.charAt(i));}

for(int i = s.length() -1; i > -1; i--){

reversedString += reverse.get(i);


}

//System.out.println(reversedString);

if (reversedString.equals(s)){

return true;

}

else

return false;

}



}




