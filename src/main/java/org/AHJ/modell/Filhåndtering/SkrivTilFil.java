package org.AHJ.modell.Filhåndtering;

import org.AHJ.modell.objekter.Kunder;

import java.io.File;
import java.io.FileNotFoundException;

public interface SkrivTilFil {

    void skrivTilFil(File file, Kunder kunder) throws FileNotFoundException, Exception;

}
