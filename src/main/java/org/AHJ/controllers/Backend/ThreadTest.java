package org.AHJ.controllers.Backend;

import javafx.concurrent.Task;

public class ThreadTest extends Task<Void> {

    private Runnable run;

    public ThreadTest(Runnable run) {
        this.run = run;
    }

    @Override
    protected Void call() throws Exception {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }

        return null;
    }

    @Override
    protected void succeeded(){
        run.run();
    }
}
