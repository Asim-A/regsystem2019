package org.AHJ.modell.objekter;

import org.AHJ.modell.skjema.Skademelding;
import org.AHJ.modell.forsikringer.Forsikring;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class Kunde implements Serializable {

    private String fornavn;
    private String etternavn;
    private LocalDate dato;
    private String fakturaadresse;
    private Integer forsikringsnummer;
    private Integer ubetalte_erstatninger; //TODO usikker på type, må granskes.
    private List<Forsikring> forsikringer;
    private List<Skademelding> skademeldinger;

    public Kunde(){}

    public Kunde(String fornavn,
                 String etternavn,
                 String fakturaadresse) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fakturaadresse = fakturaadresse;
        this.forsikringsnummer = 22;
        this.dato = LocalDate.now(ZoneId.of("GMT+1"));
        forsikringer = new ArrayList<>();
        skademeldinger = new ArrayList<>();
        this.ubetalte_erstatninger = 0;
    }

    public Kunde(String fornavn,
                 String etternavn,
                 String dato,
                 String fakturaadresse,
                 int forsikringsnummer,
                 int ubetalte_erstatninger
                 ) throws ParseException {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fakturaadresse = fakturaadresse;
        this.forsikringsnummer = forsikringsnummer;
        this.ubetalte_erstatninger = ubetalte_erstatninger;
        this.dato = getLocalDateFromString(dato);
        forsikringer = new ArrayList<>();
        skademeldinger = new ArrayList<>();
    }

    public void addForsikring(Forsikring forsikring){
        forsikringer.add(forsikring);
    }
    public void addSkademelding(Skademelding skademelding){
        skademeldinger.add(skademelding);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(fornavn);
        sb.append(etternavn);
        sb.append(fakturaadresse);
        sb.append(forsikringsnummer);
        sb.append(ubetalte_erstatninger);
        sb.append(dato);
        for (Forsikring f : forsikringer) sb.append(f.toString());
        for (Skademelding s : skademeldinger) sb.append(s.toString());
        return sb.toString();
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public String getFakturaadresse() {
        return fakturaadresse;
    }

    public void setFakturaadresse(String fakturaadresse) {
        this.fakturaadresse = fakturaadresse;
    }

    public Integer getForsikringsnummer() {
        return forsikringsnummer;
    }

    public void setForsikringsnummer(Integer forsikringsnummer) {
        this.forsikringsnummer = forsikringsnummer;
    }

    public Integer getUbetalte_erstatninger() {
        oppdaterUbetalte_Erstatninger();
        return ubetalte_erstatninger;
    }

    public void setUbetalte_erstatninger(Integer ubetalte_erstatninger) {
        oppdaterUbetalte_Erstatninger();
    }

    public List<Forsikring> getForsikringer() {
        return forsikringer;
    }

    public void setForsikringer(List<Forsikring> forsikringer) {
        this.forsikringer = forsikringer;
    }

    public List<Skademelding> getSkademeldinger() {
        return skademeldinger;
    }

    public void setSkademeldinger(List<Skademelding> skademeldinger) {
        this.skademeldinger = skademeldinger;
    }

    public void oppdaterUbetalte_Erstatninger(){
        if (skademeldinger.size()==0){
            ubetalte_erstatninger = 0;
            return;
        }
        ubetalte_erstatninger = 0;
        for (Skademelding skademelding : skademeldinger){
            if (skademelding.getTakseringsbelop_av_skade()>skademelding.getUtbetalt_erstatningsbelop()){
                ubetalte_erstatninger++;
            }
        }
    }

    private LocalDate getLocalDateFromString(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1=format.parse(date);
        return  LocalDate.ofInstant(date1.toInstant(), ZoneId.systemDefault());
    }
}
