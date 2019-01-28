package question14;

import java.util.Date;

public class UseSwitch {
	public static void main(String[] args) {
		switchExample(1);
		switchExample(2);
		switchExample(3);
		

		
	}
	
	public static void switchExample(int num) {
		switch(num) {
		case 1: System.out.println("The square root of 25 is: " + Math.sqrt(25)); break;
		case 2: Date d = new Date(); System.out.println("The date is: " + d.toString()); break;
		case 3: String[] array = ("I am learning Core Java").split(" ");
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}; break;
		}
	}

}
