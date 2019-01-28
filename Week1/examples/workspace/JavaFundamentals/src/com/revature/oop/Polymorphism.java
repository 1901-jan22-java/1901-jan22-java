package com.revature.oop;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Polymorphism {

	public static void main(String[] args) {
		
	}
}

class Y{
	void doThings(int t){
	}
}


class Z extends Y{
	
	String doThings(String t, String x)  {
		return null;
	}
	String doThings(String t)  {
		return null;
	}
}
