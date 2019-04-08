package org.AHJ.controllers.Filhåndtering;

import org.AHJ.models.objekter.Kunde;
import org.AHJ.models.objekter.Kunder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SkriverCSV implements SkrivTilFil{

    @Override
    public void skrivTilFil(File file, Kunder kunder) throws FileNotFoundException {
        ArrayList<Kunde> kundeListe = (ArrayList<Kunde>) kunder.getKundeListe();
        PrintWriter out = new PrintWriter(file);
        System.out.println("PrintWriterCreated");
        System.out.println("Size Of kundeListe: "+kundeListe.size());
        for (Kunde kunde : kundeListe) out.println(kunde.toString());
        out.close();
    }
         /*
        for (int i =0; i<objList.size();i++)out.println(objList.get(i).toString());
            while (i<2 ||objList.listIterator().hasNext()){
                out.print(objList.listIterator().next().toString());
                i++;
            }
     }*/
}
