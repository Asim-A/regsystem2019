package org.AHJ.controllers.DataValidering;

import org.AHJ.controllers.Handlers.Verktøy.LocalDateStringConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.zip.DataFormatException;

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
