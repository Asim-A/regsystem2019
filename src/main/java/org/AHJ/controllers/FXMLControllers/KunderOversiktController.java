package org.AHJ.controllers.FXMLControllers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KunderOversiktController {

    ExecutorService service;

    public KunderOversiktController() {
        service = Executors.newSingleThreadExecutor();
    }
}