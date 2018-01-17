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
public class Point {
	
	private int x, y;

		Point(int x, int y)
		{
			x = x; y = y;
			//this.x = x; this.y = y;
		}
		void moveTo(int x, int y)
		{
			x = x; y = y;
			//this.x = x; this.y = y;
		}
		public String toString()
		{
			return "(" + x + "," + y + ")";
		}
		public static void main(String args[])
		{
			Point p = new Point(10, 10);
			System.out.println(p);
			p.moveTo(30, 30);
			System.out.println(p);
		}

}
