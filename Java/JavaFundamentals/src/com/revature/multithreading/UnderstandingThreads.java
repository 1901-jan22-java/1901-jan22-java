package com.revature.multithreading;

public class UnderstandingThreads {
	
	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable(); // Not Correct because doesn't have start() method.
		Thread irThread = new Thread(ir);
		Thread main = Thread.currentThread();

		System.out.println(main.getName() + " " + 
				main.getPriority()  + " " +
				main.getId());
		
		System.out.println(Thread.MIN_PRIORITY + " " + Thread.MAX_PRIORITY);
		
		et.setPriority(Thread.MIN_PRIORITY);
		irThread.setPriority(Thread.MAX_PRIORITY);
		
		
		System.out.println(et.getState());
		
		Thread lt = new Thread(() -> {
			for(int i = 0; i < 20; i++) {
				System.out.println("Lambda: " + i);
			}
		});
		
		Thread anonymous = new Thread() {
			@Override
			public void run() {
				System.out.println("stuff");
			}
		};

		run();
		et.start();
		irThread.start();
		lt.start();
		anonymous.start();
	}

	static void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("Main: " + i);
		}
	}
	
}
