package org.AHJ.modell.Tasks;

import javafx.concurrent.Task;
import org.AHJ.modell.Filhåndtering.LastInnFil;
import org.AHJ.modell.Filhåndtering.LasterCSV;
import org.AHJ.modell.Filhåndtering.LasterJOBJ;
import org.AHJ.modell.objekter.Kunder;

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
        if (contextInputFile.toString().contains(".csv")) {
            LastInnFil csvLast = new LasterCSV();
            csvLast.lastInnFil(contextInputFile, kunder);
        } else if (contextInputFile.toString().contains(".jobj")) {
            LastInnFil jobjLast = new LasterJOBJ();
            jobjLast.lastInnFil(contextInputFile, kunder);

        }
        return null;
    }

    @Override
    protected void succeeded() {
        runWhenDone.run();
    }

}
