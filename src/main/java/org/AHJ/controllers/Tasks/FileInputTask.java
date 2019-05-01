package org.AHJ.controllers.Tasks;

import javafx.concurrent.Task;
import org.AHJ.controllers.Filhåndtering.LastInnFil;
import org.AHJ.controllers.Filhåndtering.LasterCSV;
import org.AHJ.controllers.Filhåndtering.LasterJOBJ;
import org.AHJ.modeller.objekter.Kunder;

import java.io.File;

public class FileInputTask extends Task<Void> {

    private Runnable runWhenDone;
    private File contextInputFile;
    private Kunder kunder;

    public FileInputTask(File contextInputFile, Kunder kunder, Runnable runWhenDone) {
        this.runWhenDone = runWhenDone;
        this.contextInputFile = contextInputFile;
        this.kunder = kunder;
    }

    @Override
    protected Void call() throws Exception {
        System.out.println("size of kunder"+kunder.getKundeListe().size());
        if (contextInputFile.toString().contains(".csv")) {
            LastInnFil csvLast = new LasterCSV();
            csvLast.lastInnFil(contextInputFile, kunder);
        } else if (contextInputFile.toString().contains(".jobj")) {
            LastInnFil jobjLast = new LasterJOBJ();
            jobjLast.lastInnFil(contextInputFile, kunder);

        }
        return null;
    }

    //TODO implementer hva som skjer etter at filen har blitt loadet inn fra disk til minne
    @Override
    protected void succeeded() {
        runWhenDone.run();
    }
}
