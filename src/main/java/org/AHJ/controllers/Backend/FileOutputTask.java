package org.AHJ.controllers.Backend;

import javafx.concurrent.Task;
import org.AHJ.controllers.Filhåndtering.*;
import org.AHJ.models.objekter.Kunder;

import java.io.File;
import java.io.FileNotFoundException;

public class FileOutputTask extends Task<Void> {

    private File contextInputFile;
    private Kunder kunder;

    public FileOutputTask(File contextInputFile, Kunder kunder) {
        System.out.println("FileOutputTask created");
        this.contextInputFile = contextInputFile;
        this.kunder = kunder;
    }

    @Override
    protected Void call() throws Exception {
        System.out.println("call() called");
        System.out.println("size of kunder"+kunder.getKundeListe().size());
        if (contextInputFile.toString().contains(".csv")){
            SkrivTilFil csvSkriv = new SkriverCSV();
            csvSkriv.skrivTilFil(contextInputFile, kunder);
        } else if (contextInputFile.toString().contains(".jobj")){
            SkrivTilFil jobjSkriv = new SkriverJOBJ();
            jobjSkriv.skrivTilFil(contextInputFile, kunder);
        }
        return null;
    }
}
