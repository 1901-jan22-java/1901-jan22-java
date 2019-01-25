package com.revature.multithreading;

public class ProducerConsumerProb {
	static int bananas = 10000;
	
	public static void main(String[] args) {
		
		
		Runnable producer = () -> {
			//overriding run method here 
			int count = 0;
			int currBananas = bananas;
			while(count < 10000) {
				currBananas ++;
				count++;
			}
			bananas = currBananas;
		};
		
		Runnable consumer = () -> {
			int count = 10000;
			int currBananas = bananas;
			while(count > 0) {
				currBananas--;
				count--;
			}
			bananas = currBananas;
		};
		
		Thread conThread = new Thread(consumer);
		conThread.start();
		
		Thread proThread = new Thread(producer);
		proThread.start();
		
		while(conThread.isAlive() || proThread.isAlive()) {
			
		}
		
		System.out.println(bananas);
	}
}
