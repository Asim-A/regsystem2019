package org.AHJ.controllers.Filhåndtering;

import org.AHJ.models.objekter.DataManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SkriverCSV extends SkrivTilFil{

    @Override
    public void skrivTilFil(File file) {
        System.out.println("skriverCSV");
        List<KUNDETEST> objList = new ArrayList<>();
        for(int i = 0 ; i<1000;i++) {
            objList.add(new KUNDETEST("Asim", 30, "Male", "Slotsplassen 1"));
            objList.add(new KUNDETEST("peder", 30, "Male", "Slotsplassen 1"));
            objList.add(new KUNDETEST("racel", 22, "female", "Slotsplassen 1"));
            objList.add(new KUNDETEST("dfg", 12, "Male", "Slotsplassen 1"));
        }
        try {
            //skriver
            PrintWriter out = new PrintWriter(file);
            System.out.println("writerCreated");

            StringBuilder kunderToString = new StringBuilder();

            for (KUNDETEST kundetest : objList) out.println(kundetest.toString());
            out.close();
        } catch (FileNotFoundException e) {

        }
    }

    public void skrivCSV()  {
        /*
        File data = new File("data.csv");
        List<KUNDETEST> objList = new ArrayList<>();

        objList.add(new KUNDETEST("Asim", 30, "Male"));
        objList.add(new KUNDETEST("hamzakun", 25, "Female"));
        System.out.println("personsCreated");

        try {
            //skriver
            PrintWriter out = new PrintWriter(data);
            System.out.println("writerCreated");
            for (int i =0; i<objList.size();i++)out.println(objList.get(i).toString());
           /* while (i<2 ||objList.listIterator().hasNext()){
                out.print(objList.listIterator().next().toString());
                i++;
            }*//*
            out.close();

        } catch (FileNotFoundException e) {
            PrintWriter out = null;
            try {
                out = new PrintWriter("/data.csv");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            System.out.println("writerCreated");
            for (int i =0; i<objList.size();i++)out.print(objList.get(i).toString());
        } catch (IOException e ){
            System.out.println("tg");
        }*/
    }

}
