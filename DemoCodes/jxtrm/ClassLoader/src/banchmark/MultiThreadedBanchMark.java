package banchmark;

public class MultiThreadedBanchMark implements Runnable {

	private BanchMarker bm;
	private String className;
	@Override
	public void run() {
		try {
			bm.doBanchmarking(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}
	public MultiThreadedBanchMark(BanchMarker bm, String className) {
		super();
		this.bm = bm;
		this.className = className;
	}

}
