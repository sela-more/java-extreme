
public class Class3
{
    static {
        System.out.println("Class1 was loaded");
    }
    
    public Class3()
    {
        System.out.println("In Class1 constructor");
    }

    public void go()
    {
        System.out.println("I’m " + this.toString());
    }
}
