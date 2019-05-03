package org.AHJ.modell.Filhåndtering;

import org.AHJ.modell.Avvik.JOBJUtdatertKunderObjektExeption;
import org.AHJ.modell.objekter.Kunder;

import java.io.*;
import java.util.ArrayList;

public class LasterJOBJ implements LastInnFil {

    @Override
    public void lastInnFil(File file, Kunder kunder) throws JOBJUtdatertKunderObjektExeption, IOException, Exception{
        erTom(file);
        kunder.setKundeListe(new ArrayList<>());
        try (FileInputStream fileInputStream = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream))
        {
            Kunder obj = (Kunder) objectInputStream.readObject();
            objectInputStream.close();
            if (obj.getKundeListe()==null){
                throw new JOBJUtdatertKunderObjektExeption();
            }
            kunder.setKundeListe(obj.getKundeListe());
            System.out.println(kunder.toString());
        } catch (ClassNotFoundException cnfe){
            throw new JOBJUtdatertKunderObjektExeption();
        }
    }

    private void erTom(File file) throws Exception{
        if (file.length() == 0){
            throw new Exception("Filen er tom");
        }
    }
}
