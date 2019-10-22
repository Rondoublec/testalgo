package fr.rbo;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





public class ManipList {

    public static void main(String[] args) {

        List<Mensualite> maListeDeMensualite = new ArrayList<>();


        for (int i=0; i < 10 ; i++) {
            Mensualite maMensualite = new Mensualite();
            maMensualite.rang = i;
            maMensualite.crdm1 = BigDecimal.valueOf(i*1000.0000);
            maMensualite.crdm2 = BigDecimal.valueOf(i*1000.0000);
            maMensualite.crdm3 = BigDecimal.valueOf(i*1000.0000);
            maListeDeMensualite.add(maMensualite);
        }

        printList(maListeDeMensualite);
        imprimeListe(maListeDeMensualite);

    }

    public static <T> void printList(List<T> lst) {
            for(T t : lst) {
                System.out.println(t.toString());
            }
        }

    public static <T> void imprimeListe(List<T> lst) {

        Iterator var2 = lst.iterator();

        while(var2.hasNext()) {
            T t = (T) var2.next();

            //T t = var2.next();

            System.out.println(t.toString());
        }

    }

}

