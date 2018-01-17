import java.lang.ref.*;
public class WeakRefContainer {
	WeakReference m_students[] = new WeakReference[10];
	WeakRefContainer() {
		for (int i=0; i<10; i++)
		m_students[i] = new WeakReference(
		new Student("student" + i));
	}
   public void print() {
		Reference sr;
		for (int i=0; i<10; i++) {
			sr = m_students[i];
			Object temp = sr.get();
			if (temp!=null) {
				// object found
			}
			System.out.println(
				"printing container: " + temp);
		}
	}
   
   public static void main (String args[]) {

	   WeakRefContainer s = new WeakRefContainer();
		s.print();

		System.out.println("Filling memory with junk...");
		Data d[] = new Data[5000];
		for (int i=0; i<d.length; i++)
			d[i] = new Data();

		s.print();

		}
	}
