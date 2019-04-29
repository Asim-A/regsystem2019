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

    private ObjectProperty<LocalDate> dato;
    private StringProperty fakturaadresse;
    private IntegerProperty forsikringsnummer;
    private IntegerProperty ubetalte_erstatninger; //TODO usikker på type, må granskes.
    //ListProperty<Forsikring> forsikringer;
    //ListProperty<Skademelding> skademeldinger;
    private List<Forsikring> forsikringer;
    private List<Skademelding> skademeldinger;

    public Kunde(){}

    public Kunde(String fornavn,
                 String etternavn,
                 String fakturaadresse) {
        super(fornavn, etternavn);
        this.fakturaadresse = new SimpleStringProperty(fakturaadresse);
        this.forsikringsnummer = new SimpleIntegerProperty(22);
        this.dato = new SimpleObjectProperty<>(LocalDate.now(ZoneId.of("GMT+1")));
        forsikringer = new ArrayList<>();
        skademeldinger = new ArrayList<>();
        this.ubetalte_erstatninger = new SimpleIntegerProperty(skademeldinger.size());
    }

    public Kunde(String fornavn,
                 String etternavn,
                 String fakturaadresse,
                 int forsikringsnummer,
                 int ubetalte_erstatninger) {
        super(fornavn, etternavn);
        this.fakturaadresse = new SimpleStringProperty(fakturaadresse);
        this.forsikringsnummer = new SimpleIntegerProperty(forsikringsnummer);
        this.ubetalte_erstatninger = new SimpleIntegerProperty(ubetalte_erstatninger);
        this.dato = new SimpleObjectProperty<>(LocalDate.now(ZoneId.of("GMT+1")));
        forsikringer = new ArrayList<Forsikring>();
        skademeldinger = new ArrayList<Skademelding>();
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
        sb.append(getDato());
        for (Forsikring f : forsikringer) sb.append(f.toString());
        for (Skademelding s : skademeldinger) sb.append(s.toString());
        return sb.toString();
    }

    public String getFakturaadresse() {
        return fakturaadresse.get();
    }

    public void setFakturaadresse(String fakturaadresse) {
        this.fakturaadresse.set(fakturaadresse);
    }

    public int getForsikringsnummer() {
        return forsikringsnummer.get();
    }


    public void setForsikringsnummer(int forsikringsnummer) {
        this.forsikringsnummer.set(forsikringsnummer);
    }

    public int getUbetalte_erstatninger() {
        return ubetalte_erstatninger.get();
    }

    public IntegerProperty ubetalte_erstatningerProperty() {
        return ubetalte_erstatninger;
    }

    public void setUbetalte_erstatninger(int ubetalte_erstatninger) {
        this.ubetalte_erstatninger.set(ubetalte_erstatninger);
    }

    public LocalDate getDato() {
        return dato.get();
    }

    public ObjectProperty<LocalDate> datoProperty() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato.set(dato);
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
