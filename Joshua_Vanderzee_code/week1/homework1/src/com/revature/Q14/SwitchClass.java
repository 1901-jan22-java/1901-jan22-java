package com.revature.Q14;

import java.text.DateFormat;

public class SwitchClass {
	
	public static String[] start(SwitchStates s) {
		return start(s, 0);
	}
	
	public static String[] start(SwitchStates s, double num) {
		String[] arrStr = {""};
		switch(s) {
		case sqrt:
			System.out.println(Math.sqrt(num));
			break;
		case DateToday:
			System.out.println(DateFormat.getDateInstance().getCalendar().getTime());
			break;
		case SplitString:
			String str = "I am learning Core Java";
			arrStr = str.split(" ");
			return arrStr;
		}
		return arrStr;
	}
}
