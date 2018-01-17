import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;


public class Example {

	static TransferQueue<String> tq;
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		tq = new LinkedTransferQueue<String>();
		tq.add("hi");
		tq.add("my");
		tq.add("name");
		tq.add("is");
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
				try {
					System.out.println(tq.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		t.setDaemon(true);
		t.start();
		Thread.sleep(1000);
		System.out.println("number of waiting " + tq.getWaitingConsumerCount());
		tq.transfer("moshe");
		tq.transfer("shamy");
		Thread.sleep(10);
		System.out.println("number of waiting " + tq.getWaitingConsumerCount());
		

	}

}
