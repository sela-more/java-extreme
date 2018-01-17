import java.util.concurrent.Phaser;


public class Ex2 implements Runnable{
	
	private Phaser phaser;
	
	
	
	public Ex2(Phaser phaser) {
		super();
		this.phaser = phaser;
		phaser.register();
	}

	public static void main(String[] args) {
		Phaser p = new Phaser();
		Thread t1 = new Thread(new Ex2(p));
		t1.start();
		Thread t2 = new Thread(new Ex2(p));
		t2.start();
		Thread t3 = new Thread(new Ex2(p));
		t3.start();

	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(phaser.getArrivedParties() + " " + Thread.currentThread().getId());
		System.out.println(phaser.getRegisteredParties());
		System.out.println("phase 1");
		phaser.arriveAndAwaitAdvance();
		System.out.println("phase 2");
		System.out.println(phaser.getArrivedParties() + " " + Thread.currentThread().getId());
		System.out.println(phaser.getRegisteredParties());
		phaser.arriveAndAwaitAdvance();
		System.out.println("phase 3");
		System.out.println(phaser.getArrivedParties() + " " + Thread.currentThread().getId());
		System.out.println(phaser.getRegisteredParties());
		phaser.arriveAndAwaitAdvance();

		
	}
}
