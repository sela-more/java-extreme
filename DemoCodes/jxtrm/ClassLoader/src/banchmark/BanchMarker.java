package banchmark;

import java.util.Scanner;

public class BanchMarker extends ClassLoader{

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		BanchMarker bm = new BanchMarker();
		while (true){
			System.out.println("please enter the name of the class that you would like to banchmark");
			Scanner sc = new Scanner(System.in);
			String className = sc.next();
			if ("-t".equals(sc.next())){
				int numOfThreads = sc.nextInt();
				for (int i = 0;i < numOfThreads;i++){
					Thread thread = new Thread(new MultiThreadedBanchMark(bm,className));
					thread.start();
				}
			}else{
				bm.doBanchmarking(className);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void doBanchmarking(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<Execute> t = (Class<Execute>) loadClass(className, true);	
		Execute e = t.newInstance();
		System.out.println(System.currentTimeMillis());
		e.execute();
		System.out.println(System.currentTimeMillis());

	}

}
