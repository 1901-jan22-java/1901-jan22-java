package com.revature.multithreading;

public class ExtendsThread extends Thread {
	/*
	 * the run method basically represent the main() method of 
	 * our separate thread
	 * 
	 * we add the functionality that we want to break off into a different thread here
	 * 
	 * the run() method is the sole abstract method of the Runnable interface, 
	 * which Thread implements
	 * 
	 */
	
	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("ET: " + i);
		}
	}
			
}
