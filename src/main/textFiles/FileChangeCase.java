package main.textFiles;

import main.util.Scanner;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
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
        String nameOfNewFile;
        if(toUpper) {
            text = text.toUpperCase();
            nameOfNewFile = nameOfFile + "UpperCase";
        }
        else {
            text = text.toLowerCase();
            nameOfNewFile = nameOfFile + "LowerCase";
        }
        try {
            FileWriter fw = new FileWriter(nameOfNewFile);
            fw.write(text);
            fw.close();
        }
        catch (IOException e){
            System.out.println("Could not create file");
        }
    }




}
