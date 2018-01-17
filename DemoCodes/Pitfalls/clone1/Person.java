/*
 * Created on 26/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package clone1;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Person implements Cloneable {

	  private StringBuffer m_sName; 
	  private int m_nAge;
	  Person(StringBuffer sName, int nAge)
	  {
		m_nAge = nAge;
		m_sName = sName;
	  }
	  public Object clone() throws CloneNotSupportedException
	  {
		return super.clone();
	  }


	  public static void main(String args[]) throws Exception
	  {
			Person p1 = new Person(new StringBuffer("Richard"), 21);
			Person p2 = (Person)p1.clone();

			p2.m_sName.append(" the third");
			p2.m_nAge = 22;

			System.out.println("p2="+p2.m_sName + ", "  + p2.m_nAge);
			System.out.println("p1="+p1.m_sName + ", "  + p1.m_nAge);

	  }


}
