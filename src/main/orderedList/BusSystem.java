package main.orderedList;

import struct.impl.sortedLists.DynamicSortedList;
import struct.istruct.list.GeneralList;

import java.io.*;
import java.util.HashMap;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class is used to manage buses, providing relevant information.
 */
public class BusSystem {

    private DynamicSortedList<Bus> orderedList = new DynamicSortedList<>();

    public BusSystem() {
        orderedList = new DynamicSortedList<>();
    }

    public void addNewBus(Bus aBus){
        orderedList.insert(aBus);
    }

    public void removeBus(Bus aBus){
        orderedList.removeWithKey(aBus);
    }

    public GeneralList<Bus> obtainOrderedList(){
        return orderedList;
    }

    public void saveOrderedListInFile(String fileName){
        try {
            FileOutputStream fileOut =
                    new FileOutputStream( fileName + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(orderedList);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in /" + fileName + ".ser");
        }catch(IOException i) {
            i.printStackTrace();
        }
    }

    public void retrieveObjectFromFile(String fileName){
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
        orderedList = (DynamicSortedList<Bus>) e;
    }

    public HashMap<Integer, Integer> amtOfBusesForDisabledInEachLine(){
        HashMap<Integer, Integer> values  = new HashMap<>();
        if(!orderedList.isVoid()){
            int i = 0;
            orderedList.goTo(i);
            int lineNumber = orderedList.getActual().getLineNumber();
            values.put(lineNumber, 0);
            while(i < orderedList.size()){
                if(lineNumber != orderedList.getActual().getLineNumber()){
                    lineNumber = orderedList.getActual().getLineNumber();
                    values.put(lineNumber, 0);
                }
                if(orderedList.getActual().hasSeatsForDisabled()){
                    values.put(lineNumber,values.get(lineNumber) + 1);
                }
                i++;
                orderedList.goTo(i);
            }
        }
        return values;
    }

    public HashMap<Integer, Integer> amtOfBusesWithMoreThan27SeatInEachLine(){
        HashMap<Integer, Integer> values  = new HashMap<>();
        if(!orderedList.isVoid()){
            int i = 0;
            orderedList.goTo(i);
            int lineNumber = orderedList.getActual().getLineNumber();
            values.put(lineNumber, 0);
            while(i < orderedList.size()){
                if(lineNumber != orderedList.getActual().getLineNumber()){
                    lineNumber = orderedList.getActual().getLineNumber();
                    values.put(lineNumber, 0);
                }
                if(orderedList.getActual().getAmtOfSeats() > 27){
                    values.put(lineNumber,values.get(lineNumber) + 1);
                }
                i++;
                orderedList.goTo(i);
            }
        }
        return values;
    }

}
