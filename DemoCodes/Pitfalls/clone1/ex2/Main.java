package clone1.ex2;
class Main
{
	public static void main(String args[])
	{
		try {
			Rectangle Source = new Rectangle(new Point(10, 10), new Point(30, 30));
			System.out.println("Source " + Source);
			Rectangle copy = (Rectangle)Source.clone();
			System.out.println("Copy " + copy);				
			copy.move(20, 20);
			System.out.println("Copy was moved");
			System.out.println("Source " + Source);
			System.out.println("Copy " + copy);				
			
		}
		catch(CloneNotSupportedException e)
		{
			System.out.println(e);
		}
	}
}