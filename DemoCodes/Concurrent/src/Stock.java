class Stock
{
	private String m_sName;
	private float m_nPrice;
	Stock(String sName)
	{
		m_sName = sName;
	}
	public synchronized float get() {
		return m_nPrice;
	}
	public synchronized void set(float price) {
		m_nPrice = price;
	}
}