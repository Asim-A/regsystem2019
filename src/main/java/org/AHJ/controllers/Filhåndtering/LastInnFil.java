package org.AHJ.controllers.Filhåndtering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface LastInnFil {

     void lastInnFil(File file, List kundeListe) throws FileNotFoundException, Exception;

    /*    private void setdefault(){

        URL location = LastInnFil.class.getProtectionDomain().getCodeSource().getLocation();
        location.getPath();
    }*/

}
