package main.metroviasAgustin;

import struct.impl.lists.StaticList;
import struct.impl.queues.StaticQueue;

/**
 * @author Agustin Bettati
 * @version 1.0
 * This class represents a window that has a 0.3 probability of attending a client every 10 seconds.
 */
public class Window {

    private double fee;
    private int amountOfFreeTime;
    private int amountOfAttendedClients;
    private StaticList<Integer> timeWaitedByEachClient;
    private StaticQueue<Client> queueOfWindow;


    /**
     * Creates a window with a certain fee for each trip.
     * @param feeOfTrip
     */
    public Window(double feeOfTrip){
        fee = feeOfTrip;
        amountOfFreeTime = 0;
        amountOfAttendedClients = 0;
        timeWaitedByEachClient = new StaticList<>();
        queueOfWindow = new StaticQueue<>(10);
    }

    /**
     * Responds to a new cicle of action, where it will determine if a client will be attended.
     * @param currentTime
     */
    public void newCicle(int currentTime){
        checkForFreeTime();
        checkForAttendedClient(0.3, currentTime);
    }

    /**
     * Responds to the last cicles of action, where all clients in the queue will be attended.
     * @param currentTime
     */
    public void lastCicles(int currentTime){
        checkForFreeTime();

        int size = queueOfWindow.size();
        for(int i =0; i< size; i++){
            checkForAttendedClient(1,currentTime);
        }

    }

    /**
     * Enqueues a new client.
     * @param currentTime
     */
    public void enqueueNewClient(int currentTime){
        Client newClient = new Client(currentTime);
        queueOfWindow.enqueue(newClient);
    }

    private void checkForFreeTime(){
        if(queueOfWindow.isEmpty()){
            amountOfFreeTime += 10;
        }
    }

    private void checkForAttendedClient(double probabilityOfTrue, int currentTime){
        if(probability(probabilityOfTrue) && !queueOfWindow.isEmpty() ){
            int timeWaitedByClient = queueOfWindow.dequeue().getWaitedTime(currentTime);
            timeWaitedByEachClient.insertNext(timeWaitedByClient);
            amountOfAttendedClients++;
        }
    }

    private boolean probability(double probabilityTrue)
    {
        return Math.random() >= 1.0 - probabilityTrue;
    }

    public int getAmountOfFreeTime() {
        return amountOfFreeTime;
    }

    public int getAmountOfAttendedClients() {
        return amountOfAttendedClients;
    }

    public StaticList<Integer> getTimeWaitedByEachClient() {
        return timeWaitedByEachClient;
    }

    public double getAmountOfMoneyCollected(){
        return fee * amountOfAttendedClients;
    }
}
