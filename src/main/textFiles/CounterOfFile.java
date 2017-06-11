package main.textFiles;

import main.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 */
public class CounterOfFile {
    public static void main(String[] args) {
        String nameOfFile = Scanner.getString("Enter name of file: ");
        int operation = Scanner.getInt("Posible operations:\n" +
                " 1- count amount of characters.\n" +
                " 2- count amount of lines.\n" +
                " 3- give inoformation of both.\n" +
                "\n");
        switch (operation) {
            case 1:
                System.out.println(amountOfCharacters(nameOfFile));
                break;
            case 2:
                System.out.println(amountOfLines(nameOfFile));
                break;
            case 3:
                System.out.println("characters: " + amountOfCharacters(nameOfFile) +
                        ", lines: " + amountOfLines(nameOfFile));
                break;
        }
    }

    public static int amountOfCharacters(String nameOfFile){
        int counter = 0;
        try {
            FileReader fileReader = new FileReader(nameOfFile);

            int a = fileReader.read();
            while (a != -1) {
                counter++;
                a = fileReader.read();
            }
            fileReader.close();
        }
        catch (IOException e){
            System.out.println("File do not exist!");
        }
        return counter;
    }

    public static int amountOfLines(String nameOfFile){
        int counter = 0;
        try {
            FileReader fileReader = new FileReader(nameOfFile);
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();
            while (line != null) {
                counter++;
                line = br.readLine();
            }
            br.close();
        }
        catch (IOException e){
            System.out.println("File do not exist!");
        }
        return counter;
    }

}
