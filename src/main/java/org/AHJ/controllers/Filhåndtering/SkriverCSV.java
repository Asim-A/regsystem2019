package org.AHJ.controllers.Filhåndtering;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SkriverCSV extends SkrivTilFil{

    public void skrivCSV()  {

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
            }*/
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
        }
    }

}
