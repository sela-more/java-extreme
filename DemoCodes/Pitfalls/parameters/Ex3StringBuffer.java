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
public class Ex3StringBuffer {

	public static void main(String args[])
  {
	StringBuffer sb = new StringBuffer("Hello");
	System.out.println(sb.toString());
	f(sb);
	System.out.println(sb.toString());
  }

  private static void f(StringBuffer sb)
  {
	sb.append(" world");
  }
}
