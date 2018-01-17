public class GraphImpl implements Graph{

	public void closeResource(){
	   // here I can close the file	
	}

public static void main(String[] args) {
		GraphPool g = new GraphPool();
		for (int i = 0;i < 10;i++){
			g.allocateGraph(g);
		}
	}
}