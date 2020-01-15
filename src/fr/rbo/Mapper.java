package fr.rbo;

import javax.xml.datatype.XMLGregorianCalendar;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;


public class Mapper {

    public static String getpos(String str, int pos, int longueure) {
        if (str == null)
            return createEmptyString(longueure);
        try {
            return str.substring(pos, pos + longueure);
        }
        catch (StringIndexOutOfBoundsException e) {
            return createEmptyString(longueure);
        }

    }

    private static String createEmptyString(int longueur) {
        final StringBuffer buf = new StringBuffer();
        for (int i = 0; i < longueur; i++) {
            buf.append(" ");
        }
        return buf.toString();
    }


    public static void decode(FTCVO ftcvo, String str, String field, int pos, int longueur) {

        if (field == null)
            field = "";
        str = ftcvo.getOut();
        if (field.length() < longueur) {

            String temp = "";
            // for(int i=0;i<= (pos -field.length());i++){
            // temp=temp+" ";
            // }
            // **
            StringBuffer buf = new StringBuffer();
            for (int i = 1; i <= (longueur - field.length()); i++) {
                buf.append(" ");
            }
            temp = buf.toString();
            // **

            field = field + temp;

        }
        else {
            if (field.length() > longueur) {

                field = field.substring(0, longueur);
            }
        }
        ftcvo.setOut(replaceStringAt(str, pos, field));
        // replaceCharAt(s, pos, c);

    }

    public static String replaceCharAt(String s, int pos, char c) {

        if (s.length() < pos) {
            String temp = "";
            // for(int i=0;i<= (pos -s.length());i++){
            // temp=temp+" ";
            // }
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i <= (pos - s.length()); i++) {
                buf.append(" ");
            }
            temp = buf.toString();

            s = s + temp;

        }
        return s.substring(0, pos) + c + s.substring(pos + 1);
    }

    public static String replaceStringAt(String s, int pos, String c) {

        if (s.length() <= pos) {
            String temp = "";
            // for(int i=0;i<= (pos -s.length());i++){
            // temp=temp+" ";
            // }

            StringBuffer buf = new StringBuffer();
            for (int i = 0; i <= (pos - s.length()); i++) {
                buf.append(" ");
            }
            temp = buf.toString();

            s = s + temp;

        }
        return s.substring(0, pos) + c + s.substring(pos + 1);
    }

}
