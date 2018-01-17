package threadPool;

public class InstallCables implements Runnable {
    public void run() {
        System.out.println("Start install cables");
        try {
            for (int i = 0 ; i < 100 ; ++i) {
                Thread.sleep(500);
            }
        }
        catch (Exception e)
        {
            System.err.println("Some kind of runtime exception occurred in thread.sleep()");
            System.err.println(e);
        }
        System.out.println("Work done!");
    }

}
