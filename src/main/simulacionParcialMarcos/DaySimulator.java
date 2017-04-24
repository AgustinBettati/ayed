package main.simulacionParcialMarcos;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by marcos on 19/4/17.
 */
public class DaySimulator {
//    int timer;
//    int endTime;
//    public DaySimulator(int endTime) {
//       timer=0;
//       this.endTime=endTime;
//    }

    private static Metrovias metrovias;
    private static int timer;

    public DaySimulator(Metrovias metrovias) {
        this.metrovias = metrovias;
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter amount of windows:");
        int a= scanner.nextInt();

        metrovias=new Metrovias(57600,a);


        for(timer=0; timer<=metrovias.getWorkingTimeDuration();timer+=10){
            cycle();

            if (timer==metrovias.getWorkingTimeDuration()-30){
                lastCycle();
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

    public static void cycle(){
        Random r= new Random();
        for (int i=0; i<=4; i++){
            int amountOfWindows = metrovias.getWindows().size();
            int window= r.nextInt(amountOfWindows);
            metrovias.getWindows().goTo(window);
            metrovias.getWindows().getActual().addWaitingPerson(new Person(timer));

        }
         metrovias.getWindows().goTo(0);
        for (int i=0; i<metrovias.getWindows().size();i++){
            metrovias.getWindows().goTo(i);
            metrovias.getWindows().getActual().checkIfFree();
            metrovias.getWindows().getActual().tryAttendNext(timer);


        }


    }
    public static void lastCycle(){
        metrovias.getWindows().goTo(0);
        for (int i=0; i<metrovias.getWindows().size();i++){
            metrovias.getWindows().goTo(i);
            while (metrovias.getWindows().getActual().thereArePeopleWaiting()){
                metrovias.getWindows().getActual().checkIfFree();
                metrovias.getWindows().getActual().attendNext(timer);
            }
//            metrovias.getWindows().goNext();

        }
    }

}
