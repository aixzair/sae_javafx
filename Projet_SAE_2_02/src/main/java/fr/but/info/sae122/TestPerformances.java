package fr.but.info.sae122;

import java.util.Collection;

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
	 * 
	 * @param args
	 * sert à appeler les fonctions
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		nbNoeudsFull(2);
		nbNoeudsLin(2);
		System.out.println(nbAretes(3,3));

		
		
	}

}
