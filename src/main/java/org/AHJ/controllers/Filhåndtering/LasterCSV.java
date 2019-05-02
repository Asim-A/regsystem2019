package org.AHJ.controllers.Filhåndtering;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.AHJ.controllers.Exeptions.FeilAntallDataKolonnerExeption;
import org.AHJ.modeller.forsikringer.Baatforsikring;
import org.AHJ.modeller.forsikringer.Fritidsboligforsikring;
import org.AHJ.modeller.forsikringer.Hus_og_innboforsikring;
import org.AHJ.modeller.forsikringer.Reiseforsikring;
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
    public void lastInnFil(File file, Kunder kunder) throws FeilAntallDataKolonnerExeption, Exception {
        kunder.setKundeListe(new ArrayList<>());
        System.out.println("Size of kundeListe in LASTERCSV PRE read "+kunder.getKundeListe().size());
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(csvParser).withSkipLines(0).build();
        //  ArrayList<Kunde> kundeListe = (ArrayList<Kunde>) kunder.getKundeListe();
        ArrayList<String[]> data = new ArrayList<>();
        String[] row;
        int i=0;
        while (( row = csvReader.readNext()) != null) {
            if (!(row.length==8)){
                throw new FeilAntallDataKolonnerExeption();
            }
            Kunde kunde = new Kunde(row[0],row[1],row[2],
                        row[3],Integer.valueOf(row[4]),Integer.valueOf(row[5]));
            System.out.println(Arrays.toString(row));
            if (!row[6].equals("[]")){
                System.out.println(row[6]);
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

        csvReader.close();
        System.out.println("DONE");
        System.out.println("Size of kundeListe in LASTERCSV AFTER read "+kunder.getKundeListe().size());
    }

    private String[] formaterForsikringKolonne(String forsikringer){

        StringBuilder sb = new StringBuilder(forsikringer);
        sb.deleteCharAt(0).delete(sb.length()-2,sb.length());//setLength(forsikringer.length()-1);
        String forsikringerString = sb.toString();
        System.out.println(Arrays.toString(forsikringerString.split("\\*, ")));
        return forsikringerString.split("\\*, ");
    }

    private void lagForsikringer(Kunde kunde, String[] forsikringerArray) throws ParseException {
        String[] feltVerdier;
        for (String s : forsikringerArray) {
            feltVerdier=s.split(";");
            switch (feltVerdier[0]){
                case "Baatforsikring" :
                    kunde.addForsikring(new Baatforsikring(Double.valueOf(feltVerdier[1]),
                            Double.valueOf(feltVerdier[2]),feltVerdier[3],
                            getLocalDateFromString(feltVerdier[4]),feltVerdier[5], feltVerdier[6],
                            feltVerdier[7], feltVerdier[8],feltVerdier[9], feltVerdier[10]));
                    break;
                case "Fritidsboligforsikring" :
                    kunde.addForsikring(new Fritidsboligforsikring(Double.valueOf(feltVerdier[1]),
                            Double.valueOf(feltVerdier[2]),feltVerdier[3],
                            getLocalDateFromString(feltVerdier[4]),feltVerdier[5],
                            Integer.valueOf(feltVerdier[6]), feltVerdier[7], feltVerdier[8],feltVerdier[9],
                            Double.valueOf(feltVerdier[10]),Double.valueOf(feltVerdier[11]),
                            Double.valueOf(feltVerdier[12])));
                    break;
                case "Hus_og_Innboforsikring" :
                    kunde.addForsikring(new Hus_og_innboforsikring(Double.valueOf(feltVerdier[1]),
                            Double.valueOf(feltVerdier[2]),feltVerdier[3],
                            getLocalDateFromString(feltVerdier[4]),feltVerdier[5],
                            Integer.valueOf(feltVerdier[6]), feltVerdier[7], feltVerdier[8],feltVerdier[9],
                            Double.valueOf(feltVerdier[10]),Double.valueOf(feltVerdier[11]),
                            Double.valueOf(feltVerdier[12])));
                    break;
                case "Reiseforsikring" :
                    kunde.addForsikring(new Reiseforsikring(Double.valueOf(feltVerdier[1]),
                            Double.valueOf(feltVerdier[2]),feltVerdier[3],
                            getLocalDateFromString(feltVerdier[4]),feltVerdier[5],
                            Double.valueOf(feltVerdier[6])));
                    break;
            }
        }
    }

    private LocalDate getLocalDateFromString(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1=format.parse(date);
        System.out.println(date);
        return  LocalDate.ofInstant(date1.toInstant(), ZoneId.systemDefault());
    }
}
