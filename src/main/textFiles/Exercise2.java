package main.textFiles;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version 1.0
 */

public class Exercise2 {
    public static void main(String[] args) {

        System.out.println(characterOcurrencesCounter('c',"MarkTest"));
    }
    public static int characterOcurrencesCounter(char c, String nameOfTheFileToAnalyze) {
        int amountOfOcurrences = 0;
        try {
            FileReader fileReader = new FileReader(nameOfTheFileToAnalyze);

            int a = fileReader.read();

            while (a != -1) {
                if (a == c) {
                    amountOfOcurrences++;
                }
                a = fileReader.read();
            }
            fileReader.close();
        }
        catch (IOException e){

            System.out.println("File do not exist!");

        }
    return amountOfOcurrences;
    }


}
