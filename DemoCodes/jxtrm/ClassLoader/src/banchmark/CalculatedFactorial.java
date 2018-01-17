package banchmark;

public class CalculatedFactorial implements Execute {

	@Override
	public void execute() {
		System.out.println(calculatedFactorial(10));

	}

	private int calculatedFactorial(int i) {
		if (i == 1){
			return 1;
		}
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (i * calculatedFactorial(i - 1));
		
	}
	
	public static void main(String[] args) {
		new CalculatedFactorial().execute();
	}

}
