import java.nio.CharBuffer;


public class Driver {

	public static void main(String[] args) {
		String text = "CB text 3";
		    CharBuffer cb = CharBuffer.allocate(text.length() + 10);
		    cb.put(text);
		    cb.flip();
		    char[] carray = cb.array();
		    System.out.println("hasArray() = " + cb.hasArray() +", length="+ carray.length);
		    System.out.print("array=");
		    for (int i = 0; i < carray.length - 2; i++) {
		      System.out.print(carray[i]);
		    }
		    System.out.println("");
		    System.out.flush();
		    cb.compact();
		    cb.put('e').put('n').put('d');
		    cb.flip();
		    char[] result = new char[3];
		    cb.get(result);
		    System.out.println(result);
		}

}
