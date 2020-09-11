package org.AHJ.modell.DataValidering;

public class CSVDataValiderer {

    public boolean validerTekst(String tekst) {
        char[] charArray = tekst.toCharArray();
        for (char character : charArray){
            if(!Character.isLetter(character) && !Character.isSpaceChar(character) && !(character=='-')){
                return false;
            }
        }
        return true;
    }

    public boolean validerTekstMedTall(String tekst) {
        char[] charArray = tekst.toCharArray();
        for (char character : charArray){
            if (!Character.isLetterOrDigit(character) && !Character.isSpaceChar(character)){
            }
        }
        return true;
    }

    public boolean validerInt(String tekst) {
        char[] charArray = tekst.toCharArray();
        for (char character : charArray){
            if (!Character.isDigit(character) && !Character.isSpaceChar(character)){
                return false;
            }
        }
        return true;
    }
}
