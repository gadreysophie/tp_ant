package Utilitaires;
import java.io.*;

//quelques primitives de lecture au clavier ou dans un fichier 

public class Lecture {   
    public static InputStream ouvrir(String nomFich) {
	//d�livre un pointeur sur le fichier de nom nomFich (null si erreur)
	InputStream f;
	try {f=new DataInputStream(new FileInputStream(nomFich));}
	catch (IOException e) {f=null;}
	return f;
    }

    public static boolean finFichier(InputStream f) {
	//d�termine si la fin de fichier est atteinte
	try {return (f!=System.in && f.available()==0);}
        catch(IOException e) {System.out.println("pb test finFichier");
	                      System.exit(1);
	}
	return true;
    }

    public static void fermer(InputStream f) {
	//ferme un fichier (affiche un message si probleme)           
	try {f.close();}
	catch (IOException e) {System.out.println("pb fermeture fichier");}
    }


    //lecture d'un octet dans la cha�ne d'entr�e (avec capture de l'exception)

    public static char lireChar(InputStream f) {
	char carSuiv=' ';
        try {int x=f.read();
	     if (x==-1) {System.out.println("lecture apr�s fin de fichier");
	                 System.exit(2);}
	     carSuiv=(char)x;
	}
        catch(IOException e) {
	    System.out.println(e.getMessage());
	    System.out.println("Erreur fatale");System.exit(3);
        }
        return carSuiv;
    }

    public static char lireChar() {return lireChar(System.in);}


    //lecture d'une cha�ne termin�e par un line feed (pr�c�d� ou non de \r)*/

    public static String lireString(InputStream f) {
        String chainelue="";char carSuiv=lireChar(f);
	while (carSuiv != '\n') {
	    if (carSuiv != '\r') chainelue=chainelue+carSuiv;
            carSuiv=(finFichier(f)) ? '\n' : lireChar(f);
	}
	return chainelue;
    }

    public static String lireString() {return lireString(System.in);}

    //lecture d'un entier �ventuellement pr�c�d� par des blancs et suivi 
    //d'un blanc, le reste de la ligne est ignor�(suffixe ln) ou non(pas 
    //de suffixe ln)

    public static int lireInt(InputStream f) 
                              throws NumberFormatException {
        return Integer.valueOf(lireUnite(f,false)).intValue();
    }

    public static int lireInt() throws NumberFormatException {
	return lireInt(System.in);
    }
    
    public static int lireIntln(InputStream f) 
                                throws NumberFormatException {
        return Integer.valueOf(lireUnite(f,true)).intValue();
    }

    public static int lireIntln() throws NumberFormatException {
	return lireIntln(System.in);
    }

    //lecture d'un double �ventuellement pr�c�d� par des blancs et suivi 
    //d'un blanc, le reste de la ligne est ignor�(suffixe ln) ou non(pas 
    //de suffixe ln)

    public static double lireDouble(InputStream f) 
                                    throws NumberFormatException {
        return Double.valueOf(lireUnite(f,false)).doubleValue();
    }

    public static double lireDouble() throws NumberFormatException {
	return lireDouble(System.in);
    }

    public static double lireDoubleln(InputStream f) 
                                      throws NumberFormatException {
        return Double.valueOf(lireUnite(f,true)).doubleValue();
    }

    public static double lireDoubleln() throws NumberFormatException {
	return lireDoubleln(System.in);
    }

    //lecture d'une unit� : s�quence encadr�e par des blancs, le reste
    //de la ligne est �ventuellement ignor� (bool�en alaligne)

    public static String lireUnite(InputStream f,boolean alaligne){
        String unite = "";char carlu=lireChar(f);
              // on avale les blancs de debut 
        while (Character.isWhitespace(carlu)) carlu= lireChar(f);
             // puis on agglomere jusqu'a trouver un blanc
        while (!(Character.isWhitespace(carlu))) {
	    unite=unite+carlu;
	    carlu=(finFichier(f)) ? '\n' : lireChar(f);
	}
	if (carlu=='\r') carlu=lireChar(f);
	if (alaligne) 
	    while ((!finFichier(f)) && (carlu!='\n')) carlu=lireChar(f); 
        return unite;
    }

    public static String lireUnite(boolean alaligne) {
	return lireUnite(System.in,alaligne);
    }

}//class Lecture

