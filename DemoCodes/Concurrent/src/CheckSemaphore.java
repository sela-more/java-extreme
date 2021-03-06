import java.util.concurrent.Semaphore;

public class CheckSemaphore {
	Semaphore mySemaphore;
	
	public CheckSemaphore(){
		mySemaphore = new Semaphore(5, true);
	}
	
	public void doSomething() throws InterruptedException{
		System.out.println(Thread.currentThread().getId());
		mySemaphore.acquire();
		System.out.println("i'm just doing something..." + Thread.currentThread().getId());
		Thread.sleep(1000);
		mySemaphore.release();
	}

}