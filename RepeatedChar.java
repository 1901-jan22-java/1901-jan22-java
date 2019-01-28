package hw1.q21;

import java.util.ArrayList;
import java.util.List;

public class RepeatedChar {
 public String removeChar(String str){
	 
	 List<Character> chr=new ArrayList<Character>();
	 String newString="";
	 for(int i=0;i<str.length();i++){
		 Character c= str.charAt(i);
		 chr.add(c);
	 }
	 for(int j=0;j<chr.size();j++){
		 if(!chr.contains(str.charAt(j))){
			 newString=newString+""+str.charAt(j);
		 }
	 }
	 return newString;
 }
}
