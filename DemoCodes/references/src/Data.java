public class Data {

	double m_d[] = new double[500];
	static int counter=0;
	Data() {
		counter++;
	}
}
 class Student {
	String m_name;
	public Student(String name) {
		m_name=name;
	}
	public String toString() {
		return "student="+m_name;
	}
	protected void finalize() {
		System.out.println("finalize() m_name=" + 	
		m_name + " Data counter: " + Data.counter);
	}}
