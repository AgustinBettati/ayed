package main.simulacionParcialMarcos;

import struct.impl.lists.StaticList;

import java.util.Random;

/**
 * @author Marcos Khabie
 * @version 1.0
 *
 * A class that represents the metrovias service.
 */
public class Metrovias {
    private int workingTimeDuration;
    private StaticList<Window> windows;

    /**
     * A constructor that creates a Metrovias service and initializates its variables.
     * @param workingTimeDuration
     * @param amountOfWindows
     */
    public Metrovias(int workingTimeDuration, int amountOfWindows) {
        this.workingTimeDuration = workingTimeDuration;
        windows=new StaticList<Window>(amountOfWindows);
        windows.goTo(0);
        for (int i = 0; i<amountOfWindows;i++){
            windows.insertNext(new Window());
        }


    }

    public int getWorkingTimeDuration() {
        return workingTimeDuration;
    }

    public StaticList<Window> getWindows() {
        return windows;
    }

    /**
     * Represents what happens in one cycle(10 seconds).
     * @param timer
     */
    public void cycle(int timer){
        Random r= new Random();
        for (int i=0; i<=4; i++){
            int amountOfWindows = windows.size();
            int window= r.nextInt(amountOfWindows);
            windows.goTo(window);
            windows.getActual().addWaitingPerson(new Person(timer));

        }
        windows.goTo(0);
        for (int i=0; i<windows.size();i++){
            windows.goTo(i);
            windows.getActual().checkIfFree();
            windows.getActual().tryAttendNext(timer);


        }


    }

    /**
     * Represents the lasts cycles of the day.
     * @param timer
     */
    public void lastCycle(int timer){
        this.getWindows().goTo(0);
        for (int i=0; i<windows.size();i++){
            windows.goTo(i);
            while (windows.getActual().thereArePeopleWaiting()){
               windows.getActual().checkIfFree();
                windows.getActual().attendNext(timer);
            }


        }
    }
}
