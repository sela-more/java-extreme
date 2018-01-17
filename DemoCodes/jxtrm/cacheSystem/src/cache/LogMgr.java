package cache;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LogMgr {

	private static LogMgr theInstance = new LogMgr();
	
	private LogMgr(){
		logger = new LinkedList<LogObject>();
	}
	
	List<LogObject> logger;
	
	public Iterator<LogObject> getMessagesIterator(){
		return logger.iterator();
	}
	
	public static LogMgr getInstance() {
		return theInstance;
	}
	
	public synchronized void log(LogObject obj){
		logger.add(obj);
	}

	public synchronized void printLog() {
		for (Iterator<LogObject> iter = LogMgr.getInstance().getMessagesIterator();iter.hasNext();){
			/*System.out.println(*/iter.next()/*)*/;
		}

		
	}
}
