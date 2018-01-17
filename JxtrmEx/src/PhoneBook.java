
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
class PhoneBook implements Cloneable
{
	private HashMap<String, Person> m_Persons = new HashMap<String, Person>();
	private Semaphore sem = new Semaphore(5);
	private ThreadPoolExecutor threadPool;

	public PhoneBook(){
		threadPool = new ThreadPoolExecutor(5, 10, 3, TimeUnit.SECONDS, new LinkedBlockingQueue());
		
	}
	
	
	public String toString()
	{
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer temp = new StringBuffer();
		Iterator<Person> iter = m_Persons.values().iterator();
		while(iter.hasNext())
			temp.append(iter.next().toString()).append("\n");
		sem.release();
		return temp.toString();
	}


	public void addPerson(Person p)
	{
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m_Persons.put(p.getName(), p);
		sem.release();
	}

	public Person getPerson(String sName)
	{
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person p = m_Persons.get(sName);
		sem.release();
		return p;
	}

	public void printPersonDetails(String sName)
	{
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(m_Persons.get(sName).toString());
		sem.release();
	}

	public Object clone() throws CloneNotSupportedException
	{
		System.out.println("cloning phonebook");
		PhoneBook copy = (PhoneBook)super.clone();
		copy.m_Persons = new HashMap<String, Person>();
		Iterator<Entry<String, Person>> iter = m_Persons.entrySet().iterator();
		while(iter.hasNext())
		{
			Map.Entry<String, Person> nextEntry = (Map.Entry<String, Person>)iter.next();
			copy.m_Persons.put(nextEntry.getKey(),
							   (Person) ((Person)nextEntry.getValue()).clone());
		}
		return copy;
	}
	
	public void sendSMS(String message){
		threadPool.submit(new SMSTask(message));
	}

};

