package org.AHJ.controllers.Filhåndtering;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.AHJ.models.objekter.Kunde;
import org.AHJ.models.objekter.Kunder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SkriverCSV implements SkrivTilFil{

    @Override
    public void skrivTilFil(File file, Kunder kunder) throws Exception {
        ArrayList<Kunde> kundeListe = (ArrayList<Kunde>) kunder.getKundeListe();
        Writer writer = new FileWriter(file);
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        String[] kolonner = {"fornavn","etternavn","dato","fakturaadresse","forsikringsnummer","ubetalte_erstatninger","forsikringer","skademeldinger"};
        strategy.setColumnMapping(kolonner);
        //CSVWriterBuilder out = new CSVWriter(writer);
        System.out.println("PrintWriterCreated");
        System.out.println("Size Of kundeListe: "+kundeListe.size());
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).withMappingStrategy(strategy).build();
        beanToCsv.write(kundeListe.get(0));
       /* out.
        for (Kunde kunde : kundeListe) out.writeNext(new String[]{(kunde.toString())});
       for (Kunde kunde : kundeListe) System.out.println((kunde.toString()));
*/
        writer.close();

    }
         /*
        for (int i =0; i<objList.size();i++)out.println(objList.get(i).toString());
            while (i<2 ||objList.listIterator().hasNext()){
                out.print(objList.listIterator().next().toString());
                i++;
            }
     }*/
}
