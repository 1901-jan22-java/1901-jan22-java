package com.revature.collections;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;

public class LTQ {
	
	LinkedTransferQueue<String> ltq = new LinkedTransferQueue<String>();
	
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService exService = Executors.newFixedThreadPool(2);
		A a = new LTQ().new A();
		B b = new LTQ().new B();
		
		exService.execute(a);
		exService.execute(b);
		exService.shutdown();
		
	}

class A implements Runnable{ 
		    
		@Override
	    public void run(){
			for (int i = 0; i < 5; i ++) {
	    		try {
					ltq.transfer("" + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    	}
		}
	        	
}

class B implements Runnable {
	
	public void run() {
		
		for( int i = 0; i < 5; i ++) {
			try {
				String s = ltq.take();
				System.out.println(s);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		}
}
}
