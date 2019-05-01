package org.AHJ.controllers.Filhåndtering;

import org.AHJ.modeller.objekter.Kunder;

import java.io.*;
import java.util.ArrayList;

public class LasterJOBJ implements LastInnFil {

    @Override
    public void lastInnFil(File file, Kunder kunder) throws IOException, ClassNotFoundException {
        kunder.setKundeListe(new ArrayList<>());
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
        Kunder obj = (Kunder) objectInputStream.readObject();
        objectInputStream.close();
        kunder.setKundeListe(obj.getKundeListe());
        System.out.println(kunder.toString());
    }
}
