import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;


public class GrilleTest
{

	private Grille g1, g2 ;
	private int hauteur, largeur ;

	@Before
	public void setUp() throws Exception
	{
		hauteur = 333 ;
		largeur = 555 ;
		g1 = new Grille(hauteur, largeur) ;
		g2 = new Grille(hauteur+1, largeur+1) ;
		System.out.println("Test de " + g1.getClass().getName()) ;
	}

	@Test
	public void testHauteurLargeur()
	{
		assertEquals ("La hauteur est egale au 1er parametre du constructeur",
				hauteur, g1.getHauteur()) ;
		assertEquals ("La largeur est egale au 2e parametre du constructeur",
				largeur, g1.getLargeur()) ;
	}

	@Test
	public void testCellule()
	{
		try
		{for (int l=1; l<=g1.getHauteur(); l++)
			{
				String ch1 = Integer.toString(l);
				for (int c=1; c<=g1.getLargeur(); c++)
				{
					String ch2 = ch1 + ',' + Integer.toString(c) ;
					g1.setCellule(l, c, ch2) ;
					g2.setCellule(l, c, ch2 + "x");
					assertEquals("La valeur restituee doit etre la valeur enregistree",
										ch2, g1.getCellule(l, c)) ;
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			fail("L'indice de tableau ne doit pas depasser hauteur-1 (resp. largeur-1");
		}
	}

	@Test
	public void testPreconditions()
	{
		boolean testOK = false ;
		// Precondition de hauteur
		try
		{
			new Grille(-4, 5) ;
			testOK = false ;
		}
		catch (AssertionError e){ testOK = true ; }
		assertTrue("Une hauteur negative doit declencher une AssertionError", testOK) ;

		// Precondition de largeur
		try
		{
			new Grille(4, -5) ;
			testOK = false ;
		}
		catch (AssertionError e){ testOK = true ; }
		assertTrue("Une largeur negative doit declencher une AssertionError", testOK) ;

		// Precondition de 1ere coordonnee de cellule
		try
		{
			g1.setCellule(hauteur+1, 1, "hgjhgjhg");
			testOK = false ;
		}
		catch (AssertionError e){ testOK = true ; }
		assertTrue("Tout non-respect des bornes doit causer une AssertionError", testOK) ;

		// Precondition de 2eme coordonnee de cellule
		try
		{
			g1.setCellule(1, -1, "hgjhgjhg");
			testOK = false ;
		}
		catch (AssertionError e){ testOK = true ; }
		assertTrue("Tout non-respect des bornes doit causer une AssertionError", testOK) ;
	}
}
