package org.AHJ.controllers.Filhåndtering;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SkriverJOBJ implements SkrivTilFil {

    @Override
    public void skrivTilFil(File file, List kunder){

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(kunder);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
