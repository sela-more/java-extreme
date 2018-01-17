package clone1.ex1;
class Point implements Cloneable
{
	private int m_nX;
	private int m_nY;

	Point (int nX, int nY)
	{
		m_nX = nX;
		m_nY = nY;
	}

	public void move(int nX, int nY)
	{
		m_nX += nX;
		m_nY += nY;
	}

	public String toString()
	{
		return "( " + m_nX + ", " + m_nY + ")";
	}
}
