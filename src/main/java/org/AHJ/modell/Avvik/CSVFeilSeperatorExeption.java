package org.AHJ.modell.Avvik;

public class CSVFeilSeperatorExeption extends Exception{

    public CSVFeilSeperatorExeption(){
        super("Feil Seperator i csv fil");
    }

    public CSVFeilSeperatorExeption(int linje){
        super("Feil Seperator i csv fil på linje "+linje);
    }

}
