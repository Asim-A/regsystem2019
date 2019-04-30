package org.AHJ.controllers.DataValidering;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.chart.PieChart;

import java.awt.*;
import java.util.zip.DataFormatException;


public class InnskrevetDataValiderer {

    public void validerNavn(String navn,String feltNavn) throws NullPointerException, DataFormatException {
        if (!(navn.trim().length() > 0)){
            throw new NullPointerException("Alle felt må fylles ut");
        }
        char[] charArray = navn.toCharArray();
        for (char character : charArray){
            if (!Character.isLetter(character)){
                if(!Character.isSpaceChar(character)){
                    throw new DataFormatException("Feil inntastet Data " +
                            "kun bokstaver og mellomrom tillat i feltet: "+feltNavn);
                }
            }
        }
    }

    public void validerTekstMedTall(String tekst, String feltNavn) throws NullPointerException, DataFormatException {
        if (!(tekst.trim().length() > 0)){
            throw new NullPointerException("Alle felt må fylles ut");
        }
        char[] charArray = tekst.toCharArray();
        for (char character : charArray){
            if (!Character.isLetterOrDigit(character)){
                if(!Character.isSpaceChar(character)){
                    throw new DataFormatException("Feil inntastet Data " +
                            "Kun bokstaver tall og mellomrom tillat i feltet: "+feltNavn);
                }
            }
        }
    }

    public void validerInt(String tekst,String feltNavn) throws NullPointerException, DataFormatException {
        System.out.println("yikes");
        if (!(tekst.trim().length() > 0)){
            System.out.println("yikes2");

            throw new NullPointerException("Alle felt må fylles ut");
        }
        char[] charArray = tekst.toCharArray();
        for (char character : charArray){
            if (!Character.isDigit(character)){
                if(!Character.isSpaceChar(character)){
                    System.out.println("yikes3");
                    throw new DataFormatException("Feil inntastet Data " +
                            "Kun Heltall tillat i feltet: "+feltNavn);
                }
            }
        }
    }
}
