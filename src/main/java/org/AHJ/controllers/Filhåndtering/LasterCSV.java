package org.AHJ.controllers.Filhåndtering;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LasterCSV implements LastInnFil {

    @Override
    public void lastInnFil(File file, List kundeListe) throws Exception {
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(csvParser).withSkipLines(0).build();
        List<String[]> ar = new ArrayList<>();
        String[] linje;
        while ((linje = csvReader.readNext()) != null) {
            ar.add(linje);
        }
        csvReader.close();
        csvReader.close();
        for (int i = 0 ; i < ar.size();i++) {
            for(String tekst : ar.get(i))
                System.out.print(tekst);
            System.out.println();
        }
    }
}
