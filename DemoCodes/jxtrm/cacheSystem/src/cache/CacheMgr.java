package cache;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class CacheMgr {

	private Map<String, SoftReference<CacheObject>> cache;
	private ReferenceQueue<CacheObject> refQ;
	
	public CacheMgr() {
		cache = new HashMap<String, SoftReference<CacheObject>>();
		this.refQ = new ReferenceQueue<CacheObject>();
	}

	public void addToCache(Cacheable c){
		CacheObject obj = new CacheObject(c);
		cache.put(obj.getName(), new SoftReference<CacheObject>(obj));
		LogMgr.getInstance().log(new LogObject("enter to the cache", c));
		PhantomReference<CacheObject> phantom = new PhantomReference<CacheObject>(obj, refQ);
	}
	
	public int getCacheSize(){
		return cache.size();
	}
	
	public Cacheable getFromCache(String name){
		return cache.get(name).get().getCachedObject();
	}

	private class CacheObject implements Cacheable{

		Cacheable c;
		public Cacheable getCachedObject() {
			return c;
		}
		public CacheObject(Cacheable c) {
			super();
			this.c = c;
		}
		@Override
		public boolean equals(Object arg0) {
			return c.equals(arg0);
		}
		@Override
		protected void finalize() throws Throwable {
			cache.remove(getName());
			System.out.println("remove from cache " + this);
			LogMgr.getInstance().log(new LogObject("remove from the cache", c));
			super.finalize();
		}
		@Override
		public int hashCode() {
			return c.hashCode();
		}
		@Override
		public String toString() {
			return c.toString();
		}
		@Override
		public String getName() {
			return c.getName();
		}

	}

}
