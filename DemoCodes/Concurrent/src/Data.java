import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Data {
	String data;

	public String getData() {
		return data;
	}

	public Data(String data) {
		this.data = data;
	}

	public void setData(String string) {
		data = string;
	}

	public static void main(String[] args) {
		ReadWriteLock rw = new ReentrantReadWriteLock();
		Data d = new Data("0");
		Thread t1 = new Thread(new Reader(d, "aaaaaaaaaaa", rw));
		Thread t2 = new Thread(new Reader(d, "bbbbbbbbbbb", rw));
		Thread t3 = new Thread(new Reader(d, "ccccccccccc", rw));
		Thread t4 = new Thread(new Writer(d, rw));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
