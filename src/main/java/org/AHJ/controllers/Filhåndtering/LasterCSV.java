package org.AHJ.controllers.Filhåndtering;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.AHJ.modeller.forsikringer.Båtforsikring;
import org.AHJ.modeller.objekter.Kunde;
import org.AHJ.modeller.objekter.Kunder;

import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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
            Kunde kunde = new Kunde(row[0],row[1],row[3],Integer.valueOf(row[4]),Integer.valueOf(row[5]));
            if (!row[6].equals("[]")){
                lagForsikringer(kunde, formaterForsikringKolonne(row[6]));
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
        for (Kunde kunde : kunder.getKundeListe()){
            System.out.println(kunde.toString());
        }
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

    private String[] formaterForsikringKolonne(String forsikringer){
        StringBuilder sb = new StringBuilder(forsikringer);
        sb.deleteCharAt(0).delete(sb.length()-2,sb.length());//setLength(forsikringer.length()-1);
        String forsikringerString = sb.toString();
        return forsikringerString.split("\\*, ");
    }

    private void lagForsikringer(Kunde kunde, String[] forsikringerArray) throws ParseException {
        String[] forsikringFelt;
        for (String s : forsikringerArray) {
            forsikringFelt=s.split(";");
            switch (forsikringFelt[0]){
                case "Båtforsikring" :
                    kunde.addForsikring(new Båtforsikring(Double.valueOf(forsikringFelt[1]),
                            Double.valueOf(forsikringFelt[2]),forsikringFelt[3],
                            getLocalDateFromString(forsikringFelt[4]),forsikringFelt[5],
                            forsikringFelt[6],forsikringFelt[7],
                            forsikringFelt[8],forsikringFelt[9],
                            forsikringFelt[10]));
                    System.out.println("Båtforsikring"+kunde.getForsikringer().toString());
                    break;
                case "Fritidsboligforsikring" :
                    //new Fritidsboligforsikring();
                    break;
                case "Hus_ogInnboforsikring" :
                    // new Hus_ogInnboforsikring()
                    break;

                case "Reiseforsikring" :
                    break;
            }
        }
    }

    private LocalDate getLocalDateFromString(String date) throws ParseException {
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
        Date date1=format.parse(date);
        return  LocalDate.ofInstant(date1.toInstant(), ZoneId.systemDefault());
    }
}
