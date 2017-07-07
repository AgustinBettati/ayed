package main.tablaHash;

import struct.impl.lists.DynamicList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Dictionary {
    private DynamicList<String>[] table;

    public Dictionary(){
        table = new DynamicList[26000];
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("commonWords.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line= bufferedReader.readLine();
            while (line!=null){
                addNewWord(line);
                line=bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addNewWord(String word){
        if(!wordIsPresent(word)) {
            int index = hash(word);
            if (table[index] == null) {
                table[index] = new DynamicList<>();
            }

            table[index].insertNext(word);
        }
    }

    public boolean wordIsPresent(String word){
        int index = hash(word);
        if(table[index] != null) {
            DynamicList<String> list = table[index];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.goTo(i);
                if (list.getActual().equals(word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public DynamicList<String> getSimilarWords(String word){
        int index = hash(word);
        if(table[index] == null){
            return new DynamicList<>();
        }
        return table[index];
    }
    /**
     * Devuelve valores entre 0 y 25999.
     * @param word
     * @return
     */
    private int hash(String word){
        String soundex = soundex(word);
        String number = ((int)soundex.charAt(0) - 65) + soundex.substring(1,4);
        return Integer.parseInt(number);
    }
    private String soundex(String s) {
        char[] x = s.toUpperCase().toCharArray();
        char firstLetter = x[0];

        // convert letters to numeric code
        for (int i = 0; i < x.length; i++) {
            switch (x[i]) {

                case 'B':
                case 'F':
                case 'P':
                case 'V':
                    x[i] = '1';
                    break;
                case 'C':
                case 'G':
                case 'J':
                case 'K':
                case 'Q':
                case 'S':
                case 'X':
                case 'Z':
                    x[i] = '2';
                    break;

                case 'D':
                case 'T':
                    x[i] = '3';
                    break;

                case 'L':
                    x[i] = '4';
                    break;

                case 'M':
                case 'N':
                    x[i] = '5';
                    break;

                case 'R':
                    x[i] = '6';
                    break;

                default:
                    x[i] = '0';
                    break;
            }
        }

        // remove duplicates
        String output = "" + firstLetter;
        for (int i = 1; i < x.length; i++)
            if (x[i] != x[i-1] && x[i] != '0')
                output += x[i];

        // pad with 0's or truncate
        output = output + "0000";
        return output.substring(0, 4);
    }

}
