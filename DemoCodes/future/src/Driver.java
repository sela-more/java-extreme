import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Driver {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(10);
		List<GetMessage> tasks = new LinkedList<GetMessage>();
		for (int i = 0;i < 5;i++){
			tasks.add(new GetMessage());
		}
		List<Future<String>> results = pool.invokeAll(tasks);
		for (Future<String> res : results){
			System.out.println(res.get());
		}
		pool.shutdown();
	}
}
