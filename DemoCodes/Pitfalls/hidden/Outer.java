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
public class Outer {
	int Counter;
	class Inner
	{
		int Counter;
		void inc() {
			Counter++;
			//++Outer.this.Counter;
		}
	};
	Outer()	{
		Inner i = new Inner();
		i.inc();
		System.out.println(Counter);
	}
	public static void main(String args[]) {
		new Outer();
	}

}
