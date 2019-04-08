package org.AHJ.controllers.Filhåndtering;

import org.AHJ.models.objekter.Kunder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface LastInnFil {

     void lastInnFil(File file, Kunder kunder) throws FileNotFoundException, Exception;

    /*    private void setdefault(){

        URL location = LastInnFil.class.getProtectionDomain().getCodeSource().getLocation();
        location.getPath();
    }*/

}
