package main.textFiles;

import main.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 */
public class Exercise5 {

    public static void main(String[] args) {
        String nameOfFile = Scanner.getString("Enter name of file: ");
        int amtOfPopulation = Scanner.getInt("Enter amount of population to make division (in millions): ");
        int operation = Scanner.getInt("Posible operations:\n" +
                " 1- only save name and PBI.\n" +
                " 2- only save name and population.\n" +
                " 3- save all information.\n" +
                "\n");
        switch (operation) {
            case 1:
                divideFileSavingSpecificData(nameOfFile, amtOfPopulation,true,false);
                break;
            case 2:
                divideFileSavingSpecificData(nameOfFile, amtOfPopulation,false, true);
                break;
            case 3:
                divideFileSavingSpecificData(nameOfFile, amtOfPopulation,true, true);
                break;
        }
    }

    public static void divideFileSavingSpecificData(String nameOfFile,int amtOfPopulation, boolean savePBI, boolean savePopulation){
        try {
            FileReader fileReader = new FileReader(nameOfFile);
            BufferedReader bufferedReader= new BufferedReader(fileReader);
            String line= bufferedReader.readLine();

            FileWriter lessThan = new FileWriter("CountriesLessThan"+amtOfPopulation+"mill",true);
            FileWriter moreThan = new FileWriter("CountriesMoreThan"+amtOfPopulation+"mill",true);
            while (line!= null) {
                String[] fields = line.split(";");

                double population= Double.parseDouble(fields[1]);
                FileWriter fileToWrite;
                if (population<amtOfPopulation) {
                    fileToWrite = lessThan;
                }
                else {
                    fileToWrite = moreThan;
                }
                fileToWrite.write(fields[0] + ";");
                if(savePBI && !savePopulation){
                    fileToWrite.write(fields[2] + "\n");
                }
                else if(!savePBI && savePopulation){
                    fileToWrite.write(fields[1] + "\n");
                }
                else{
                    fileToWrite.write(fields[1] + ";"+ fields[2]+ "\n");
                }

                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            lessThan.close();
            moreThan.close();
        }
        catch (IOException e){
            System.out.println("File do not exist!");
        }


    }
}
