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
public class Ex1StringAssign {

	public static void main(String args[])
	{
		String s = "Hello";
		System.out.println(s);
		f(s);
		System.out.println(s);
	}

	private static void f(String sParam)
	{
		sParam = "Hello World";
	}
}
