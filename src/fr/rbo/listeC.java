package fr.rbo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class listeC {

    public static void main(String[] args) {
        System.out.println("Debut");
        int sBase = 10;
        int dBase = 6; // nB valeurs (couleurs)
        int nbPostes = 4;

/*
        int nMax = dBase - 1;
        System.out.println();
        String vMax = "";
        // Determination du maximum
        for (int i=0 ; i < nbPostes; i++){
            vMax = vMax + nMax;
        }
        System.out.println(vMax);
        int fin = Integer.parseInt(vMax);
*/

        double nMax = Math.pow(dBase, nbPostes);
        String resultatFormate = "";
        String resultat = "";
        List<String> maListe = new ArrayList<String>();

        int j = 0;

        for (int i=0; i < nMax ; i++){
            resultat = Integer.toString(Integer.parseInt(String.valueOf(i), sBase),dBase);
            resultatFormate = (String.format("%0"+nbPostes+"d", Integer.parseInt(resultat)));

            maListe.add(resultatFormate);
            System.out.println(maListe.get(i));
        }
        System.out.println(maListe);
    }
}
