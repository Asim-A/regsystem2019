package org.AHJ.models.objekter;

public abstract class Person {

    String fornavn;
    String etternavn;


    public Person(String fornavn, String etternavn){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(fornavn).append(";");
        sb.append(etternavn).append(";");

        return sb.toString();
    }
}
