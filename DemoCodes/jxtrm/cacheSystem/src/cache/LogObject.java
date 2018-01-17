package cache;

import java.lang.ref.WeakReference;

public class LogObject {

	
	public LogObject(String message, Cacheable c) {
		super();
		this.message = message;
		obj = new WeakReference<Cacheable>(c);
	}

	
	public String getMessage() {
		return message;
	}
	
	public String toString(){
		String text = getMessage();
		if (getObj() != null){
			text += " " + getObj();
		}
		return text;
	}
	
	public Cacheable getObj() {
		if (obj.get() != null){
			return obj.get();
		}
		return null;
	}
	private String message;
	private WeakReference<Cacheable> obj;
}
