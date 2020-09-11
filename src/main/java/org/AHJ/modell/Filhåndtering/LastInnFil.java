package org.AHJ.modell.Filhåndtering;

import org.AHJ.modell.objekter.Kunder;

import java.io.File;
import java.io.FileNotFoundException;

public interface LastInnFil {

     void lastInnFil(File file, Kunder kunder) throws FileNotFoundException, Exception;

    /*    private void setdefault(){

        URL location = LastInnFil.class.getProtectionDomain().getCodeSource().getLocation();
        location.getPath();
    }*/

}
