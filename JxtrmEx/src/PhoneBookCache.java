import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


public class PhoneBookCache {

	
	private Map<String, SoftReference<Person>> cache;
	private Set<Person> reference;
	
	public PhoneBookCache() {
		cache = new HashMap<String, SoftReference<Person>>();
		reference = new LinkedHashSet<Person>();	
	}
	
	
	public void addPerson(Person p){
		cache.put(p.getName(), new SoftReference<Person>(p));
		reference.add(p);
		try {
			writeToFile(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	


	public void removePerson(Person p){
		
	}
	
	public Person getPerson(String name){
		if (! cache.containsKey(name)){
			return null;
		}
		if (cache.get(name).get() != null){
			return cache.get(name).get();
		}
		try {
			Person p = readFromFile(new File(name));
			cache.put(p.getName(), new SoftReference<Person>(p));
			addToHardReference(p);
			return p;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	private void addToHardReference(Person p) {
		if (reference.size() > 100){
			reference.iterator().remove();
		}
		reference.add(p);
	}


	private Person readFromFile(File file) throws IOException, ClassNotFoundException {
		RandomAccessFile raf = null;
		try{
			raf = new RandomAccessFile(file, "r");
			FileChannel channel = raf.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate((int) raf.length());
			channel.read(buffer);
			byte[] bytes = new byte[(int) raf.length()];
			buffer.get(bytes);
			ByteArrayInputStream stram = new ByteArrayInputStream(bytes);
			ObjectInputStream obj = new ObjectInputStream(stram);
			return (Person) obj.readObject();
		}
		finally{
			if (raf != null){
				raf.close();
			}
		}
		
		
	}
	
	private void writeToFile(Person p) throws IOException {
		RandomAccessFile raf = null;
		try{
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			ObjectOutputStream obj = new ObjectOutputStream(stream);
			obj.writeObject(p);
			raf = new RandomAccessFile(p.getName(), "rw");
			FileChannel channel = raf.getChannel();
			byte[] bytes = stream.toByteArray();
			ByteBuffer buffer = ByteBuffer.wrap(bytes);
			channel.write(buffer);
		}
		finally{
			if (raf != null){
				raf.close();
			}
		}

		
	}
}
