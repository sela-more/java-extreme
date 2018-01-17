package ExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Mgr {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task(5,8));
		tasks.add(new Task(7,9));
		tasks.add(new Task(13,11));
		tasks.add(new Task(10,2));
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		List<Future<Result>> results = threadPool.invokeAll(tasks);
		System.out.println(results);

	}

}