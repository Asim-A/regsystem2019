package org.AHJ.controllers.Exeptions;

import java.lang.reflect.Executable;

public class CSVFeilAntallDataKolonnerExeption extends Exception {

    public CSVFeilAntallDataKolonnerExeption() {
        super("Feil Antall Datakolonner i CSV fil!");
    }

    public CSVFeilAntallDataKolonnerExeption(int linje) {
        super("Feil Antall Datakolonner i CSV fil på linje: "+linje);
    }
}
