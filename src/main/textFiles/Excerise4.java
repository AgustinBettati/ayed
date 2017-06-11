package main.textFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version 1.0
 */
public class Excerise4 {

    public static void main(String[] args) {
        sortCountriesOnTxt("countries");
    }

    public static void sortCountriesOnTxt(String fileName){

        String[] fields;

        try {
         FileReader fileReader = new FileReader(fileName);
         BufferedReader bufferedReader= new BufferedReader(fileReader);
         String line= bufferedReader.readLine();

         FileWriter lessThan30 = new FileWriter("CountriesLessThan30mill",true);
         FileWriter moreThan30 = new FileWriter("CountriesMoreThan30mill",true);
         while (line!= null) {
             fields=line.split(";");

             double population= Double.parseDouble(fields[1]);

             if (population<30) {
                 lessThan30.write(line + "\n");
             }
             else {
                 moreThan30.write(line+ "\n");
             }
             line  = bufferedReader.readLine();
         }
         bufferedReader.close();
         lessThan30.close();
         moreThan30.close();
        }
        catch (IOException e){
         System.out.println("File do not exist!");
        }
    }
}
