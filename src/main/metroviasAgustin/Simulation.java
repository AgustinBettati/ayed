package main.metroviasAgustin;
import java.util.Scanner;

/**
 * @author Agustin Bettati
 * @version 1.0
 *
 * This class simulates a full day of work of the metrovia service
 */
public class Simulation {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount of windows (from 3 to 10): ");
        int amountOfWindows = scanner.nextInt();


        Service metrovia = new Service(amountOfWindows);

        for(int i = 0; i <= 57600; i+= 10){

            if(i < 57570) {
                metrovia.newCicle(i);
            }
            else{
                metrovia.lastCicles(i);
            }
        }
        System.out.println("-- General statistics for each window -- \n");
        for(int i = 0; i < amountOfWindows; i++){
            System.out.println("Window number " + (i+1));
            System.out.println("Average waited time:       " + String.format("%.2f", metrovia.getAverageTimeWaited(i)));
            System.out.println("Amount of money collected: " + String.format("%.2f", metrovia.getAmountOfMoneyCollected(i)));
            System.out.println("Amount of free time:       " + metrovia.getAmountOfFreeTime(i));
            System.out.println("    ----------");

        }
    }
}
