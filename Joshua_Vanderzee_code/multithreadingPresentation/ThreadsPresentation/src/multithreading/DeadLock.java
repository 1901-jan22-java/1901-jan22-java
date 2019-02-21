package multithreading;

public class DeadLock {
	
	public static void main(String[] args) {
		DeadLockTest RunClass1 = new DeadLockTest(1);
		DeadLockTest RunClass2 = new DeadLockTest(2);
		Thread thread1 = new Thread(RunClass1);
		Thread thread2 = new Thread(RunClass2);
		thread1.start();
		thread2.start();
	}

}

class DeadLockTest implements Runnable {

	public DeadLockTest(int lock) {
		this.lock = lock;
	}
	
	private int lock;
	static Object lock1 = new Object();
	static Object lock2 = new Object();
	
	@Override
	public void run() {
		
		if (lock == 1) {
			synchronized(lock1) {
				System.out.println("using lock1");
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("waiting for lock2 to be avalable.");
				synchronized(lock2) {
					System.out.println("By some merical, lock2 is in use.");
				}
			}			
		} else {
			synchronized(lock2) {
				System.out.println("using lock2");
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("waiting for lock1 to be avalable.");
				synchronized(lock1) {
					System.out.println("By some merical, lock1 is in use.");
				}	
			}
		}
	}
}