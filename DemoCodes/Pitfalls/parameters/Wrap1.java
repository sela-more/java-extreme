/*
 * Created on 26/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package parameters;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Wrap1 {

	public static void main(String args[])
	{
		Integer i = new Integer(1);
		System.out.println(i);
		inc(i);
		System.out.println(i);
	}

	private static void inc(Integer i)
	{
		i = new Integer(i.intValue() + 1);
	}
}
