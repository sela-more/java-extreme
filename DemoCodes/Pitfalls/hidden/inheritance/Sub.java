/*
 * Created on 26/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package hidden.inheritance;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Sub extends Base{
	private String NAME = "SUB";
	public String getName() {
			return NAME;

	}
	public String toString() 
	{
		return super.toString();
	}

	public static void main(String args[])
		{
			System.out.println(new Base());
			System.out.println(new Sub());
		}


}
