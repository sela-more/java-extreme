public class Driver
{
    public static void main(String args[])
    {
        System.out.println("In Main before Instantiating Class 1");
        Class1 c1 = new Class1();
        c1.go();
        System.out.println("In Main after Instantiating Class 1");
        ClassLoader loader = c1.getClass().getClassLoader();
        Class2 instanceOfClass2 = null;
        Class3 instanceOfClass3 = null;
        try {
            System.out.println("--Before loading Class2");
            Class ClassOfClass2 = loader.loadClass("Class2");
            System.out.println("--After loading Class2");
            
            System.out.println("--Before instantiating Class2");
            instanceOfClass2 = (Class2)ClassOfClass2.newInstance();
            System.out.println("--After instantiating Class2");
            System.out.println("--Before loading Class3");
            Class ClassOfClass3 = loader.loadClass("Class3");
            System.out.println("--After loading Class3");          
            System.out.println("--Before instantiating Class3");
            instanceOfClass3 = (Class3)ClassOfClass3.newInstance();
            System.out.println("--After instantiating Class3");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error - Class not found");
        }
        catch (InstantiationException e)
        {
            System.out.println("Error - Instantiation exception");
        }
        catch (IllegalAccessException e)
        {
            System.out.println("Error - Illegal Access Exception");
        }
        instanceOfClass2.go();
        instanceOfClass3.go();
        System.out.println("Done");
    }
}
