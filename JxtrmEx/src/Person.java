
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
class Person implements Cloneable, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String m_sName;
	private LinkedList<String> m_Phones = new LinkedList<String>();
	ReadWriteLock lock;

	Person(String sName, String sPhoneNumber)
	{
		lock = new ReentrantReadWriteLock();
		m_sName = sName;
		m_Phones.add(sPhoneNumber);
	}

	public void addPhoneNumber(String sPhoneNumber)
	{
		lock.writeLock().lock();
		m_Phones.add(sPhoneNumber);
		lock.writeLock().unlock();
	}

	public void removePhoneNumber(String sPhoneNumber)
	{
		lock.writeLock().lock();
		System.out.println("removing person");
		m_Phones.remove(sPhoneNumber);
		lock.writeLock().unlock();
	}

	public Object clone() throws CloneNotSupportedException
	{
		System.out.println("cloning person");
		Person newPerson = (Person)super.clone();
		newPerson.m_Phones = (LinkedList)m_Phones.clone();
		return newPerson;
	}

	public String getName()
	{
		return m_sName;
	}

	public String toString()
	{
		lock.readLock().lock();
		StringBuffer temp = new StringBuffer().append("Person, Name = ").
			append(m_sName).
			append("\n").
			append("Phones:");
		Iterator<String> iter = m_Phones.iterator();
		while(iter.hasNext())
			temp.append("\t").append(iter.next());
		lock.readLock().unlock();
		return temp.toString();
	}
};