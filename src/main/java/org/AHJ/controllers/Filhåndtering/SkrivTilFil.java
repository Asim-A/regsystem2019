package org.AHJ.controllers.Filhåndtering;

public abstract class SkrivTilFil {

    SkriverCSV skriverCSV;
    SkriverJOBJ skriverJOBJ;

    public void skrivTilCSV(){
        skriverCSV.skrivCSV();
    }

    public void skrivTilJOBJ(){
        skriverJOBJ.skrivJOBJ();
    }



}
