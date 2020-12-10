

public class MotsCroises {

	//Variables d'instance
	Grille solution;
	Grille joueur;
	Grille horizontal;
	Grille vertical;
	private int hauteur;
	private int largeur;
	
	//Constructeur creant une instance de MotsCroises dotee de 4 instances de Grille suivant les specifs donnees ci dessous
	public MotsCroises (int h, int l) {
		assert (h>=0 & l >=0);
		solution=new Grille (h,l);
		joueur=new Grille(h,l);
		horizontal=new Grille(h,l);
		vertical=new Grille(h,l);	
		this.hauteur=h;
		this.largeur=l;
	}
	
	//Nombre de rangees (ligne)
	public int getHauteur() {
		return hauteur;
	}
	
	//Nombre de colonnes
	public int getLargeur() {
		return largeur;
	}
	
	//Validite des coordonnees
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
			solution.setCellule(lig, col, "");
			joueur.setCellule(lig, col, "");
			}
	}
	
	
	//Accesseurs a la grille de solution
	//preconditions (assert): coordCorrectes (lig, col) et !estCaseNoire(lig,col)
	public char getSolution(int lig, int col) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		return solution.getCellule(lig, col).charAt(0);
	}
	public void setSolution(int lig, int col, char sol) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		String s=String.valueOf(sol);
		solution.setCellule(lig, col, s);
	}
	
	//Accesseurs a la grille du joueur
	//preconditions (assert): coordCorrectes (lig, col) et !estCaseNoire(lig,col)
	public char getProposition(int lig, int col) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		return joueur.getCellule(lig,col).charAt(0);
		
	}
	public void setProposition(int lig, int col, char prop) {
		assert(coordCorrectes(lig,col));
		assert(!estCaseNoire(lig,col));
		String p=String.valueOf(prop);
		joueur.setCellule(lig, col, p);
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
			int i=col;
			//while (!(estCaseNoire(lig,i) || i==largeur))
				//{
				horizontal.setCellule(lig,i,def);
				//i=i+1;
				}
		//}
		else if (!horiz) {
			int j=lig;
			//while(!(estCaseNoire(j,col) || j==hauteur))
			//{
				vertical.setCellule(j,col,def);
				//j=j+1;
			}
		//}
		else /*pas de definition*/ {
			horizontal.setCellule(lig, col, "");
			vertical.setCellule(lig, col, "");
		}
	}
}	
//les 4 instances de la classe Grille permettent de gerer
	//la grille solution
	//la grille remplie par le joueur
	//la grille de definition des mots horiz
	//la grille de definition des mots verticaux
