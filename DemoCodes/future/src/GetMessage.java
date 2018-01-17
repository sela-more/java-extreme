import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;


public class GetMessage implements Callable<String> {

	@Override
	public String call() throws Exception {
		InputStreamReader stdin = new InputStreamReader(System.in);
		BufferedReader bufRead  = new BufferedReader(stdin);
		return bufRead.readLine();
	}

}
