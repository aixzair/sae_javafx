package fr.but.info.sae122;

import java.util.ArrayList;
import java.util.Iterator;

public class BreadthFirstIterator implements Iterator<Edge> {
	private Graph graph;
	private String currentNode;
	private ArrayList<String> noeudsRencontres;
	private Iterator<Edge> itrArr;
	private Iterator<Edge> itrNodes;
	private int index;

	public BreadthFirstIterator(Graph graph, String firstNode) {
		this.graph = graph;
		this.currentNode = firstNode;
		this.index = 0;
		itrArr = this.graph.
		update();
		//throw new UnsupportedOperationException("To be written");
	}

	public void update()
	{
		for(int i = 0; i < this.graph.getEdgesFrom(this.currentNode).size(); i++)
		{
			//ajouter à la file toutes les arrêtes partant de ce noeud
			if(!noeudsRencontres.contains(this.graph.getEdgesFrom(this.currentNode).get(i).getFromNode()))
			{
				this.noeudsRencontres.add(this.graph.getEdgesFrom(this.currentNode).get(i).getFromNode());
			}
			
		}
	}

	@Override
	public boolean hasNext() {
		return this.itrArr.hasNext(); 
		//return graph.getEdgesFrom(this.currentNode).size() != 0;
	}

	@Override
	public Edge next() {
		if(this.hasNext())
		{
			this.itrArr.remove();
			return this.itrArr.next();
		}
		else
		{
			while(this.noeudsRencontres.size()< (index))
			{
				index +=1;
				this.currentNode = this.noeudsRencontres.get(index);
				update();
				//if(this.hasNext())
			}
		}

		throw new UnsupportedOperationException("To be written");
	}
}
