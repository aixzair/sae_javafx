package main.java.fr.but.info.sae122;

import java.util.Collection;
import java.util.Random;

public class TestPerformances {

	/**méthode test pour évaluer les performances de génération de graphes totalement connectés en fonction du nombre de noeuds
	 * et cacule le temps d'execution.
	 * @param nbNoeuds(le nombre de noeud à générer
	 * Génère 10 graphes totalement connectés et affiche leur temps d'éxecution
	 */
	
	public static void nbNoeudsFull(int nbNoeuds) {
		long tps = System.currentTimeMillis();
		Graph graphe = new Graph();
		
		for(int i=0;i<10;i++) {
			graphe=GraphGenerator.createLinear(nbNoeuds);
			long tps2 = System.currentTimeMillis();
			System.out.print("Graph");
			System.out.print(i);
			System.out.print(" ");
			System.out.println(tps2-tps);	
		}
	}
	
	
	/**méthode test pour évaluer les performances de génération de graphes linéaires en fonction du nombre de noeuds
	 * et cacule le temps d'execution.
	 * @param nbNoeuds(le nombre de noeud à générer
	 * Génère 10 graphes linéaires et affiche leur temps d'éxecution
	 */
	
	public static void nbNoeudsLin(int nbNoeuds) {
		long tps = System.currentTimeMillis();
		Graph graphe = new Graph();
		
		for(int i=0;i<10;i++) {
			graphe=GraphGenerator.createLinear(nbNoeuds);
			long tps2 = System.currentTimeMillis();
			System.out.print("Graph");
			System.out.print(i);
			System.out.print(" ");
			System.out.println(tps2-tps);	
		}
	}
	
	/**
	 * 
	 * @param nAretes nombre d'arêtes à ajouter à un arbre linéaire 
	 * @param nbNoeudDepart nombre à partir duquel on commence à ajouter les noeuds/arêtes
	 * ce noeud de départ est transformé en noeud et sert à relier les anciens noeuds aux nouveaux
	 * @return le graphe final avec tous les noeuds et toutes les arêtes que celui-ci contient
	 */
	
	public static Graph nbAretes(int nAretes,int nbNoeudDepart) {
		
		Graph graphe = new Graph();
		graphe=GraphGenerator.createLinear(nbNoeudDepart);
		graphe.addNode("N"+nbNoeudDepart);
		String noeudSuivant="N"+0 + (int)(Math.random() * ((10 - 0) + 1) );
		graphe.addNode(noeudSuivant);
		int temp = nbNoeudDepart-1;
		graphe.addEdge("N"+temp,"N"+nbNoeudDepart,0 + (int)(Math.random() * ((10 - 0) + 1) ) );
		graphe.addEdge("N"+nbNoeudDepart, noeudSuivant,0 + (int)(Math.random() * ((10 - 0) + 1) ) );
		
		for (int i=0;i<nAretes;i++) {
			int nbAleatoire = 2 + (int)(Math.random() * ((50 - 2) + 1));
			String noeudAleatoire="N"+nbAleatoire;
			while (graphe.getNodes().contains(noeudAleatoire)) {
				 nbAleatoire = 2 + (int)(Math.random() * ((50 - 2) + 1));
			}
			graphe.addNode(noeudAleatoire);
			graphe.addEdge(noeudSuivant, noeudAleatoire,0 + (int)(Math.random() * ((10 - 0) + 1) ));
			noeudSuivant=noeudAleatoire;
		}
		return graphe;
	}

	/**
	 * Calcul le temps necessaire pour calculer le flot selon le type de graph
	 * @param size le nombre de noeud dans le graph
	 * @param type le type de graph
	 * @return le temps necessaire pour calculer le flot*/

	public static long nbNodePerf(int size, String type){
		Graph g = new Graph();
		switch (type.toLowerCase()){
			case "linear" -> g = GraphGenerator.createLinear(size);
			case "full" -> g = GraphGenerator.createFull(size);
		}
		long deb = 0, end = 0;
		MaxFlow maxFlow = new MaxFlow(g, g.nodes.get(0), g.nodes.get(g.nodes.size() - 1));
		deb = System.currentTimeMillis();
		maxFlow.computeMaxFlow();
		end = System.currentTimeMillis();
		return end-deb;
	}


	/**
	 * Calcul le temps necessaire pour calculer le flot selon le type de graph et le nombre d'arete à ajouter
	 * @param size le nombre de noeud de base dans le graph
	 * @param nbArreteEnPlus le nombre de noeud a ajouter
	 * @return le temps necessaire pour calculer le flot*/
	public static long nbArretePerf(int size, int nbArreteEnPlus){
		Graph g = GraphGenerator.createLinear(size);
		Random r = new Random();
		long deb = 0, end = 0;
		deb = System.currentTimeMillis();
		for(int i = 0; i<nbArreteEnPlus; i++){
			int n = g.nodes.size() + i;
			String nodes = "N" + n;
			g.addNode(nodes);
			if(i == 0) g.addEdge(g.nodes.get(g.nodes.size() - 2), nodes, r.nextInt(10)+1);
			else g.addEdge(g.nodes.get(g.nodes.size() - 2), nodes, r.nextInt(10)+1);
		}
		MaxFlow maxFlow = new MaxFlow(g, g.nodes.get(0), g.nodes.get(g.nodes.size() - 1));
		maxFlow.computeMaxFlow();
		end = System.currentTimeMillis();
		return end-deb;
	}

	/**
	 * 
	 * @param args
	 * sert à appeler les fonctions
	 */
	public static void main(String[] args) {
		/*nbNoeudsFull(2);
		nbNoeudsLin(2);
		System.out.println(nbAretes(3,3));*/

		for (int i = 0; i < 10; i++) {
			System.out.println(nbArretePerf(1000, 1000));
		}

		
	}

}
