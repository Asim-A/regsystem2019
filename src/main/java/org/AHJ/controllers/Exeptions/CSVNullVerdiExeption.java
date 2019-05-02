package org.AHJ.controllers.Exeptions;

public class CSVNullVerdiExeption extends Exception{


    public CSVNullVerdiExeption(){
        super("Null verdi i CSV fil ");
    }

    public CSVNullVerdiExeption(int i){
        super("Null verdi i CSV fil Ved Linje"+i);
    }
}
