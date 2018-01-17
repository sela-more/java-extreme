/*
 * Created on 26/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package hidden;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Ex1 {
	private int counter;

	public void inc(int nNumOfTimes)
	{
		for (int counter = 0 ; nNumOfTimes > 0 ; ++counter, --nNumOfTimes);
	}
	
	public void printCounter()
	{
		System.out.println("Counter = " + counter);
	}
	
	public static void main(String args[])
	{
		Ex1 instance = new Ex1();
		instance.inc(10);
		instance.printCounter();
	}

}
