package org.AHJ.modell.Avvik;

public class CSVFeilAntallDataKolonnerExeption extends Exception {

    public CSVFeilAntallDataKolonnerExeption() {
        super("Feil Antall Datakolonner i CSV fil!");
    }

    public CSVFeilAntallDataKolonnerExeption(int linje) {
        super("Feil Antall Datakolonner i CSV fil på linje: "+linje);
    }
}
