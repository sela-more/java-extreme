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
public class Shape implements Cloneable {
	
		private int x, y, width, height;

		public Shape(int x, int y, int width, int height)
		{
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
		public String toString()
		{
			return "x = " + x + " y = " + y + " Width = " 
						  + width + " Height = " + height;
		}

		public Object clone() throws CloneNotSupportedException
		{
			System.out.println("shape");
			return new Shape(1,2,3,4);
			//return super.clone();
		}

}
