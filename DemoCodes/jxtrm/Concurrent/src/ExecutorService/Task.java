package ExecutorService;

import java.util.concurrent.Callable;

public class Task implements Callable<Result>{

	int left;
	int right;
	
	@Override
	public Result call() throws Exception {
		return new Result(left,right);
	}

	public Task(int left, int right) {
		super();
		this.left = left;
		this.right = right;
	}


}
