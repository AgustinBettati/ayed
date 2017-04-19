package main.metroviasAgustin;

import struct.impl.StaticList;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Service {
    private StaticList<Window> windows;
    private int amountOfWindows;

    public Service(int amountOfWindows){
        this.amountOfWindows = amountOfWindows;
        windows = new StaticList<>();

        for(int i =0; i< amountOfWindows; i++){
            windows.insertNext(new Window());
        }
        System.out.println(windows.size());
    }

    public void newCicle(int currentTime){
        for (int i =0; i< 5; i++){
            int randomIndex = ThreadLocalRandom.current().nextInt(0, amountOfWindows-1 + 1);
            windows.goTo(randomIndex);
            windows.getActual().enqueueNewClient(currentTime);
        }

        int size = windows.size();
        windows.goTo(windows.size()-1);
        for(int i = 0; i < size; i++){
            Window aWindow = windows.getActual();
            aWindow.newCicle(currentTime);
            if(windows.getActualPosition() != 0) {
                windows.goPrev();
            }
        }
    }

    public void lastCicles(int currentTime){
        for (int i =0; i< 5; i++){
            int randomIndex = ThreadLocalRandom.current().nextInt(0, amountOfWindows + 1);
            windows.goTo(randomIndex);
            windows.getActual().enqueueNewClient(currentTime);
        }

        int size = windows.size();
        windows.goTo(windows.size()-1);
        for(int i = 0; i < size; i++){
            Window aWindow = windows.getActual();
            aWindow.lastCicles(currentTime);
            if(windows.getActualPosition() != 0) {
                windows.goPrev();
            }
        }
    }

    public double getAverageTimeWaited(int indexOfWindow){
        windows.goTo(indexOfWindow);
        Window window = windows.getActual();

        int numberOfClientsAttended = window.getAmountOfAttendedClients();
        StaticList<Integer> waitedTimeByEachClient = window.getTimeWaitedByEachClient();

        int size = waitedTimeByEachClient.size();
        int sum = 0;
        for(int i = 0; i < size; i++){
            sum += waitedTimeByEachClient.getActual();
            if(waitedTimeByEachClient.getActualPosition() != 0) {
                waitedTimeByEachClient.goPrev();
            }
        }

        return sum/numberOfClientsAttended;

    }

}
