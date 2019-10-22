package fr.rbo;

import java.math.BigDecimal;

public class Annuite {

    public static Annuite build(int index) {
        Annuite annuite = new Annuite();
//        annuite.setRang(index);
        return annuite;
    }

    protected int rang;
    protected int ageAtteint;

    // Loi de déformation à appliquer sur la cotisation annuelle pour le tarif CRD âge atteint
    protected BigDecimal deform;
    // Taux annuel de remboursement anticipé en pourcent
    protected BigDecimal ra;

    // Coefs de risque par pack de formule
    //Garanties DECES et PTIA
    protected BigDecimal cdc;
    // Garanties ITT, IPT et IPP
    protected BigDecimal cit;
    protected BigDecimal coefit;

    // Variable d'exposition permettant de prendre en compte l'exposition réelle de l'assuré sur la dernière année (les autres années devant normalement être égales à 1
    protected BigDecimal coexpo;

    // Taux de cotisation technique
    protected BigDecimal tstdc;
    protected BigDecimal tstptia;
    protected BigDecimal tstitt;
    protected BigDecimal tstipt;
    protected BigDecimal tstipp;
    protected BigDecimal tstpe;

    // Taux de prime
    protected BigDecimal dccrd;
    protected BigDecimal ptiacrd;
    protected BigDecimal ittcrd;
    protected BigDecimal iptcrd;
    protected BigDecimal ippcrd;
    protected BigDecimal pecrd;

    //capital restant dû par bucket
    protected BigDecimal crd1;
    protected BigDecimal crd2;
    protected BigDecimal crd3;

    //Cotisation annuelle par garantie
    protected BigDecimal cotdccrd;
    protected BigDecimal cotptiacrd;
    protected BigDecimal cotittcrd;
    protected BigDecimal cotiptcrd;
    protected BigDecimal cotippcrd;
    protected BigDecimal cotpecrd;

    //Cotisation annuelle avec coefficient commercial
    protected BigDecimal fincotdccrd;
    protected BigDecimal fincotptiacrd;
    protected BigDecimal fincotittcrd;
    protected BigDecimal fincotiptcrd;
    protected BigDecimal fincotippcrd;
    protected BigDecimal fincotpecrd;

    public BigDecimal getCotisationAnnuelle(String code){
        switch(code){
            case "DC" : return  fincotdccrd;
            case "PTIA" : return  fincotptiacrd;
            case "ITT" : return  fincotittcrd;
            case "IPT" : return  fincotiptcrd;
            case "IPP" : return  fincotippcrd;
            case "PE" : return  fincotpecrd;
            default : return BigDecimal.ZERO;
        }
    }
}

