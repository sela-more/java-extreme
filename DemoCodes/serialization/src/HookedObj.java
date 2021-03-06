import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HookedObj implements Serializable, Runnable {
   private String myName;
   private String myLastName;
   HookedObj(String newName, String animalType) {
	   myName=newName;
	   myLastName = animalType;
	   Thread t = new Thread(this);
	   t.start();
   }
   
   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
   System.out.println(" test...");
     // our "pseudo-constructor"
     in.defaultReadObject();
     Thread t = new Thread(this);
     t.start();
   }
   
   static void serializeAnimal(HookedObj animObj) throws IOException, ClassNotFoundException {
	   FileOutputStream out = new FileOutputStream("file.txt");
	   ObjectOutputStream objOut = new ObjectOutputStream(out);
	   objOut.writeObject(animObj);// Write to file

	    FileInputStream in = new FileInputStream("file.txt");
	    ObjectInputStream objIn = new ObjectInputStream(in);
	    HookedObj newAnimal = (HookedObj)objIn.readObject(); // Read from file

	    System.out.println(newAnimal.myName);
	    System.out.println(newAnimal.myLastName);
   }

	@Override
	public void run() {
	System.out.println("my name is " + myName + " " + myLastName);

	}
	
	public static void main(String args[]) {
		   HookedObj shraga = new HookedObj("Shraga", "Zalmanovitch");
		   try{
		serializeAnimal(shraga);
		   } catch(IOException io) {
		 io.printStackTrace();
		   } catch (ClassNotFoundException e) {
		e.printStackTrace();
		   }
		  }
}
