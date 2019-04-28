package org.AHJ.controllers.Filhåndtering;

import org.AHJ.modeller.objekter.Kunder;

import java.io.File;

public class LasterJOBJ implements LastInnFil {

    @Override
    public void lastInnFil(File file, Kunder kunder) {
        System.out.println("LasterJOBJ");
    }
}
