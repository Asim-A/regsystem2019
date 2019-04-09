package org.AHJ.controllers.Filhåndtering;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.AHJ.models.objekter.Kunder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LasterCSV implements LastInnFil {
   private ArrayList<String[]> data = new ArrayList<>();


    @Override
    public void lastInnFil(File file, Kunder kunder) throws Exception {
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(csvParser).withSkipLines(0).build();
      //  ArrayList<Kunde> kundeListe = (ArrayList<Kunde>) kunder.getKundeListe();
        ValiderOpplasting(csvReader);


    }
    public void ValiderOpplasting(CSVReader csvReader) throws IOException {
        String[] linje;
        while ((linje = csvReader.readNext()) != null) {
            data.add(linje);
        }
        csvReader.close();
        for (int i = 0 ; i < data.size();i++) {
            for(String[] line : data)
                for (int j = 0 ; j<line.length;j++){
                    System.out.print(line[j]);
                }
            System.out.println();
        }

    }
}
