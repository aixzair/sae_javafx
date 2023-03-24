package src.fr.but.info.sae122;

import java.util.ArrayList;
import java.util.Iterator;

public class BreadthFirstIterator implements Iterator<Edge> {
	private Graph graph;
	private String currentNode;
	private ArrayList<String> nodesMet;
	private Iterator<Edge> itrArr;
	private int index;

	public BreadthFirstIterator(Graph graph, String firstNode) {
		this.graph = graph;
		this.currentNode = firstNode;
		this.index = 0;
		//itrArr = this.graph.
		nodesMet.add(firstNode);
		update();
		//throw new UnsupportedOperationException("To be written");
	}

	public void update()
	{
		ArrayList<Edge> al = (ArrayList<Edge>)this.graph.getEdgesFrom(this.currentNode);
		for(int i = 0; i < al.size(); i++)
		{
			if(!nodesMet.contains(al.get(i).getFromNode()))
			{
				this.nodesMet.add(al.get(i).getFromNode());
			}
		}
	}

	@Override
	public boolean hasNext() {
		itrArr = this.graph.getEdgesFrom(this.currentNode).iterator();
		return itrArr.hasNext(); 
	}

	@Override
	public Edge next() {

		itrArr = this.graph.getEdgesFrom(this.currentNode).iterator();
			
		while(!this.hasNext())
		{
			this.currentNode = this.nodesMet.get(index);
			update();
			index +=1;
			itrArr = this.graph.getEdgesFrom(this.currentNode).iterator();
		}
		this.itrArr.remove();
		return this.itrArr.next();
	}
}
