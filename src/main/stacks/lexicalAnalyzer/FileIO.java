package main.stacks.lexicalAnalyzer;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * Utility class that is used to interact with text files
 */
public class FileIO {

    /**
     * Returns the content of a text file in the form of a String
     * @param fileName extension of the file that will be found using relative path
     * @return
     */
    public String getStringFromFile(String fileName){
        URL url = getClass().getResource(fileName);
        File file = new File(url.getPath());

        String content = null;
        try {
            content = new Scanner(file).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }
}
