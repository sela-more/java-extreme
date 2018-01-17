import java.io.*;

public class Animal implements Serializable {
	String myName;
	private String type;

	Animal(String newName, String animalType) {
		myName = newName;
		type = animalType;
	}

	public static void main(String args[]) {
		Animal shraga = new Animal("Shraga", "Duck");
		try {
			serializeAnimal(shraga);
		} catch (IOException io) {
			io.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static void serializeAnimal(Animal animObj) throws IOException,
			ClassNotFoundException {
		FileOutputStream out = new FileOutputStream("file.txt");
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		objOut.writeObject(animObj);// Write to file

		FileInputStream in = new FileInputStream("file.txt");
		ObjectInputStream objIn = new ObjectInputStream(in);
		Animal newAnimal = (Animal) objIn.readObject(); // Read from file

		System.out.println(newAnimal.myName);
		System.out.println(newAnimal.type);
	}
} // End of class

