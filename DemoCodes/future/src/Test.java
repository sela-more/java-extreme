import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test implements Runnable {
	
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Test());
		t.start();
		t.join();

	}

	@Override
	public void run() {
		InputStreamReader stdin = new InputStreamReader(System.in);
		BufferedReader bufRead  = new BufferedReader(stdin);
		while(true)
		{
		 try {
			 String text = bufRead.readLine();
			 System.out.println(text);
			 if (text.equals("exit")){
				 return;
			 }
		 }
		 catch(IOException io)	 {
		   io.printStackTrace();
		 }
		}
	}


}
