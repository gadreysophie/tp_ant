package TP2;


public class Grille<T> {
//variables d'instance
	private int largeur;
	private int hauteur;
	private T [] [] table;
	
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
	
	//hauteur = nombre de lignes
	//largeur = nombre de colonnes
	// tab = tableau de chaînes de caractères à deux dimensions avec taille = hauteur x largeur
	
	// Constructeur permettant d'obtenir une grille dotée d'un tableau de dimensions conformes aux valeurs
	// respectives de hauteur et de largeur, dont tous les éléments contiennent la valeur null
	// préconditions (assert) hauteur >=0 et largeur >=0
	
	@SuppressWarnings("unchecked")
	public Grille (int h, int l) {
		assert (h>=0 & l >=0);
		table= (T [][]) new Object [h][l]; //cast (transtypage)
		this.hauteur=h;
		this.largeur=l;
	}
	
	//Accesseurs (getters)
	public int getHauteur() {
		return hauteur;
	}
	public int getLargeur() {
		return largeur;
	}
	
	//Validité des coordonnées
	//Resultat : vrai ssi ligne (respectivement colonne) est compris entre 1 et getHauteur()(respectivement getLargeur())
	public boolean coordCorrectes (int lig, int col) {
		return (lig>0) & (lig<=hauteur) & (col>0) & (col<=largeur);
	}
	
	//Valeur de la cellule ayant pour coordonnées (lig, col)
	//precondition (assert) : coordCorrectes (lig, col)
	public T getCellule(int lig, int col) {
		assert(coordCorrectes(lig,col));
		return table[lig-1][col-1];
	}
	
	//Modification de la cellule de coordonnées (lig,col)
	//precondition (assert) : coordCorrectes (lig, col)
	public void setCellule(int lig, int col, T ch) {
		assert(coordCorrectes(lig,col));
		 table[lig-1][col-1]=(T) ch;
	}
	
	//Texte sur "hauteur" lignes, colonnes séparées par des |
	public String toString () {
		String result="";
		for (int i=0; i<hauteur; i++) 
		{
			for (int j=0;j<largeur; j++) 
				{
				result=result+"|"+table[i][j]+"|"+"\r"+"\n";
				}
		}	
		return result;
	}	
}