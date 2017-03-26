package main.stacks;

import java.io.*;
import java.net.URL;
import java.util.Scanner;


public class LexicalAnalyzer {


    public static boolean lexicalAnalyzer(String fileName){
        FileIO io = new FileIO();
        String content = io.getStringFromFile("content.txt");
        content.replaceAll("\\s+",""); // removes all spaces.
        char[] arrayOfContent = content.toCharArray();

        if(arrayOfContent.length % 2 != 0){
            return false;
        }
        
        for(int i = 0; i < arrayOfContent.length; i++){

        }


        return true;
    }

}
