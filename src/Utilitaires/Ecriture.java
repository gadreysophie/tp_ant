package Utilitaires;
import java.io.*;

//quelques primitives d'écriture à l'ecran  ou dans un fichier

public class Ecriture {   
    private static void erreur(IOException e) {
        System.out.println(e.getMessage());
	System.out.println("Erreur fatale");
	System.exit(1);
    }

    public static OutputStream ouvrir(String nomFich) {
	//délivre un pointeur sur le fichier de nom nomFich (null si erreur)
	OutputStream f;
	try {f=new DataOutputStream(new FileOutputStream(nomFich));
	}
	catch (IOException e) {f=null;}
	return f;
    }
     
    public static void fermer(OutputStream f) {
	//fermeture d'un fichier                                          
	try {f.close();}
	catch (IOException e) {erreur(e);}
    }

     

    //écriture d'un caractère                   

    public static void ecrireChar(OutputStream f,char c) {
	try {f.write(c);}
        catch(IOException e) {erreur(e);}
    }

    public static void ecrireChar(char c) {System.out.print(c);}



    //écriture d'une chaîne, avec éventuel passage à la ligne 
     
    public static void ecrireString(OutputStream f,String s) {
	try {for (int i=0;i<s.length();i++) f.write(s.charAt(i));}
        catch(IOException e) {erreur(e);}
    }

    public static void ecrireString(String s) {
	System.out.print(s);
    }

    public static void ecrireStringln(OutputStream f,String s) {
	ecrireString(f,s+"\r\n");
    }

    public static void ecrireStringln(String s) {
	System.out.println(s);
    }

    public static void ecrireStringln(OutputStream f) {
	ecrireString(f,"\r\n");
    }

    public static void ecrireStringln() {
	System.out.println();
    }

    //écriture d'un entier avec formatage éventuel 
    
    public static void ecrireInt(OutputStream f,int x) {
	ecrireString(f,Integer.toString(x));
    }

    public static void ecrireInt(int x) {System.out.print(x);}
    
    private static String chInt(int x,int longueur) {
	String s=Integer.toString(x),ch="";
	int k=longueur-s.length();
	for (int i=0;i<k;i++) ch+=' ';
	return ch+s;
    }

    public static void ecrireInt(OutputStream f,int x,int longueur) {
	ecrireString(f,chInt(x,longueur));
    }

    public static void ecrireInt(int x,int longueur) {
	System.out.print(chInt(x,longueur));
    }

                   
    //écriture d'un double

    public static void ecrireDouble(OutputStream f,double d) {
	ecrireString(f,Double.toString(d));
    }

    public static void ecrireDouble(double d) {System.out.print(d);}


}//class Ecriture

