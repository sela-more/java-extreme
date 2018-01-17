/*
 * Created on 26/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package strings;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class newString {

	public static void main(String[] args) {
		String s1="Hello Java";
		// The difference from Ex1: NEW string created
		String s2=new String("Hello Java");
		
		System.out.println("s1 == s2: " + (s1 == s2));
		System.out.println("s1.equals(s2): " + s1.equals(s2));
		System.out.println("compare(s2): " + compare(s2));
	}

	private static boolean compare(String sOther)
	{
		return sOther == "Hello Java";
	}
	
}
