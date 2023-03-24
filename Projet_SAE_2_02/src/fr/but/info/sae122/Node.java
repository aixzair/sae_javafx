package fr.but.info.sae122;

public class Node {
	
	private String name;
	private Node voisin;
	
	public Node(String nm) {
		
		this.name=nm;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Node getvoisin() {
		return this.voisin;
	}
	
	public void setVoisin(Node noeud){
		this.voisin=noeud;
		
	}
}
