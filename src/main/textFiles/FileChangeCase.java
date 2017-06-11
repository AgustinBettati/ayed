package main.textFiles;

import main.util.Scanner;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class FileChangeCase {

    public static void main(String[] args) {
        String nameOfFile = Scanner.getString("Enter name of file: ");
        int operation = Scanner.getInt("Make copy of file to upper (1) or lower (0) case? ");

        if (operation == 1){
            makeCopyOfFileChangingCase(nameOfFile,true);
        }
        else {
            makeCopyOfFileChangingCase(nameOfFile,false);
        }
    }

    public static void makeCopyOfFileChangingCase(String nameOfFile, boolean toUpper){
        String text = "";
        try {
            FileReader fr = new FileReader(nameOfFile);
            int a = fr.read();
            while (a != -1){
                text += (char) a;
                a = fr.read();
            }
            fr.close();
        }
        catch (IOException e){
            System.out.println("File was not found");
        }
        if(toUpper) {
            text = text.toUpperCase();
        }
        else {
            text = text.toLowerCase();
        }
        try {
            FileWriter fw = new FileWriter(nameOfFile + "UpperCase");
            fw.write(text);
            fw.close();
        }
        catch (IOException e){
            System.out.println("Could not create file");
        }
    }




}
