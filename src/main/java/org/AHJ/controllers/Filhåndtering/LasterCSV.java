package org.AHJ.controllers.Filhåndtering;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.AHJ.controllers.Exeptions.CSVFeilAntallDataKolonnerExeption;
import org.AHJ.controllers.Exeptions.CSVNullVerdiExeption;
import org.AHJ.modeller.forsikringer.Baatforsikring;
import org.AHJ.modeller.forsikringer.Fritidsboligforsikring;
import org.AHJ.modeller.forsikringer.Hus_og_innboforsikring;
import org.AHJ.modeller.forsikringer.Reiseforsikring;
import org.AHJ.modeller.objekter.Kunde;
import org.AHJ.modeller.objekter.Kunder;
import org.AHJ.modeller.skjema.Skademelding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class LasterCSV implements LastInnFil {


    @Override
    public void lastInnFil(File file, Kunder kunder) throws CSVFeilAntallDataKolonnerExeption, Exception {
        kunder.setKundeListe(new ArrayList<>());
        System.out.println("Size of kundeListe in LASTERCSV PRE read "+kunder.getKundeListe().size());
        BufferedReader br = new BufferedReader(new FileReader(file));
    /*   while (str = br.readLine()==null){
        }*/
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(csvParser).withSkipLines(0).build();
        String[] row;
        while (( row = csvReader.readNext()) != null) {
            if (!(row.length==8)){
                throw new CSVFeilAntallDataKolonnerExeption();
            }
            sjekkForNullVerdier(row);
            Kunde kunde = new Kunde(row[0],row[1],row[2],
                        row[3],Integer.valueOf(row[4]),Integer.valueOf(row[5]));
            System.out.println(Arrays.toString(row));
            if (!row[6].equals("[]")){
                System.out.println(row[6]);
                    splitVerdier(kunde, formaterListeKolonne(row[6]));
                    if (!row[7].equals("[]")){
                    splitVerdier(kunde, formaterListeKolonne(row[7]));
                    System.out.println("SKADEMELDINGER NOT EMPTY");
                    System.out.println(row[7]);
                    // new skademelding
                    // add skademelding
                }
            }
                kunder.getKundeListe().add(kunde);
                // kunder.getKundeListe().add(new Kunde(row[i++],row[++i],row[++i],Integer.valueOf(row[++i]),Integer.valueOf(row[++i])));
        }
        csvReader.close();
        System.out.println("DONE");
        System.out.println("Size of kundeListe in LASTERCSV AFTER read "+kunder.getKundeListe().size());
    }

    private void sjekkForNullVerdier(String[] row) throws CSVNullVerdiExeption {
        for (int i =0; i<row.length; i++){
            if ("".equals(row[i])){
                throw new CSVNullVerdiExeption();
            }
        }
    }

    private String[] formaterListeKolonne(String kolonneData){
        StringBuilder sb = new StringBuilder(kolonneData);
        sb.deleteCharAt(0).delete(sb.length()-2,sb.length());
        String forsikringerString = sb.toString();
        return forsikringerString.split("\\*, ");
    }

    private void splitVerdier(Kunde kunde, String[] forsikringerArray) throws ParseException {
        for (String s : forsikringerArray) {
            lagForsikringer(kunde,s.split(";"));
        }
    }

    private void lagForsikringer(Kunde kunde, String[] feltVerdier) throws ParseException {
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
            case "Hus_og_innboforsikring" :
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
            case "Skademelding" :
                kunde.addSkademelding(new Skademelding(getLocalDateFromString(feltVerdier[1]),
                        feltVerdier[2],feltVerdier[3],feltVerdier[4],feltVerdier[5],
                        Double.valueOf(feltVerdier[6]),Double.valueOf(feltVerdier[7])));
        }
    }

    private LocalDate getLocalDateFromString(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1=format.parse(date);
        return  LocalDate.ofInstant(date1.toInstant(), ZoneId.systemDefault());
    }
}
