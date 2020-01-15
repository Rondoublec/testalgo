package fr.rbo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExtractData {

    private static final String		MSG_INFILE_A_PRECISER			= "\n Vous devez specifier le fichier d'entree et de sortie.\n"
            + " Pour ce faire, ouvrir le fichier Start.cmd et remplacer les paramètres in.txt et out.txt par vos fichier.\n";
    private static String			fichierIn;
    private static PrintWriter      fichierOut;

    public static void main(String[] args) throws IOException {
//        saveFluxReference("C:\\TMP\\exempleFluxFipRefNew.xml", fluxNow);

        final String path = "C:\\majoration\\";
        fichierIn = path + "macao.extract.majoration_ftc.20191212_1330.txt";
        String RPP;
        Boolean selRPP = false;
        int nbLus = 0;
        int nbEcr = 0;
        int nbRPPLus = 0;
        int nbRPPEcr = 0;

        final Date debut = new Date();

        final SimpleDateFormat simpl = new SimpleDateFormat("yyyyMMddHHmmss");
        final SimpleDateFormat simpl2 = new SimpleDateFormat("dd/MM/yyyy HH:mm ss");
        String dateDebutForFileNames = "_" + simpl.format(debut);
        String dateDebutForLog = simpl2.format(debut);

        System.out.println("************************************************************************************");
        System.out.println("Debut du traitement " + dateDebutForFileNames);
        System.out.println("Debut du traitement " + dateDebutForLog);

        FileWriter fwSortie = new FileWriter(path + "/macao.extract.majoration_ftc_out_" + dateDebutForFileNames + ".txt");
        BufferedWriter bwSortie = new BufferedWriter(fwSortie);
        fichierOut = new PrintWriter(bwSortie);

        fr.rbo.Selection0.chargeListe();
        fr.rbo.Selection1.chargeListe();
        fr.rbo.Selection2.chargeListe();
        fr.rbo.Selection3.chargeListe();

        try {

            try (FileReader fReader = new FileReader(fichierIn); BufferedReader buffIn = new BufferedReader(fReader);){
                if (buffIn.ready()) {
                    final List<Thread> threadList = new ArrayList<Thread>();
                    boolean first = true;
                    String ligne = null;
                    while ((ligne = buffIn.readLine()) != null || threadList.size() > 0) {
                        if (ligne != null) {
                            nbLus=nbLus+1;
                            if ("LIGNMA".equals(Mapper.getpos(ligne, 0, 6))) {
                                selRPP = false;
                                nbRPPLus=nbRPPLus+1;
//                                System.out.println ("DEBUT : " + ligne);
                                RPP = Mapper.getpos(ligne, 6, 13);
                                if (Selection0.al.contains(RPP)) {
                                    selRPP = true;
                                    fichierOut.println(ligne);
                                    nbEcr=nbEcr+1;
                                    nbRPPEcr=nbRPPEcr+1;
                                }
                            }
                            else if ("LTCAPPNBZFTC".equals(Mapper.getpos(ligne, 0, 12))) {
                                if(selRPP){fichierOut.println(ligne);nbEcr=nbEcr+1;}
                            }
                            else if ("LTCAPPNBZFTB".equals(Mapper.getpos(ligne, 0, 12))) {
                                if(selRPP){fichierOut.println(ligne);nbEcr=nbEcr+1;}
                            }
                            else if ("LTCAPPNBZYC".equals(Mapper.getpos(ligne, 0, 11))) {
                                if(selRPP){fichierOut.println(ligne);nbEcr=nbEcr+1;}
                            }
                            else if ("LTCAPPNBZTV".equals(Mapper.getpos(ligne, 0, 11))) {
                                if(selRPP){fichierOut.println(ligne);nbEcr=nbEcr+1;}
                            }
                            else if ("STOPMA".equals(Mapper.getpos(ligne, 0, 6))) {
                                if(selRPP){fichierOut.println(ligne);nbEcr=nbEcr+1;}
//                                System.out.println ("FIN   : " + ligne);
                                selRPP = false;
                            }
                        }
                    }
                }
            }
            catch (final IOException ioe) {
                System.out.println("error in main thread " + ioe);
                throw ioe;
            }

            fichierOut.close();

            final Date fin = new Date();
            dateDebutForLog = simpl2.format(fin);
            System.out.println("Fin du traitement à " + dateDebutForLog);
            final long time = (((fin.getTime() - debut.getTime()) / 1000));
            System.out.println("le traitement est fini en : " + time + " secondes");
            System.out.println(" : nbLus = " + nbLus);
            System.out.println("   -> nbRPPLus = " + nbRPPLus);
            System.out.println(" : nbEcr = " + nbEcr);
            System.out.println("   -> nbRPPEcr = " + nbRPPEcr);
            System.out.println(" : le traitement est fini en : " + time + " secondes");
            System.out.println("************************************************************************************");


        }
        catch (final IOException e) {

            System.out.println( "ERROR : " + MSG_INFILE_A_PRECISER);
            e.printStackTrace();
            System.out.println( "ERROR : error in main thread");
        }

    }

}
