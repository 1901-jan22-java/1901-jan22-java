package question_14;

import java.util.Date;

public class Switch_Practice {

	public static void main(String[] args) {
		
		int num = 3;
		int x = 9;
		
		switch(num) {
			case 1: 
				System.out.println(Math.sqrt(x)); 
				break;
			case 2: 
				System.out.println(new Date()); 
				break;
			case 3:
				String str = "I am learning core Java";
				String[] strArray = str.split(" ");
				for(String s : strArray)
					System.out.println(s);
				break;
		}
	}
	
}
