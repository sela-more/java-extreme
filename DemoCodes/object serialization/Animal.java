import java.io.*;
import java.util.*;

public class Animal implements Serializable
{

	String myName;
	transient Date today = new Date();


	public static void main(String args[])
	{

			ArrayList al = new ArrayList();
			Animal myObj = new Animal("Baruch");
			Animal myObj2 = new Animal("Muki");
			al.add(myObj);
			al.add(myObj2);

		   try
			{
				FileOutputStream out = new FileOutputStream("file.txt");
				ObjectOutputStream objOut = new ObjectOutputStream(out);
				objOut.writeObject(al);


				FileInputStream in = new FileInputStream("file.txt");
				ObjectInputStream objIn = new ObjectInputStream(in);
				ArrayList newAnims = (ArrayList)objIn.readObject();


				Animal newAnim = (Animal)newAnims.get(1);

				System.out.println(newAnim.myName);
				System.out.println(newAnim.today);

		    }
		    catch(FileNotFoundException f)
		    {
				f.printStackTrace();
			}
			catch(IOException io)
			{
			 	  io.printStackTrace();
		    }
		    catch(ClassNotFoundException c)
			{
				  c.printStackTrace();
		    }

	}

	Animal(String newName)
	{
		myName=newName;
	}




}