package org.AHJ.controllers.Filhåndtering;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.AHJ.models.objekter.Kunde;
import org.AHJ.models.objekter.Kunder;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LasterCSV implements LastInnFil {


    @Override
    public void lastInnFil(File file, Kunder kunder) throws Exception {
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(csvParser).withSkipLines(0).build();
        //  ArrayList<Kunde> kundeListe = (ArrayList<Kunde>) kunder.getKundeListe();
        ArrayList<String[]> data = new ArrayList<>();
        String[] linje;
        while (( linje = csvReader.readNext()) != null) {
            data.add(linje);
        }
        System.out.println("Size of kundeListe in LASTERCSV PRE read "+kunder.getKundeListe().size());
        csvReader.close();
        for (String[] row : data){
            System.out.print("Size of Row[] "+row.length);
            Kunde kunde = new Kunde(row[0],row[1],row[3],Integer.valueOf(row[4]),Integer.valueOf(row[5]));
            if (!row[6].equals("[]")){
                System.out.println("FORSIKRINGER NOT EMPTY");
                System.out.println(row[6]);
                switch (row[6]){
                }
                // new forsikring
                // add forsikring
            }
            if (!row[7].equals("[]")){
                System.out.println("SKADEMELDINGER NOT EMPTY");
                System.out.println(row[7]);
                // new skademelding
                // add skademelding
            }
            kunder.getKundeListe().add(kunde);
           // kunder.getKundeListe().add(new Kunde(row[i++],row[++i],row[++i],Integer.valueOf(row[++i]),Integer.valueOf(row[++i])));
        }
        System.out.println("DONE");
        System.out.println(Arrays.toString(kunder.getKundeListe().toArray()));
        System.out.println("Size of kundeListe in LASTERCSV AFTER read "+kunder.getKundeListe().size());
        //     for(String[] line : data)
    //        for (int j = 0 ; j<line.length;j++){System.out.println(line[j]);}

       /* ColumnPositionMappingStrategy<Kunde> strategy = new ColumnPositionMappingStrategy<>();
        String[] kolonner = {"fornavn","etternavn","dato","fakturaadresse","forsikringsnummer","ubetalte_erstatninger","forsikringer","skademeldinger"};
        strategy.setType(Kunde.class);
        strategy.setColumnMapping(kolonner);
        CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withSkipLines(0).build();
        //';', '\'', 0);
        System.out.println("READING");
        CsvToBean<Kunde> csvToBean = new CsvToBeanBuilder<Kunde>(reader)
                .withMappingStrategy(strategy)
                .withSkipLines(0)
                .withSeparator(';')
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        Iterator<Kunde> myUserIterator = csvToBean.iterator();
        System.out.println("here");
        System.out.println(myUserIterator.next().toString());
        System.out.println("itterated");
        reader.close();*/
    }
}
