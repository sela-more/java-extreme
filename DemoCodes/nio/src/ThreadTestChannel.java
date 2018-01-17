import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;


public class ThreadTestChannel implements Runnable{ 
	FileChannel fc;
	public ThreadTestChannel(FileChannel file) {
		fc = file;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		RandomAccessFile raf = new RandomAccessFile ("somefile", "rw");
		FileChannel fc = raf.getChannel( );
		Thread t = new Thread(new ThreadTestChannel(fc));
		t.start();
		t.interrupt();
		Thread.sleep(100);
		System.out.println(fc.isOpen());
	}

	@Override
	public void run() {
		ByteBuffer bb = ByteBuffer.allocate(100);
		String s = "hello world";
		ByteBuffer bbb = ByteBuffer.allocate(100);
		String ss = "hello world2";
		Charset charset = Charset.forName("ISO-8859-1");
		bbb = charset.encode(ss);
		bb = charset.encode(s);
		try {
			fc.write(bb);
			Thread.sleep(100);
			System.out.println("finish sleeping");
			fc.write(bbb);
			fc.close();
		} catch (IOException e) {
			// 	TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// 	TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}