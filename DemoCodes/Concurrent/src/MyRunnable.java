import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyRunnable implements Runnable {

	CyclicBarrier barrier;
	public MyRunnable(CyclicBarrier bar) {
		barrier = bar;
	}

	@Override
	public void run() {
		try {
			System.out.println(barrier.getNumberWaiting());
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("do something" + new Date());

	}

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier barrier = new CyclicBarrier(5);
		Thread thread1 = new Thread(new MyRunnable(barrier));
		thread1.start();
		Thread.sleep(100);
		Thread thread2 = new Thread(new MyRunnable(barrier));
		thread2.start();
		Thread.sleep(100);
		Thread thread3 = new Thread(new MyRunnable(barrier));
		thread3.start();
		Thread.sleep(100);
		Thread thread4 = new Thread(new MyRunnable(barrier));
		thread4.start();
		Thread.sleep(100);
		Thread thread5 = new Thread(new MyRunnable(barrier));
		thread5.start();
	}

}
