package exchanger;

public class Exchanger<X> {

	private X objOfWaitedThread;
	private Thread waitThread;
	private Object monitor = new Object();
	
	public X exchange(X x) throws InterruptedException{
		synchronized (monitor) {
			if (waitThread == null){
				waitThread = Thread.currentThread();
				objOfWaitedThread = x;
				monitor.wait();
				return objOfWaitedThread;
			}else{
				X result = objOfWaitedThread;
				objOfWaitedThread = x;
				monitor.notify();
				return result;
			}
		}
	}
	
	public static void main(String[] args) {
		Exchanger<Dog> ex = new Exchanger<Dog>();
		Thread thread1 = new Thread(new Tester("muki",ex), "first");
		Thread thread2 = new Thread(new Tester("flafi",ex), "second");
		thread1.start();
		thread2.start();
	}
}
