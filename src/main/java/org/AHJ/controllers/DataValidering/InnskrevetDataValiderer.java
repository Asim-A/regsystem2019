package org.AHJ.controllers.DataValidering;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.chart.PieChart;

import java.awt.*;
import java.util.zip.DataFormatException;


public class InnskrevetDataValiderer {

    public void validerNavn(String navn,String feltNavn) throws NullPointerException, DataFormatException {
        erNull(navn);
        char[] charArray = navn.toCharArray();
        for (char character : charArray){
            if(!Character.isLetter(character) && !Character.isSpaceChar(character)){
                throw new DataFormatException("Feil inntastet data! " +
                        "kun bokstaver og mellomrom tillat i feltet: "+feltNavn);
            }
        }
    }

    public void validerTekstMedTall(String tekst, String feltNavn) throws NullPointerException, DataFormatException {
        erNull(tekst);
        char[] charArray = tekst.toCharArray();
        for (char character : charArray){
            if (!Character.isLetterOrDigit(character) && !Character.isSpaceChar(character)){
                    throw new DataFormatException("Feil inntastet data! " +
                            "Kun bokstaver, tall og mellomrom tillat i feltet: "+feltNavn);

            }
        }
    }



    public void validerLangTekst(String tekst, String feltNavn) throws NullPointerException, DataFormatException {
        erNull(tekst);
        char[] charArray = tekst.toCharArray();
        for (char character : charArray){
            if (!Character.isLetterOrDigit(character) && !Character.isSpaceChar(character)){
                if (!(character =='.') && !(character ==',') && !(character==':') ) {
                    throw new DataFormatException("Feil inntastet data! " +
                            "Kun bokstaver, tall, komma, punktum, kolon og mellomrom tillat i feltet: " + feltNavn);
                }
            }
        }
    }



    public void validerInt(String tekst,String feltNavn) throws NullPointerException, DataFormatException {
        erNull(tekst);
        char[] charArray = tekst.toCharArray();
        for (char character : charArray){
            if (!Character.isDigit(character) && !Character.isSpaceChar(character)){
                    throw new DataFormatException("Feil inntastet data! " +
                            "Kun Heltall tillat i feltet: "+feltNavn);
            }
        }
    }

    public void erNull(String tekst) throws NullPointerException{
        if (!(tekst.trim().length() > 0)){
            throw new NullPointerException("Alle innskrivingsfelt må fylles ut!");
        }
    }
}
