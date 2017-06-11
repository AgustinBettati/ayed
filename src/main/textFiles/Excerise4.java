package main.textFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class Excerise4 {

 public void sortCountriesOnTxt(String fileName){

     String[] camps;

     try {
         FileReader fileReader = new FileReader(fileName);
         BufferedReader bufferedReader= new BufferedReader(fileReader);
         String line= bufferedReader.readLine();

         while (line!= null) {
             camps=line.split(";");

             double population= Double.parseDouble(camps[1]);

             if (population<30000000) {
                 FileWriter fileWriter= new FileWriter("Countries With Less Than 30000000 ",true);
                 fileWriter.write(line);
                 fileWriter.close();
             }
             else {
                 FileWriter fileWriter= new FileWriter("Countries With more Than 30000000 ",true);
                 fileWriter.write(line);
                 fileWriter.close();
             }
         }
         fileReader.close();
     }
     catch (IOException e){

         System.out.println("File do not exist!");

     }


 }
}
