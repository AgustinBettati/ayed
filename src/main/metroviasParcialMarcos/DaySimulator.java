package main.metroviasParcialMarcos;

import java.util.Scanner;

/**
 * @author Marcos Khabie
 * @version 1.0
 *
 * A class that simulates a day of work of Metrovias.
 */
public class DaySimulator {

    private static Metrovias metrovias;
    private static int timer;


    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter amount of windows between 3 and 10:");
        int a= scanner.nextInt();



        metrovias=new Metrovias(57600,a);


        for(timer=0; timer<=metrovias.getWorkingTimeDuration();timer+=10){
            metrovias.cycle(timer);

            if (timer==metrovias.getWorkingTimeDuration()-30){
                metrovias.lastCycle(timer);
            }

        }

        metrovias.getWindows().goTo(0);
        for (int i=0; i<metrovias.getWindows().size();i++){
            metrovias.getWindows().goTo(i);

            System.out.println("Window: "+ i);
            System.out.println("Money earned:"+ metrovias.getWindows().getActual().getEarnings());
            System.out.println("Average people's wait:"+ metrovias.getWindows().getActual().getAverageWait());
            System.out.println("Free time:"+metrovias.getWindows().getActual().getFreeTime());

//            metrovias.getWindows().goNext();

        }

    }



}
