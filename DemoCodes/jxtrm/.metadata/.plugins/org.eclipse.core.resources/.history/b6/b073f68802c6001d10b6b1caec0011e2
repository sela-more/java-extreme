package instrumentation.example;

import java.lang.instrument.Instrumentation;

public class SimpleInstrumentation {

	public static void premain(String agentArguments, Instrumentation instrumentation) {	
		instrumentation.addTransformer(new SimpleTransformer());
	}
}