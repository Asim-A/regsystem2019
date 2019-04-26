package org.AHJ.controllers.Filhåndtering;

import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import org.AHJ.models.objekter.Kunde;
import org.AHJ.models.objekter.Kunder;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class SkriverCSV implements SkrivTilFil{

    @Override
    public void skrivTilFil(File file, Kunder kunder) throws Exception {
        List<Kunde> kundeListe =  kunder.getKundeListe();
        FileWriter writer = new FileWriter(file);
        //CSVWriterBuilder out = new CSVWriter(writer);
        System.out.println("PrintWriterCreated");
        System.out.println("Size Of kundeListe: "+kundeListe.size());
        ColumnPositionMappingStrategy<Kunde> strategy = new ColumnPositionMappingStrategy<>();
        String[] kolonner = {"Fornavn","etternavn","dato","fakturaadresse","forsikringsnummer","ubetalte_erstatninger","forsikringer","skademeldinger"};
        strategy.setType(Kunde.class);
        strategy.setColumnMapping(kolonner);
        StatefulBeanToCsv<Kunde> beanToCsv = new StatefulBeanToCsvBuilder<Kunde>(writer).withMappingStrategy(strategy).build();
        beanToCsv.write(kundeListe);
        writer.close();
        for (Kunde kunde : kundeListe) System.out.println((kunde.toString()));
      //  for (Kunde kunde : kundeListe) System.out.println((kunde.dato));
      /*  StatefulBeanToCsv<Kunde> beanToCsv = new StatefulBeanToCsvBuilder<Kunde>(writer).build();
        beanToCsv.write(kundeListe);
        writer.close();*/
      /*  Map<String,String> kolonnerMap = new HashMap<String,String>();
        for (int i = 0 ; i<kolonner.length;i++)kolonnerMap.put("COLUMN"+i, kolonner[i]);*/
      /*  HeaderColumnNameMappingStrategy<Kunde> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(Kunde.class);
        strategy.setC(new MyComparator());
        StatefulBeanToCsv beanToCsv = StatefulBeanToCsvBuilder(writer)
                .withMappingStrategy(strategy)
                .build();
        beanToCsv.write(beans);
        writer.close();*/
       /*
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        String[] kolonner = {"fornavn","etternavn","dato","fakturaadresse","forsikringsnummer","ubetalte_erstatninger","forsikringer","skademeldinger"};
        strategy.setColumnMapping(kolonner);
        strategy.setType(Kunde.class);
        StatefulBeanToCsvBuilder beanToCsv = new StatefulBeanToCsvBuilder(writer).withMappingStrategy(strategy);
        StatefulBeanToCsv beanWriter = beanToCsv.withMappingStrategy(strategy).build();
        beanWriter.write(kundeListe);*/
       /* out.
        for (Kunde kunde : kundeListe) out.writeNext(new String[]{(kunde.toString())});
 */
    }
         /*
        for (int i =0; i<objList.size();i++)out.println(objList.get(i).toString());
            while (i<2 ||objList.listIterator().hasNext()){
                out.print(objList.listIterator().next().toString());
                i++;
            }
     }*/
}
