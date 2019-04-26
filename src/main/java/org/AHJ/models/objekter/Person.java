package org.AHJ.models.objekter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Person {

    private StringProperty fornavn;
    private StringProperty etternavn;

    public Person(){}

    public Person(String fornavn, String etternavn){
        this.fornavn = new SimpleStringProperty(fornavn);
        this.etternavn = new SimpleStringProperty(etternavn);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(fornavn).append(";");
        sb.append(etternavn).append(";");

        return sb.toString();
    }

    public String getFornavn() {
        return fornavn.get();
    }

    public StringProperty fornavnProperty() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn.set(fornavn);
    }

    public String getEtternavn() {
        return etternavn.get();
    }

    public StringProperty etternavnProperty() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn.set(etternavn);
    }
}
