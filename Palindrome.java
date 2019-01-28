package hw1.q8;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
public void savePalindrome() {
	List<String> names=new ArrayList<String>();
	List<String> pNames=new ArrayList<String>();
	names.add("karan");names.add("madam");names.add("tom");names.add("civic");
	names.add("radar");names.add("sexes");names.add("jimmy");names.add("kayak");
	names.add("john");names.add("refer");names.add("billy");names.add("did");
	for(int i=0;i<names.size();i++) {
		if(names.get(i).charAt(0)==names.get(i).charAt(names.get(i).length()-1)) {
			if(names.get(i).length()<=3) {
				pNames.add(names.get(i));
			}
			if(names.get(i).charAt(1)==names.get(i).charAt(names.get(i).length()-2)) {
				
			}
		}
	}
}
}
