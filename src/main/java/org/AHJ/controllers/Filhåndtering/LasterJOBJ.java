package org.AHJ.controllers.Filhåndtering;

import java.io.File;
import java.util.List;

public class LasterJOBJ implements LastInnFil {

    @Override
    public void lastInnFil(File file, List kundeListe) {
        System.out.println("LasterJOBJ");
    }
}
