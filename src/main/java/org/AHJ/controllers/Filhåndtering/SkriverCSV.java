package org.AHJ.controllers.Filhåndtering;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
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
        List<Kunde> kundeListe =  kunder.getKundeListe();
        FileWriter writer = new FileWriter(file);
        //CSVWriterBuilder out = new CSVWriter(writer);
        System.out.println("PrintWriterCreated");
        System.out.println("Size Of kundeListe: "+kundeListe.size());
      /*  ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        String[] kolonner = {"fornavn","etternavn","dato","fakturaadresse","forsikringsnummer","ubetalte_erstatninger","forsikringer","skademeldinger","localDate"};
        strategy.setColumnMapping(kolonner);
        strategy.setType(Kunde.class);
        StatefulBeanToCsvBuilder beanToCsv = new StatefulBeanToCsvBuilder(writer).withMappingStrategy(strategy);
        StatefulBeanToCsv beanWriter = beanToCsv.withMappingStrategy(strategy).build();*/
        StatefulBeanToCsv<Object> beanToCsv = new StatefulBeanToCsvBuilder<>(writer).build();
        beanToCsv.write(kundeListe);
        writer.close();
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
 */      for (Kunde kunde : kundeListe) System.out.println((kunde.toString()));

    }
         /*
        for (int i =0; i<objList.size();i++)out.println(objList.get(i).toString());
            while (i<2 ||objList.listIterator().hasNext()){
                out.print(objList.listIterator().next().toString());
                i++;
            }
     }*/
}
