package org.AHJ.controllers.Backend;

import javafx.concurrent.Task;
import java.io.File;

public class FileInputTask extends Task<Void> {

    private Runnable runWhenDone;
    private File contextInputFile;

    @Override
    protected Void call() throws Exception {
        return null;
    }

    //TODO implementer hva som skjer etter at filen har blitt loadet inn fra disk til minne
    @Override
    protected void succeeded() {
        runWhenDone.run();
    }
}
