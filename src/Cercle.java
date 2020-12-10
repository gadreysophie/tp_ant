public class Cercle
{
	double xCentre, yCentre, rayon ;
	
	public final static double PI = 3.14159 ;
	
	public Cercle (double xCentre, double yCentre, double rayon)
	{
		this.xCentre = xCentre ;
		this.yCentre = yCentre ;
		this.setRayon(rayon) ;
	}
	
	public double getXCentre() { return xCentre ; }
	public double getYCentre() { return yCentre ; }
	public double getRayon() { return rayon ; }
	
	public void setRayon(double rayon)
	{
		if (rayon >= 0.0)
		{
			this.rayon = rayon ;
		}
		else
		{
			throw new IllegalArgumentException("Le rayon ne peut etre negatif : " + rayon) ;
		}
	}
	
	public boolean equals(Cercle autre)
	{
		return
			this.xCentre == autre.xCentre
			&& this.yCentre == autre.yCentre
			&& this.rayon == autre.rayon ;
	}
	
	public double calculPerimetre()
	{
		return 2*PI*rayon ;
	}
	
	public static void main (String[] args)
	{
		Cercle c1 = null ;
		Cercle c2 = null ;
		/* 1 */ System.out.println("ligne 1 :" + (c1==c2)) ;
		
		/* 2 */ c1 = new Cercle(0, 0, 22) ;		
		/* 3 */ System.out.println("ligne 3 :" + (c1==c2)) ;
		///* 4 */ System.out.println("ligne 4 :" + c1.equals(c2)) ;
		
		/* 5 */ c2 = new Cercle(0, 0, 22) ;
		/* 6 */ System.out.println("ligne 6 :" + (c1==c2)) ;
		/* 7 */ System.out.println("ligne 7 :" + c1.equals(c2)) ;
		
		/* 8 */  Cercle c3 = c2 ;
		/* 9 */  System.out.println("ligne 9  :" + (c2==c3)) ;
		/* 10 */ System.out.println("ligne 10 :" + c2.equals(c3)) ;
		/* 11 */ System.out.println("ligne 11 :" + (c2==c1)) ;
		/* 12 */ System.out.println("ligne 12 :" + c2.equals(c1)) ;
		
		/* 13 */ c2.setRayon(55);
		/* 14 */ System.out.println("ligne 14 :" + (c2==c3)) ;
		/* 15 */ System.out.println("ligne 15 :" + c2.equals(c3)) ;
		/* 16 */ System.out.println("ligne 16 :" + (c2==c1)) ;
		/* 17 */ System.out.println("ligne 17 :" + c2.equals(c1)) ;
		
		/* 18 */ c1.rayon = 5 ;
		/* 19 */ System.out.println("ligne 19 :" + c1.calculPerimetre()) ;
		/* 20 */ c1.rayon = -5 ;
		/* 21 */ System.out.println("ligne 21 :" + c1.calculPerimetre()) ;
		/* 22 */ c1.setRayon(-5) ;
		/* 23 */ System.out.println("ligne 23 :" + c1.calculPerimetre()) ;
		
	}
}
