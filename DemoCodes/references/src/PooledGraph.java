public class PooledGraph implements Graph{

	private GraphImpl theGraph;
	private GraphPool pool;
	
	public PooledGraph(GraphPool p){
		pool = p;
	}
	
	public GraphImpl getGraph(){
		if (theGraph == null){
			theGraph = (GraphImpl) pool.getGraph(this);
		}
		return theGraph;
	}
}