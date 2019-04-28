package org.AHJ.controllers.Tasks;

import javafx.concurrent.Task;

public class ThreadTest extends Task<Void> {

    private Runnable run;
    public String CONTENT;

    public ThreadTest(Runnable run, String CONTENT) {
        this.run = run;
        this.CONTENT = CONTENT;
    }

    @Override
    protected Void call() throws Exception {

        for(int i = 0; i < 5; i++) {
            try {
                System.out.println(CONTENT);
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }

        return null;
    }

    @Override
    protected void succeeded(){
        run.run();
    }
}
