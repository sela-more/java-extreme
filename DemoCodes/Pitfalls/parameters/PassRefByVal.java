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
public class PassRefByVal {

	int m_i=0;
	void setI(int i) {
		m_i = i;
	}

	public static void f(PassRefByVal test) {
	//test.m_i = 45; - if we do this, it will change the test
	// reference VALUE, but if we do the line below,
	// and try to change the reference, it will not do!
		test = new PassRefByVal();
	}
	public static void main(String[] args) {
		PassRefByVal myc1 = new PassRefByVal();
		System.out.println(myc1.m_i);
		myc1.setI(2);
		System.out.println(myc1.m_i);
		f(myc1);
		System.out.println(myc1.m_i);
	}
}
