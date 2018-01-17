/*
 * Created on 26/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package clone1.returnValue;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Rectangle extends Shape {
	
		public Rectangle(int x, int y, int width, int height)
		{
			super(x, y, width, height);
		}

		public Object clone() throws CloneNotSupportedException
		{
			System.out.println("rect");
			Shape e = (Shape)super.clone();
			System.out.println("inside rect " + e.getClass().getName());	// rectanlge	
			return e;
		}
	
		public static void main (String args[]) throws Exception {
			Rectangle r1 = new Rectangle(1,2,3,4);
			Object r2 = (Object)r1.clone();
		
			System.out.println(r2.getClass().getName());
		}


}
