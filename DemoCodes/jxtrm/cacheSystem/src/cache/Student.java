package cache;

public class Student implements Cacheable{

	private String name;
	private long id;
	private Thread thread;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(long i, String name) {
		super();
		this.id = i;
		this.name = name;
		thread = new Thread();
	}
	@Override
	public boolean equals(Object other) {
		return getName().equals(((Cacheable)other).getName());
	}
	@Override
	public int hashCode() {
		return getName().hashCode();
	}
	@Override
	public String toString() {
		return getName().toString();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
