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
public class UseArray {

	public static void main(String args[])
	{
		int i[] = {3}, j[] = {4};
		System.out.println("i = " + i[0] + " j = " + j[0]);
		swap(i, j);
		System.out.println("i = " + i[0] + " j = " + j[0]);
	}

	private static void swap(int i[], int j[])
	{
		int Temp = i[0];
		i[0] = j[0];
		j[0] = Temp;
	}
}
