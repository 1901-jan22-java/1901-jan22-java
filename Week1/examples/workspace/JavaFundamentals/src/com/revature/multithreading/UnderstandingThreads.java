package com.revature.multithreading;

public class UnderstandingThreads {
	/*
	 * Thread - a single path of execution in your code
	 * Multithreading - multiple flows of control in program execution
	 * 	- each thread gets its own stack and follows its own
	 * 	  sequence of method calls with associated variabls 
	 * We create a separate thread of execution by either
	 * implementing the Runnable interface or by extending
	 * the thread class. There are nuances associated w both 
	 * 
	 * Types of threads:
	 * 	- user - main() or any other explicitly requested processes
	 *  - daemon threads - background processes ie garbage collector
	 *  
	 *  isAlive() - checks if thread is active
	 *  join() - allows one thread ot wait for the completion of another
	 *  
	 *  --> JVM terminates when no more user threads are active
	 *  
	 *  synchronization - a method or statement is synchronized if 
	 *  only one thread may access it at a time
	 *  
	 *  Threads have state. they are:
	 *  New - thread is new 
	 *  Runnable - when ready to run(may be running or simply 
	 *  	ready to run at any time)
	 *  Blocked - aka waiting state
	 *  	When a thread is temporarily inactive it is either 
	 *  	blocked or waiting
	 *  	A thread is in the blocked state when it tries to 
	 *  	access a protected section of code that is currently
	 *  	locked in another thread
	 *  Waiting - threads can be made to wait for other actions
	 *  Timed Waiting - can call a timed wait method in threads
	 *  Terminated - a thread terminate because either it 
	 *  	completes it task naturally or because some 
	 *  	unusual or exceptional event occurs
	 *  
	 *  Related topics: deadlock, starvation, producer-consumer problem
	 */
	
	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread irThread = new Thread(ir);
		
		Thread main = Thread.currentThread();
		System.out.println(main.getName());
		System.out.println(main.getPriority());
		System.out.println(main.getState());
		
		et.setPriority(Thread.MIN_PRIORITY);
		irThread.setPriority(Thread.MAX_PRIORITY);
		
		et.start();
		irThread.start();
		run();
		
		System.out.println(et.getState());
		
		
		///////// LAMBDAS //////////////
		Runnable lambda = () -> {
			//overriding run method here 
			for(int i = 0; i < 20; i++) {
				System.out.println("LAMBDA: " + i);
			}
		};
		
		Thread lamThread = new Thread(lambda);
		lamThread.start();
		
		////////////Anonymous Classes
		Thread anonymous = new Thread() {
			@Override
			public void run() {
				//do thread things
			}
		};
		
		anonymous.start();
		
	}
	
	static void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("MAIN: " + i);
		}
	}

}
