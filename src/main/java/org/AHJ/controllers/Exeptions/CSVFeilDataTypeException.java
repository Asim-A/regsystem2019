package org.AHJ.controllers.Exeptions;

public class CSVFeilDataTypeException extends Exception{

    public CSVFeilDataTypeException(){
        super("Feil Data Type");
    }

    public CSVFeilDataTypeException(int linje){
        super("Feil Data Type På linje "+linje+" i CSV fil");
    }
}
