package com.revature.multithreading;

public class UnderstandingThreads {

	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable(); //NOT CORRECT
		Thread irThread = new Thread(ir);
		
		Thread main = Thread.currentThread();
		System.out.println(main.getName());
		System.out.println(main.getPriority());
		System.out.println(main.getState());
		
		//////LAMBDAS//////
		Runnable lambda = () -> {
			//overriding run method here
			for(int i = 0; i < 20; i++) {
				System.out.println("LAMBDA: " + i);
			}
		};
		
		Thread lamThread = new Thread(lambda);
		lamThread.start();
		
		// Anonymous Classes
		Thread anonymous = new Thread() {
			@Override
			public void run() {
				//do thread things
			}
		};
		
		et.setPriority(Thread.MIN_PRIORITY);
		irThread.setPriority(Thread.MAX_PRIORITY);
		
		et.start();
		irThread.start();
		run();
	}
	
	static void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("MAIN: " + i);
		}
	}
}
