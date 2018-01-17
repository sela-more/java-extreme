package ExecutorService;

public class Result {

	double answer;
	int modulu;

	public Result(int left, int right) {
		answer = (double)left / right;
		modulu = left % right;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public double getAnswer() {
		return answer;
	}

	public int getLengthOfdigitsAfterPoint() {
		return modulu;
	}

}

