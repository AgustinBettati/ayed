package main.tablaHash;

import struct.impl.lists.DynamicList;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Dictionary test = new Dictionary();

        test.addNewWord("Hegh");
        DynamicList<String> similarWords = test.getSimilarWords("High");

        int size = similarWords.size();
        for (int i = 0; i < size; i++) {
            similarWords.goTo(i);
            System.out.println(similarWords.getActual());
        }


    }
}
