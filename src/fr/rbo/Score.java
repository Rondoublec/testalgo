package fr.rbo;

import java.util.Arrays;

public class Score {

    public static void main(String[] args) {

    int nbTrous = 6;
    int nbCoul = 6;
    int [] S = {0,1,2,3,5,4};
    int [] P = {0,1,2,3,4,5};

    // recherche des biens placés
    int r = 0;
    for (int i=0; i< nbTrous;i++ ){
        if (S[i] == P[i]){
            r++;
        }
    }
    // recherche de l'ensemble des présents (bien placés compris)
    int b=-r;
    for (int i=0; i < nbCoul;i++ ) {
        int n=0;
        int m=0;
        for (int j=0;j < nbTrous;j++){
            if (S[j]==i){
                n++;
            }
            if (P[j]==i){
                m++;
            }
        }
        if (n<m){
            b=b+n;
        } else {
            b=b+m;
        }
    }
    int resultat = (10*r)+b;

System.out.println(Arrays.toString(S).replace(", ", ""));
System.out.println(Arrays.toString(P).replace(", ", ""));
System.out.println("["+resultat+"]");


    }

}
