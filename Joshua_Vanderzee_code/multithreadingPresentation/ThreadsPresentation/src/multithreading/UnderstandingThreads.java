package multithreading;

public class UnderstandingThreads {

	/*
	 * Multithreading refers to two or more tasks executing concurrently within a single program. 
	 * A thread is an independent path of execution within a program. Many threads can run concurrently within a program. 
	 * Every thread in Java is created and controlled by the java.lang.Thread class.
	 * */
	
	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread irThread = new Thread(ir);

		Thread main = Thread.currentThread();
		System.out.println(main.getName());
		System.out.println(main.getPriority());
		System.out.println(main.getId());
		System.out.println(main.getState());

		et.setPriority(Thread.MIN_PRIORITY);
		irThread.setPriority(Thread.MAX_PRIORITY);

		System.out.println(et.getState());

		// Lambdas
		Runnable lambda = () -> {
			for (int i = 0; i < 20; i++) {
				System.out.println("Lambda " + i);
			}
		};

		Thread lamThread = new Thread(lambda);
		et.start();
		irThread.start();
		lamThread.start();

		Thread ann = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("ann " + i);
				}
			}
		};

		ann.start();
	}

}
