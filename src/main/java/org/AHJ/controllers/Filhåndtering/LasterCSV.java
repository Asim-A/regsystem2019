package org.AHJ.controllers.Filhåndtering;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.AHJ.models.objekter.Kunde;
import org.AHJ.models.objekter.Kunder;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LasterCSV implements LastInnFil {


    @Override
    public void lastInnFil(File file, Kunder kunder) throws Exception {
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(csvParser).withSkipLines(0).build();


        //  ArrayList<Kunde> kundeListe = (ArrayList<Kunde>) kunder.getKundeListe();
        ArrayList<String[]> data = new ArrayList<>();
        String[] linje;
        while ((linje = csvReader.readNext()) != null) {
            data.add(linje);
        }
        csvReader.close();
        for (int i = 0 ; i < data.size();i++) {
            for(String[] line : data)
                for (int j = 0 ; j<line.length;j++){System.out.print(line[j]);}
            System.out.println();
        }
    }
}
