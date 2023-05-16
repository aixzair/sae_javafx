package fr.but.info.sae122;

public class Path {
	
	Edge[] edgeList;
	int flow;
	
	public Path() {
		
	}
	
	public Path(String[] nodes) {
		
		for(int i=0;i<nodes.length;i++) {
			edgeList[i]=new Edge(nodes[i],nodes[i+1],null);
		}
	}

	
	
}
