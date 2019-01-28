package hw1.q3;

public class ReverseString {
public String reverse(String oldString) {
	String newString=" ";
	for(int i=oldString.length()-1;i>=0;i++) {
		newString=newString+""+oldString.charAt(i);
	}
	return newString;
}
}
