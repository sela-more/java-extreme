import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.IdentityHashMap;

public class GraphPool {

	private ReferenceQueue<PooledGraph> _refQueue = new ReferenceQueue<PooledGraph>();
	private IdentityHashMap<Reference<PooledGraph>,GraphImpl> ref2Graph 
    = new IdentityHashMap<Reference<PooledGraph>,GraphImpl>();

private IdentityHashMap<GraphImpl,Reference<PooledGraph>> graph2Ref = 
    new IdentityHashMap<GraphImpl,Reference<PooledGraph>>();

	private int graphCounter = 5;
	public Graph getGraph(PooledGraph p) {
		while (true){
			if (graphCounter > 0){
				return getGraphFromDB(p);
			}else{
				try{
					Reference<PooledGraph> ref =
                    (Reference<PooledGraph>) _refQueue.remove(100);
                if (ref != null){
                    deleteGraph(ref);
                }else{
                	System.gc();
                }
            }
            catch (InterruptedException ignored)
            {
                // this could be used to shut down pool
            }}
	}
}
private void deleteGraph(Reference<PooledGraph> ref) {
	deleteGraph(ref2Graph.get(ref));

}

private void deleteGraph(GraphImpl graph) {
	Reference<PooledGraph> ref = graph2Ref.remove(graph);
	ref2Graph.remove(ref);
	graph.closeResource();
	graphCounter++;
	System.out.println("graph was deleted");
}
private Graph getGraphFromDB(PooledGraph p) {
	// take a real graph from the DB
	graphCounter--;
	GraphImpl g = new GraphImpl();
	PhantomReference<PooledGraph> ref =
	new PhantomReference<PooledGraph>(p, _refQueue);
	ref2Graph.put(ref, g);
	graph2Ref.put(g, ref);
	System.out.println("create new graph " + graphCounter);
	return g;
}
public static void allocateGraph(GraphPool g) {
	PooledGraph p = new PooledGraph(g);
	p.getGraph();
}
}

