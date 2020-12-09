package tp2bis;

public class Case {
	private Character solution, proposition;
	private String horiz, vertical;
	private boolean noire;
	
	
	//Constructeur
	public Case (Character sol, Character prop, String hor, String ver, boolean noire) {
		this.solution=sol;
		this.proposition=prop;
		this.horiz=hor;
		this.vertical=ver;
		this.noire=noire;
	}


	/**
	 * @return the solution
	 */
	public Character getSolution() {
		return solution;
	}


	/**
	 * @param solution the solution to set
	 */
	public void setSolution(Character solution) {
		this.solution = solution;
	}


	/**
	 * @return the proposition
	 */
	public Character getProposition() {
		return proposition;
	}


	/**
	 * @param proposition the proposition to set
	 */
	public void setProposition(Character proposition) {
		this.proposition = proposition;
	}


	/**
	 * @return the horiz
	 */
	public String getHoriz() {
		return horiz;
	}


	/**
	 * @param horiz the horiz to set
	 */
	public void setHoriz(String horiz) {
		this.horiz = horiz;
	}


	/**
	 * @return the vertical
	 */
	public String getVertical() {
		return vertical;
	}


	/**
	 * @param vertical the vertical to set
	 */
	public void setVertical(String vertical) {
		this.vertical = vertical;
	}


	/**
	 * @return the noire
	 */
	public boolean isNoire() {
		return noire;
	}


	/**
	 * @param noire the noire to set
	 */
	public void setNoire(boolean noire) {
		this.noire = noire;
	}
	public String toString () {
		String result="";
		String sol=String.valueOf(this.solution);
		String prop=String.valueOf(this.proposition);
		result="La définition vertical est"+this.vertical+"/n"+"La définition horizontale est"+this.horiz+"La solution est"+sol+"La proposition est"+prop+"La case est"+this.noire;
		return result;
	}

}
