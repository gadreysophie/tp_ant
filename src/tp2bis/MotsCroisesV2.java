package tp2bis;

import TP2.Grille;

public class MotsCroisesV2 {

	private Grille<Case> tab ;
	private int hauteur;
	private int largeur;
	//private char solution;
	//private char proposition;
	//private String horiz;
	//private String vert;
	//private boolean noire;
	//private Case cases;

	public static void main (String[] args) {
		Grille<String> maGrille = new Grille<String>(3,5);
		for (int l=1;l<=maGrille.getHauteur();l++)
		{
			String texteligne = Integer.toString(l);
			for(int c=1; c<=maGrille.getLargeur();c++)
			{
				maGrille.setCellule(l, c, texteligne+','+Integer.toString(c));
			}
		}
		System.out.println(maGrille);
	}
	
	//constructeur
	public MotsCroisesV2 (int h, int l) {
		assert (h>=0 & l >=0);
		tab= new Grille<Case> (h,l);
		this.largeur=l;
		this.hauteur=h;
	}
	
	//Nombre de rangées (ligne)
	public int getHauteur() {
		return hauteur;
	}
	
	//Nombre de colonnes
	public int getLargeur() {
		return largeur;
	}
	
	//Validité des coordonnées
	//Resultat : vrai ssi (lig,col) designent une cellule existance de la grille
	public boolean coordCorrectes(int lig, int col) {
		return (lig>0) & (lig<=hauteur) & (col>0) & (col<=largeur);
	}
	
	public boolean estCaseNoire(int lig, int col) {
		assert (coordCorrectes(lig,col));
		if (tab.getCellule(lig, col).isNoire()) {return true;}
		else {return false;}
	}
	
	public void setCasesNoire(int lig, int col, boolean noire) {
		assert (coordCorrectes(lig,col));
		if (noire) 
			{
			//tab.setCellule(lig, col, null);
			tab.getCellule(lig, col).setNoire(true);
			}
		else {
			//tab.setCellule(lig, col, cases);
			tab.getCellule(lig,col).setNoire(false);
		}
	}
	
	public char getSolution(int lig, int col) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		return (tab.getCellule(lig, col).getSolution());
	}	
	
	public void setSolution(int lig, int col, Character sol) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		//tab.setCellule(lig, col, cases);
		tab.getCellule(lig, col).setSolution(sol);
	}
	
	public char getProposition(int lig, int col) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		return (tab.getCellule(lig, col).getProposition());	
	}
	
	public void setProposition(int lig, int col, Character prop) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		//tab.setCellule(lig, col, cases);
		tab.getCellule(lig, col).setProposition(prop);
	}
	
	public String getDefinition (int lig, int col, boolean horiz) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		if (horiz) {return tab.getCellule(lig, col).getHoriz();}
		else /*(horiz==false)*/ {return tab.getCellule(lig, col).getVertical();}
	}
	
	public void setDefinition(int lig, int col, boolean horiz, String def) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		if (horiz) {
			//tab.setCellule(lig, col, cases);
			tab.getCellule(lig, col).setHoriz(def);
				}
		else 
			{
			//tab.setCellule(lig, col, cases);
			tab.getCellule(lig, col).setVertical(def);
			}
		}
}
