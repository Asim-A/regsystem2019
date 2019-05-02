package org.AHJ.controllers.Exeptions;

import java.lang.reflect.Executable;

public class FeilAntallDataKolonnerExeption extends Exception {

    public FeilAntallDataKolonnerExeption() {
        super("FeilAntallKolonnerExeption: Feil Feil Antall Datakolonner i CSV fil!");
    }
}
