package org.AHJ.controllers.Filhåndtering;

import java.io.File;

public class LasterJOBJ implements LastInnFil {

    @Override
    public void lastInnFil(File file) {
        System.out.println("LasterJOBJ");
    }
}
