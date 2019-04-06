package org.AHJ.controllers.Filhåndtering;

//KUN TIL TEST
public class KUNDETEST {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String gender;

    KUNDETEST() {
    };

    KUNDETEST(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name+":" +age+":"+gender;
    }
}