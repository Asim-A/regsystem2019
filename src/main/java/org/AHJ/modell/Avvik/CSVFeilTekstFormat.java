package org.AHJ.modell.Avvik;

public class CSVFeilTekstFormat extends Exception{

    public CSVFeilTekstFormat(int linje){
        super("Feil Tekst Format På Kolonne 6 eller 7 på rad "+linje+" i CSV  fil");
    }

}
