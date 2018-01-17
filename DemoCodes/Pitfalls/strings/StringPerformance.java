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
public class StringPerformance {

	public static void main(String[] args) {
		String s1 = "a";
		StringBuffer sb1=new StringBuffer("a");

		long before = System.currentTimeMillis();
		for (int i=0; i<10000; i++) {
				s1+="b";
		}
		long after = System.currentTimeMillis();
		System.out.println("strings=" + (after-before));

		long before2 = System.currentTimeMillis();
		for (int i=0; i<10000; i++) {
				sb1.append("b");
		}
		long after2 = System.currentTimeMillis();
		System.out.println("stringbuffers=" + (after2-before2));
	}
}
