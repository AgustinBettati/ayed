package main.stacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by agustin on 24/3/17.
 */
public class FileIO {

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
