package org.AHJ.controllers.Exeptions;

import java.lang.reflect.Executable;

public class FeilAntallKollonnerExeption extends Exception {


    public FeilAntallKollonnerExeption(){

    }

    @Override
    public String toString(){
        return "feilantallkolloner";
    }

}
