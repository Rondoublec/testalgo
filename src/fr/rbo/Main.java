package fr.rbo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int resultat = 100;
        int iteration = 0;

        Dog dog = new Dog();
        dog.bark();

        List<List<String>> sentences = new ArrayList<List<String>>();
        System.out.println(sentences);


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
        int sBase = 10;
        int dBase = 6;
        int nbElements = fin - debut + 1; // les bornes sont comprises il faut un poste de plus dans le tableau
        int nbPostes = 4;

        String res = Integer.toString(Integer.parseInt(String.valueOf(fin), sBase),dBase);
        if (res.length() > nbPostes){
            System.out.println("nbPlages " + nbPostes + " trop petit. Modifié à : " + res.length());
            nbPostes = res.length();
        }
        int[][] tableau = new int[nbElements][nbPostes];
        res = "";

        int num = fin;
        int rem;

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
                rem = num % dBase;
                res += rem;
                num /= dBase;
                tableau [j][k] = rem;
                k--;
            }
            res = new StringBuffer(res).reverse().toString();

            System.out.println(i + " base " + dBase + " = " + res + " " + Arrays.toString(tableau[j]).replace(", ", ""));
//            tableau[j] = Integer.parseInt(res);
            res = "";
            i++;
            j++;

        } while (i <= fin);

    }
}