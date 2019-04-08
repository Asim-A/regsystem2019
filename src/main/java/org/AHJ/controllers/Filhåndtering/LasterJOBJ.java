package org.AHJ.controllers.Filhåndtering;

import org.AHJ.models.objekter.Kunder;

import java.io.File;
import java.util.List;

public class LasterJOBJ implements LastInnFil {

    @Override
    public void lastInnFil(File file, Kunder kunder) {
        System.out.println("LasterJOBJ");
    }
}
