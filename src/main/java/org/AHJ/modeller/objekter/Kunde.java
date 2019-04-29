package org.AHJ.modeller.objekter;

import javafx.beans.property.*;
import org.AHJ.modeller.skjermaer.Skademelding;
import org.AHJ.modeller.forsikringer.Forsikring;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class Kunde extends Person implements Serializable {

    private LocalDate dato;
    private String fakturaadresse;
    private Integer forsikringsnummer;
    private Integer ubetalte_erstatninger; //TODO usikker på type, må granskes.
    //ListProperty<Forsikring> forsikringer;
    //ListProperty<Skademelding> skademeldinger;
    private List<Forsikring> forsikringer;
    private List<Skademelding> skademeldinger;

    public Kunde(){}

    public Kunde(String fornavn,
                 String etternavn,
                 String fakturaadresse,
                 Integer forsikringsnummer,
                 Integer ubetalte_erstatninger) {
        super(fornavn, etternavn);
        this.fakturaadresse = fakturaadresse;
        this.forsikringsnummer = forsikringsnummer;
        this.ubetalte_erstatninger = ubetalte_erstatninger;
        this.dato = LocalDate.now(ZoneId.of("GMT+1"));
        forsikringer = new ArrayList<Forsikring>();
     //   forsikringer = new SimpleListProperty<Forsikring>(forsikringer);
        skademeldinger = new ArrayList<Skademelding>();
    //    skademeldinger = new SimpleListProperty<Skademelding>(skademeldinger);
    }


    public void addForsikring(Forsikring forsikring){
        forsikringer.add(forsikring);
    }
    public void addSkademelding(Skademelding skademelding){
        skademeldinger.add(skademelding);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(fakturaadresse);
        sb.append(forsikringsnummer);
        sb.append(ubetalte_erstatninger);
        sb.append(dato);
        for (Forsikring f : forsikringer) sb.append(f.toString());
        for (Skademelding s : skademeldinger) sb.append(s.toString());
        return sb.toString();
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
        return ubetalte_erstatninger;
    }

    public void setUbetalte_erstatninger(Integer ubetalte_erstatninger) {
        this.ubetalte_erstatninger = ubetalte_erstatninger;
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
}
