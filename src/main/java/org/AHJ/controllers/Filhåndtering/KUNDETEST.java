package org.AHJ.controllers.Filhåndtering;

//KUN TIL TEST
public class KUNDETEST {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String gender;
    private String fakturaadresse;
    private int forsikringsnummer;
    private static int counter;

    KUNDETEST(String name, int age, String gender,String fakturaadresse) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.fakturaadresse=fakturaadresse;
        this.forsikringsnummer = counter+1;
        counter=counter+1;
    }

    @Override
    public String toString() {
        return name+";" +age+";"+gender+";"+fakturaadresse+";"+forsikringsnummer;
    }
}