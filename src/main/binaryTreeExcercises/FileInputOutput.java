package main.binaryTreeExcercises;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * functional class that is used to interact with text files.
 */
public class FileInputOutput {


    /**
     * Returns the content of a text file in the form of a String
     * @param fileName extension of the file that will be found using relative path
     * @return
     */
    public String getStringFromFile(String fileName){
        File file = new File(fileName);

        String content = null;
        try {
            content = new Scanner(file).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * Creates a text file and stores the content contained in the string.
     * @param content
     * @param fileName
     */
    public void writeStringToTxtFile(String content, String fileName){
        try {
            try (PrintStream out = new PrintStream(new FileOutputStream(fileName))) {
                out.print(content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
