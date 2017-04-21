package main.metroviasAgustin;

import struct.impl.StaticList;

import java.util.concurrent.ThreadLocalRandom;
/**
 * @author Agustin Bettati
 * @version 1.0
 *
 * This class represents a service that attends clients with a certain amount of windows.
 * It has a fixed frequency of 5 clients entering every 10 seconds.
 */
public class Service {
    private StaticList<Window> windows;
    private int amountOfWindows;

    /**
     * Creates the service initializing the amount of windows necessary.
     * @param amountOfWindows
     */
    public Service(int amountOfWindows){
        this.amountOfWindows = amountOfWindows;
        windows = new StaticList<>();

        for(int i =0; i< amountOfWindows; i++){
            windows.insertNext(new Window(0.7));
        }
    }

    /**
     * Responds to a new cicle of action, meaning 10 seconds have passed and a 5 new clients appear.
     * Each window will also take action because there is a 0.3 probability it attended a client.
     * @param currentTime
     */
    public void newCicle(int currentTime){
        enqueueFiveNewClients(currentTime);

        int size = windows.size();
        for(int i = 0; i < size; i++){
            windows.goTo(i);
            Window aWindow = windows.getActual();
            aWindow.newCicle(currentTime);
        }
    }

    /**
     * Responds to the last cicles of the work day, in which all the clients will be attend.
     * @param currentTime
     */
    public void lastCicles(int currentTime){
        enqueueFiveNewClients(currentTime);

        int size = windows.size();
        for(int i = 0; i < size; i++){
            windows.goTo(i);
            Window aWindow = windows.getActual();
            aWindow.lastCicles(currentTime);
        }
    }

    private void enqueueFiveNewClients(int currentTime){
        for (int i =0; i< 5; i++){
            int randomIndex = ThreadLocalRandom.current().nextInt(0, amountOfWindows-1 + 1);
            windows.goTo(randomIndex);
            windows.getActual().enqueueNewClient(currentTime);
        }
    }

    /**
     * Returns the average time waited by the clients in a certain window.
     * @param indexOfWindow
     * @return
     */
    public double getAverageTimeWaited(int indexOfWindow){
        windows.goTo(indexOfWindow);
        Window window = windows.getActual();

        double numberOfClientsAttended = window.getAmountOfAttendedClients();
        StaticList<Integer> waitedTimeByEachClient = window.getTimeWaitedByEachClient();

        double sum = 0;
        int size = waitedTimeByEachClient.size();
        for(int i = 0; i < size; i++){
            waitedTimeByEachClient.goTo(i);
            sum += waitedTimeByEachClient.getActual();
        }

        return sum/numberOfClientsAttended;
    }

    /**
     * Returns the total amount of money collect by a certain window.
     * @param indexOfWindow
     * @return
     */
    public double getAmountOfMoneyCollected(int indexOfWindow){
        windows.goTo(indexOfWindow);
        Window window = windows.getActual();
        return window.getAmountOfMoneyCollected();
    }

    /**
     * Returns the amount of free time a window had during the day of work.
     * @param indexOfWindow
     * @return
     */
    public int getAmountOfFreeTime(int indexOfWindow){
        windows.goTo(indexOfWindow);
        Window window = windows.getActual();
        return window.getAmountOfFreeTime();
    }

}
