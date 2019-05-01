package org.AHJ.modeller.objekter;

import java.io.Serializable;

public abstract class Person implements Serializable {

    private String fornavn;
    private String etternavn;

    public Person(){}

    public Person(String fornavn, String etternavn){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(fornavn);
        sb.append(etternavn);

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
}
