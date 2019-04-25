package org.AHJ.controllers.Filhåndtering;

import org.AHJ.models.objekter.Kunder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface SkrivTilFil {

    void skrivTilFil(File file, Kunder kunder) throws FileNotFoundException, Exception;

}
