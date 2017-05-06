package main.orderedList;

import struct.impl.lists.StaticList;

import java.io.*;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        StaticList<Integer> listOfNumbers = new StaticList<>(20);

        listOfNumbers.insertNext(1);
        listOfNumbers.insertNext(2);
        listOfNumbers.insertNext(3);
        listOfNumbers.insertNext(4);
        listOfNumbers.insertNext(5);
        listOfNumbers.insertNext(6);

        saveObjectInFile(listOfNumbers, "list");

        StaticList<Integer> retrievedList = (StaticList<Integer>)retrieveObjectFromFile("list");

        for (int i = 0; i < retrievedList.size(); i++) {
            retrievedList.goTo(i);
            int number = retrievedList.getActual();
            System.out.println(number);
        }
    }



    public static void saveObjectInFile(Object object, String fileName){
        try {
            FileOutputStream fileOut =
                    new FileOutputStream( fileName + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in /" + fileName + ".ser");
        }catch(IOException i) {
            i.printStackTrace();
        }
    }

    public static Object retrieveObjectFromFile(String fileName){
        Object e = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName+".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = in.readObject();
            in.close();
            fileIn.close();

        }catch(IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException j) {
            j.printStackTrace();
        }
        return e;
    }
}
