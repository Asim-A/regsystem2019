package org.AHJ.modell.Filhåndtering;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.AHJ.modell.DataValidering.CSVDataValiderer;
import org.AHJ.modell.Avvik.*;
import org.AHJ.modell.Avvik.CSVFeilAntallDataKolonnerExeption;
import org.AHJ.modell.Avvik.CSVNullVerdiExeption;
import org.AHJ.modell.forsikringer.Baatforsikring;
import org.AHJ.modell.forsikringer.Fritidsboligforsikring;
import org.AHJ.modell.forsikringer.Hus_og_innboforsikring;
import org.AHJ.modell.forsikringer.Reiseforsikring;
import org.AHJ.modell.objekter.Kunde;
import org.AHJ.modell.objekter.Kunder;
import org.AHJ.modell.skjema.Skademelding;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class LasterCSV implements LastInnFil {

    CSVDataValiderer csvDataValiderer;

    @Override
    public void lastInnFil(File file, Kunder kunder) throws Exception{
        erTom(file);
        kunder.setKundeListe(new ArrayList<>());
        csvDataValiderer=new CSVDataValiderer();
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(csvParser).withSkipLines(0).build();
        int linjeNr=0;
        String[] rad;
        while (( rad = csvReader.readNext()) != null) {
            linjeNr++;
            validerRad(rad, linjeNr);
            validerVerdier(rad,linjeNr);
            Kunde kunde = new Kunde(rad[0],rad[1],rad[2],
                        rad[3],Integer.valueOf(rad[4]),Integer.valueOf(rad[5]));
            System.out.println(Arrays.toString(rad));
            if (!rad[6].equals("[]")){
                System.out.println(rad[6]);
                    splitVerdier(kunde, formaterListeKolonne(rad[6]));

            }
            if (!rad[7].equals("[]")){
                splitVerdier(kunde, formaterListeKolonne(rad[7]));
            }
                kunder.getKundeListe().add(kunde);
        }
        csvReader.close();
    }

    private void validerRad(String[] rad, int linjeNr) throws CSVFeilSeperatorExeption, CSVFeilAntallDataKolonnerExeption{
        if (!(rad.length==8)){
            if (rad.length==1){
                throw new CSVFeilSeperatorExeption(linjeNr);
            }
            throw new CSVFeilAntallDataKolonnerExeption(linjeNr);
        }
    }

    private void validerVerdier(String[] row, int linje) throws CSVFeilDataTypeException,CSVNullVerdiExeption, CSVFeilTekstFormat {
        for (int i =0; i<6; i++){
            if ("".equals(row[i])){
                throw new CSVNullVerdiExeption(linje);
            }
        }
        if(
                !(csvDataValiderer.validerTekst(row[0]) &&
                csvDataValiderer.validerTekst(row[1]) &&
                csvDataValiderer.validerTekstMedTall(row[3]) &&
                csvDataValiderer.validerInt(row[4]) &&
                csvDataValiderer.validerInt(row[5]))
        ) {
            throw new CSVFeilDataTypeException(linje);
        }
        validerDatoFelt(row[2],linje);
        validerListeFelt(row[6],linje);
        validerListeFelt(row[7],linje);
    }

    private void validerListeFelt(String feltVerdier, int linje) throws CSVFeilTekstFormat{
        if (!(feltVerdier.charAt(0)==('[')) && !(feltVerdier.charAt(feltVerdier.length()-1)==(']'))){
            throw new CSVFeilTekstFormat(linje);
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
            lagListeObjekter(kunde,s.split(";"));
        }
    }

    private void lagListeObjekter(Kunde kunde, String[] feltVerdier) throws ParseException {
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
        Date date1= format.parse(date);
        return  LocalDate.ofInstant(date1.toInstant(), ZoneId.systemDefault());
    }

    private void validerDatoFelt(String date, int linje) throws CSVFeilDataTypeException {
        try {
            getLocalDateFromString(date);
        } catch (ParseException pe){
            throw new CSVFeilDataTypeException(linje);
        }
    }

    private void erTom(File file) throws Exception{
        if (file.length() == 0){
            throw new Exception("Filen er tom");
        }
    }
}
