package org.AHJ.controllers.Exeptions;

import java.lang.reflect.Executable;

public class CSVFeilAntallDataKolonnerExeption extends Exception {

    public CSVFeilAntallDataKolonnerExeption() {
        super("FeilAntallKolonnerExeption: Feil Feil Antall Datakolonner i CSV fil!");
    }
}
