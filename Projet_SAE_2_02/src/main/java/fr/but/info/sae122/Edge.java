package main.java.fr.but.info.sae122;


public final class Edge {

	String fromNode;
	String toNode;
	String label;
	
  public Edge(String fromNode,String toNode,String label) {
	  if(fromNode != toNode)
	  {
	    this.fromNode = fromNode;
	    this.toNode = toNode;
	    this.label = label;
	  }
	  else
	  {
		  //throw new UnsupportedOperationException("To be written");
		  
	  }
  }

  public String getFromNode() {
    //throw new UnsupportedOperationException("To be written");
    return this.fromNode;
  }

  public String getToNode() {
    //throw new UnsupportedOperationException("To be written");
    return this.toNode;
  }

  public String getLabel() {
    return this.label;
    //throw new UnsupportedOperationException("To be written");
  }

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Edge) {
    	return (this.fromNode == ((Edge) obj).getFromNode() && this.toNode == ((Edge) obj).getToNode() && this.label == ((Edge) obj).getLabel() );
    }
    else return false;
    //throw new UnsupportedOperationException("To be written");
  }

  @Override
  public int hashCode() {
    throw new UnsupportedOperationException("To be written");
  }
}
