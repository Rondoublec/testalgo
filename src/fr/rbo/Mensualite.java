package fr.rbo;

import java.math.BigDecimal;


public class Mensualite {

    public static Mensualite build(int index) {
        Mensualite mensualite = new Mensualite();
//        mensualite.setRang(index);
        return mensualite;
    }

    protected int rang;

    //capital restant dû par bucket
    protected BigDecimal crdm1;
    protected BigDecimal crdm2;
    protected BigDecimal crdm3;


    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rang  + ";");
        stringBuilder.append(crdm1 + ";");
        stringBuilder.append(crdm2 + ";");
        stringBuilder.append(crdm3 + ";");
        return stringBuilder.toString();

    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public BigDecimal getCrdm1() {
        return crdm1;
    }

    public void setCrdm1(BigDecimal crdm1) {
        this.crdm1 = crdm1;
    }

    public BigDecimal getCrdm2() {
        return crdm2;
    }

    public void setCrdm2(BigDecimal crdm2) {
        this.crdm2 = crdm2;
    }

    public BigDecimal getCrdm3() {
        return crdm3;
    }

    public void setCrdm3(BigDecimal crdm3) {
        this.crdm3 = crdm3;
    }

}



