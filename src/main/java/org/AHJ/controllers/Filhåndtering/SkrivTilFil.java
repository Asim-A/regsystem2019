package org.AHJ.controllers.Filhåndtering;

import org.AHJ.modeller.objekter.Kunder;

import java.io.File;
import java.io.FileNotFoundException;

public interface SkrivTilFil {

    void skrivTilFil(File file, Kunder kunder) throws FileNotFoundException, Exception;

}
