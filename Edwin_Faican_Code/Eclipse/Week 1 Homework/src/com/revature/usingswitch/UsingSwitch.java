package com.revature.usingswitch;

import java.util.Date;

public class UsingSwitch {
	public static void main(String[] args) {
		int selection = (int) (Math.floor(Math.random()* 3) + 1) ;
		
		switch(selection) {
			case 1 : System.out.println(Math.sqrt((int) (Math.floor(Math.random()* 100) + 1))); break;
			case 2 : System.out.println(new Date()); break;
			case 3 : String[] res = ("I am learning Core Java").split(" "); for(String s : res) System.out.println(s);break;
			default: break;
		}
	}
}
