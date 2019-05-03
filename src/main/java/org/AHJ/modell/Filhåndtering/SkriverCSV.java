package org.AHJ.modell.Filhåndtering;

import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.AHJ.modell.objekter.Kunde;
import org.AHJ.modell.objekter.Kunder;

import java.io.*;
import java.util.List;

public class SkriverCSV implements SkrivTilFil{

    @Override
    public void skrivTilFil(File file, Kunder kunder) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        List<Kunde> kundeListe =  kunder.getKundeListe();
        FileWriter writer = new FileWriter(file);
        ColumnPositionMappingStrategy<Kunde> strategy = new ColumnPositionMappingStrategy<>();
        String[] kolonner = {"fornavn","etternavn","dato","fakturaadresse","forsikringsnummer","ubetalte_erstatninger","forsikringer","skademeldinger"};
        strategy.setType(Kunde.class);
        strategy.setColumnMapping(kolonner);
        StatefulBeanToCsvBuilder<Kunde> beanToCsvBuilder = new StatefulBeanToCsvBuilder<Kunde>(writer)
                .withMappingStrategy(strategy)
                .withSeparator(';');
        StatefulBeanToCsv<Kunde> beanToCsv = beanToCsvBuilder.build();
        beanToCsv.write(kundeListe);
        writer.close();
    }
}
