package fr.rbo;

import java.util.Arrays;

public class Base {
// Java program to convert one base to other
    public static String baseConversion(String number,
                                        int sBase, int dBase)
    {
        // Parse the number with source radix
        // and return in specified radix(base)
        return Integer.toString(Integer.parseInt(number, sBase),dBase);
    }
    public static void main(String[] args)
    {
        String number = "70"; // Number
        int sBase = 10; // Source Base Octal
        int dBase = 6; // Destination Base Decimal
        int debut = 10;
        int fin = 70;
        int nbPostes = 4;

        System.out.println();

        // Vérification de la taille maximum nécessaire
        String resultat = Integer.toString(Integer.parseInt(String.valueOf(fin), sBase),dBase);

        if (resultat.length()>nbPostes){
            System.out.println("nbPlages " + nbPostes + " trop petit. Modifié à : " + resultat.length());
            nbPostes = resultat.length();
        }

        // Calcul du nombre de postes nécessaires
        int nbElements = fin - debut + 1; // les bornes sont comprises il faut un poste de plus dans le tableau
        int[][] tableau = new int[nbElements][nbPostes];
        String resultatFormate = "";

        int j = 0;
        for (int i=debut; i < fin ; i++){

            resultat = Integer.toString(Integer.parseInt(String.valueOf(i), sBase),dBase);
            resultatFormate = (String.format("%0"+nbPostes+"d", Integer.parseInt(resultat)));
            System.out.println(resultatFormate);

            for (int k=0; k < nbPostes; k++){
                tableau[j][k] = (int) resultatFormate.charAt(k)-48;
                }
            System.out.println(i + " base " + dBase + " = " + resultatFormate + " " + Arrays.toString(tableau[j]).replace(", ", ""));
            j++;
        }
    }
}
