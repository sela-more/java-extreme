import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
 
public class FibonacciTask extends RecursiveTask<Long> {

private static final long serialVersionUID = 6136927121059165206L;

private static final int THRESHOLD = 5;

private int value;
public long result;

public FibonacciTask(int calc) {
	value = calc;
}

@Override
public Long compute() {
if (value < THRESHOLD) { // easy problem, don't bother with parallelism
	result = fibonacci(value);
}
else {
FibonacciTask worker1 = new FibonacciTask(value-1);
FibonacciTask worker2 = new FibonacciTask(value-2);
worker1.fork();
result = worker2.compute() + worker1.join();
}
return result;
}

private long fibonacci(int n) {
	if (n <= 1){
		return n;
	}
	else{
		return fibonacci(n-1) + fibonacci(n-2);
	}


}

public static void main(String[] args) {
	ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
	FibonacciTask task = new FibonacciTask(40);
	pool.invoke(task);
	long result = task.result;
	System.out.println(result);
}

}


