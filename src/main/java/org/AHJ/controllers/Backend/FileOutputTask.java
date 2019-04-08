package org.AHJ.controllers.Backend;

import javafx.concurrent.Task;
import org.AHJ.controllers.Filhåndtering.LastInnFil;
import org.AHJ.controllers.Filhåndtering.LasterJOBJ;
import org.AHJ.controllers.Filhåndtering.SkrivTilFil;
import org.AHJ.controllers.Filhåndtering.SkriverJOBJ;
import org.AHJ.models.objekter.Kunder;

import java.io.File;

public class FileOutputTask extends Task<Void> {

    private File contextInputFile;
    private Kunder kunder;

    public FileOutputTask(File contextInputFile, Kunder kunder) {
        this.contextInputFile = contextInputFile;
        this.kunder = kunder;
    }

    @Override
    protected Void call() throws Exception {

        SkrivTilFil skrivTilFil = new SkriverJOBJ();
        skrivTilFil.skrivTilFil(contextInputFile, kunder);

        return null;
    }

}
