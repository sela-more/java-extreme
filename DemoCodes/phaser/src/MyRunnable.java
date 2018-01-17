import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;


public class MyRunnable implements Runnable {

	Phaser phaser;
	public MyRunnable(Phaser bar) {
		phaser = bar;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5;i++){
			System.out.println(phaser.getRegisteredParties() + " " + phaser.getArrivedParties());
			phaser.arriveAndAwaitAdvance();
			System.out.println("do something" + new Date());
		}

	}

	
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		Phaser barrier = new Phaser(5);
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
