package tp2bis;

import TP2.Grille;

public class NonUtilisesMotsCroises {

	@SuppressWarnings("unused")
	private MotsCroises tab ;
	private int hauteur;
	private int largeur;
	private char solution;
	private char proposition;
	private String horiz;
	private String vert;
	private boolean noire;
	private Case cases;
	
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
	public NonUtilisesMotsCroises (int h, int l, char sol, char prop, String hor, String ver, boolean noire) {
		//super(h,l);
		assert (h>=0 & l >=0);
		tab= new MotsCroises(h,l);
		cases= new Case (sol, prop,hor,ver, noire);
		this.largeur=l;
		this.hauteur=h;
		this.proposition=prop;
		this.solution=sol;
		this.horiz=hor;
		this.vert=ver;
		this.noire=noire;
	}
	
	public int getHauteur() {
		return hauteur;
	}
	
	public int getLargeur() {
		return largeur;
	}
	
	public char getSolution() {
		return solution;
	}
	
	public char getProposition() {
		return proposition;
	}
	
	public String getHoriz() {
		return horiz;
	}
	
	public String getVertical() {
		return vert;
	}
	
	public boolean getNoire() {
		return noire;
	}
	
	public boolean coordCorrectes(int lig, int col) {
		return (lig>0) & (lig<=hauteur) & (col>0) & (col<=largeur);
	}
	
	public boolean estCaseNoire(int lig, int col) {
		assert (coordCorrectes(lig,col));
		if (cases.isNoire()) {return true;}
		else {return false;}
	}
	
	public void setCasesNoire(int lig, int col, boolean noire) {
		assert (coordCorrectes(lig,col));
		if (noire) 
			{
			cases.setSolution(' ');
			cases.setProposition(' ');
			cases.setHoriz(null);
			cases.setVertical(null);
			}
	}
	
	public char getSolution(int lig, int col) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		return (cases.getSolution());
	}	
	
	public void setSolution(int lig, int col, Character sol) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		cases.setSolution(sol);
	}
	
	public char getProposition(int lig, int col) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		return (cases.getProposition());	
	}
	
	public void setProposition(int lig, int col, Character prop) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		//String p=String.valueOf(prop);
		cases.setProposition(prop);
	}
	
	public String getDefinition (int lig, int col, boolean horiz) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		if (horiz) {return cases.getHoriz();}
		else /*(horiz==false)*/ {return cases.getVertical();}
	}
	
	public void setDefinition(int lig, int col, boolean horiz, String def) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		if (horiz) {
			cases.setHoriz(def);
				}
		else 
			{
			cases.setVertical(def);
			}
		}
}
