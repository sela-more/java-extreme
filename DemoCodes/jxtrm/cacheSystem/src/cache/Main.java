package cache;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long i = 0;
		CacheMgr cache = new CacheMgr();
		while (true){
			Student s = new Student(i,"student" + i);
//			System.out.println("entering student " + s.getName());
			cache.addToCache(s);
//			System.out.println("cache size is " + cache.getCacheSize());
			LogMgr.getInstance().printLog();
			i++;
		}

	}

}
