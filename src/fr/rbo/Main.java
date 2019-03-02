package fr.rbo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int resultat = 100;
        int iteration = 0;

//        List<String> MaListe = new ArrayList<String>();

//        List<Integer> list = new ArrayList<int>();
//        list.add(4);

/*
        do {
            iteration ++;
            resultat = (int) (Math.random() * 9 );
            System.out.println("Tirage : " + resultat + " itération : " + iteration);
        }
        while (iteration < 1000);
*/
        int debut = 10;
        int fin = 70;
        int base = 6;
        int nbElements = fin - debut + 1; // les bornes sont comprises il faut un poste de plus dans le tableau
        int nbPostes = 4;

        int[][] tableau = new int[nbElements][nbPostes];
        String res = "";
        int num = fin;
        int rem;

        //calcul de la taille maximum nécessaire par nombre
        if (fin > 0) {
            while (num > 0) {
                rem = num % base;
                res += rem;
                num /= base;
            }
        }

        if (res.length() > nbPostes){
            System.out.println("nbPlages " + nbPostes + " trop petit. Modifié à : " + res.length());
            nbPostes = res.length();
        }

        int i = debut;
        int j = 0;
        int k;
        do {
            num = i;
            k = nbPostes - 1;
            if (i == 0) {
                res = "0";
            }
            while (num > 0) {
                rem = num % base;
                res += rem;
                num /= base;
                tableau [j][k] = rem;
                k--;
            }
            res = new StringBuffer(res).reverse().toString();

            System.out.println(i + " base " + base + " = " + res + " " + Arrays.toString(tableau[j]).replace(", ", ""));
//            tableau[j] = Integer.parseInt(res);
            res = "";
            i++;
            j++;

        } while (i <= fin);

    }
}