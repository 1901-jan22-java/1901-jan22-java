package com.revature.collections;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CLQ {
	
	public static void main(String[] args) {
		
		ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();
		A a = new A(clq);
		B b = new B(clq);
		
		a.run();
		b.run();
		
	}
}

class A extends Thread{ // adds Strings to queue
	ConcurrentLinkedQueue<String> queue;
	   A(ConcurrentLinkedQueue<String> queue){
	      this.queue = queue;
	   }
	      
	      public void run(){
	    	  for (int i = 0; i < 5; i ++) {
	    		  queue.add("" + i);
	    	  }
	      }
	        	
}

class B extends Thread { // prints out each element in queue
	ConcurrentLinkedQueue<String> queue;
	   B(ConcurrentLinkedQueue<String> queue){
	      this.queue = queue;
	   }
	   
	   public void run() {
		   for(String s : queue) {
			   System.out.println(s);
		   }
	   }

}
