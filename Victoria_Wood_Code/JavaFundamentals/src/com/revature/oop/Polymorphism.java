package com.revature.oop;

import java.io.IOException;

public class Polymorphism {
	
	public static void main(String[] args) {
		
	}

}
class Y {
	void doThings() throws IOException{
		throw new IOException();
	}
}

class Z extends Y{
	
	@Override
	void doThings() { //has to throw IOException or anything lower on Exception hierarchy
		
	}
}