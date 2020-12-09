package TP2;


public class MotsCroises {

	//Variables d'instance
	private Grille<Character> solution;
	private Grille<Character> joueur;
	private Grille<String> horizontal;
	private Grille<String> vertical;
	private int hauteur;
	private int largeur;
	
	//Constructeur créant une instance de MotsCroises dotée de 4 instances de Grille suivant les spécifs données ci dessous
	public MotsCroises (int h, int l) {
		assert (h>=0 & l >=0);
		solution=new Grille<Character> (h,l);
		joueur=new Grille<Character>(h,l);
		horizontal=new Grille<String>(h,l);
		vertical=new Grille<String>(h,l);	
		this.hauteur=h;
		this.largeur=l;
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
	
	//Accesseurs aux cases noires
	//preconditions (assert) : coordCorrectes (lig, col)
	public boolean estCaseNoire(int lig, int col) {
		assert (coordCorrectes(lig,col));
		if (solution.getCellule(lig, col)==null) {return true;}
		else {return false;}
	}
	
	public void setCasesNoire(int lig, int col, boolean noire) {
		assert (coordCorrectes(lig,col));
		if (noire) {
			solution.setCellule(lig, col, null);
			joueur.setCellule(lig, col, null);
			}
		else {
			solution.setCellule(lig, col, ' ');
			joueur.setCellule(lig, col, ' ');
			}
	}
	
	
	//Accesseurs à la grille de solution
	//preconditions (assert): coordCorrectes (lig, col) et !estCaseNoire(lig,col)
	public char getSolution(int lig, int col) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		return (solution.getCellule(lig, col));
	}

	public void setSolution(int lig, int col, char sol) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		//String s=String.valueOf(sol);
		solution.setCellule(lig, col, sol);
	}
	
	//Accesseurs à la grille du joueur
	//preconditions (assert): coordCorrectes (lig, col) et !estCaseNoire(lig,col)
	public char getProposition(int lig, int col) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		return (joueur.getCellule(lig,col));
		
	}

	public void setProposition(int lig, int col, char prop) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		//String p=String.valueOf(prop);
		joueur.setCellule(lig, col, prop);
	}
	
	//Accesseurs aux definitions
	//Le parametre "horiz" est true pour les definitions horizontales, "false" pour les definitions verticales
	//preconditions (assert): coordCorrectes (lig, col) et !estCaseNoire(lig,col)
	public String getDefinition (int lig, int col, boolean horiz) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		if (horiz) {return horizontal.getCellule(lig, col);}
		else /*(horiz==false)*/ {return vertical.getCellule(lig, col);}
		
	}

	public void setDefinition(int lig, int col, boolean horiz, String def) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		if (horiz) {
			//int i=col;
			//while (!(estCaseNoire(lig,i) || i==largeur))
				//{
				horizontal.setCellule(lig,col,def);
				//i=i+1;
				}
		//}
		else 
			//if (!horiz) 
			{
			//int j=lig;
			//while(!(estCaseNoire(j,col) || j==hauteur))
			//{
				vertical.setCellule(lig,col,def);
				//j=j+1;
			}
		//}
		//else /*pas de définition*/ {
			//horizontal.setCellule(lig, col, ' ');
			//vertical.setCellule(lig, col, ' ');
		}
	}
//les 4 instances de la classe Grille permettent de gerer
	//la grille solution
	//la grille remplie par le joueur
	//la grille de definition des mots horiz
	//la grille de definition des mots verticaux
