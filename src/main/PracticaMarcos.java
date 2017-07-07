package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class PracticaMarcos {

    public static void main(String[] args) {
        parcial("testParcial");
    }

    public static void parcial(String nameOfFile){
        try {
            FileReader fileReader= new FileReader(nameOfFile);
            BufferedReader bufferedReader= new BufferedReader(fileReader);
            FileWriter fileWriter= new FileWriter(nameOfFile+"solo las primeras letras");
            String line=bufferedReader.readLine();
            String result= "";
            while (line!= null){
                result+= line.charAt(0) + "\n";
                 line=  bufferedReader.readLine();
            }
            fileReader.close();
            bufferedReader.close();
            fileWriter.write(result);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("pija");
        }

    }
}
