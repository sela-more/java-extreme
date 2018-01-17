package clone1.ex1;
class Rectangle implements Cloneable
{
	private Point m_P1, m_P2;

	Rectangle(Point p1 , Point p2)
	{
		m_P1 = p1;
		m_P2 = p2;
	}

	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	public String toString()
	{
		return "Rectangle:\n\tp1: " + m_P1 + "\n\tp2: " + m_P2;
	}

	public void move(int nX, int nY)
	{
		m_P1.move(nX, nY);
		m_P2.move(nX, nY);
	}	
}

