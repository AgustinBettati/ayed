package main.orderedList;

import main.util.Scanner;
import struct.istruct.list.GeneralList;

import java.util.Map;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class is used to interact with the bus system through the terminal.
 */
public class Main {

    public static void main(String[] args) {
        BusSystem system = new BusSystem();

        //Some buses are initially added in order to see the functionality of the
        //system.
        system.addNewBus(new Bus(57,20,40,true));
        system.addNewBus(new Bus(57,40,30,false));
        system.addNewBus(new Bus(57,10,35,true));
        system.addNewBus(new Bus(105,20,40,true));
        system.addNewBus(new Bus(105,50,20,true));

        int action;
        do{
            System.out.println("Operations:\n" +
                    " 1- Add new bus to system.\n" +
                    " 2- Remove bus from system.\n" +
                    " 3- Obtain ordered list of buses.\n" +
                    " 4- Amount of buses for disabled in each line.\n" +
                    " 5- Amount of buses with more than 27 seats in each line. \n"+
                    " 6- Save system information in file. \n"+
                    " 7- Retrieve system information from file. \n"+
                    " 8- Close program.\n");

            action = Scanner.getInt("Enter a operation: ");

            switch (action){
                case 1:
                    System.out.println("New bus is being created.");
                    int lineNumber = Scanner.getInt("Enter line number: ");
                    int localNumber = Scanner.getInt("Enter local number: ");
                    int amtOfSeats = Scanner.getInt("Amount of seats: ");
                    int forDisabled = Scanner.getInt("Has seats for disabled: (1 for true, 0 for false)");
                    system.addNewBus(new Bus(lineNumber,localNumber,amtOfSeats, forDisabled == 1));
                    break;
                case 2:
                    System.out.println("A bus is being removed.");
                    lineNumber = Scanner.getInt("Enter line number: ");
                    localNumber = Scanner.getInt("Enter local number: ");
                    system.removeBus(new Bus(lineNumber,localNumber));
                    break;
                case 3:
                    GeneralList<Bus> orderedList = system.obtainOrderedList();
                    for (int i = 0; i < orderedList.size(); i++) {
                        orderedList.goTo(i);
                        System.out.println(orderedList.getActual());

                    }
                    break;
                case 4:
                    for (Map.Entry<Integer, Integer> entry : system.amtOfBusesForDisabledInEachLine().entrySet()) {
                        System.out.println("Line: " +entry.getKey() + " -> Amount of buses for disabled: " + entry.getValue());
                    }
                    break;
                case 5:
                    for (Map.Entry<Integer, Integer> entry : system.amtOfBusesWithMoreThan27SeatInEachLine().entrySet()) {
                        System.out.println("Line: " +entry.getKey() + " -> More than 27 seats: " + entry.getValue());
                    }
                    break;
                case 6:
                    system.saveOrderedListInFile("list");
                    break;
                case 7:
                    system.retrieveObjectFromFile("list");
                    break;
                case 8:
                    System.out.println("System has closed.");
                    break;
                default:
                    System.out.println("Please enter a valid operation.");
            }

        }while (action != 8);
    }
}
