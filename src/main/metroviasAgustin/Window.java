package main.metroviasAgustin;

import struct.impl.StaticList;
import struct.impl.queues.DynamicQueue;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Window {

    private int amountOfFreeTime;
    private int amountOfAttendedClients;
    private StaticList<Integer> timeWaitedByEachClient;
    private DynamicQueue<Client> queueOfWindow;



    public Window(){
        amountOfFreeTime = 0;
        amountOfAttendedClients = 0;
        timeWaitedByEachClient = new StaticList<>();
        queueOfWindow = new DynamicQueue<>();
    }

    public void newCicle(int currentTime){
        checkForFreeTime();
        checkForAttendedClient(0.3, currentTime);
    }

    public void lastCicles(int currentTime){
        checkForFreeTime();

        int size = queueOfWindow.size();
        for(int i =0; i< size; i++){
            checkForAttendedClient(1,currentTime);
        }

    }

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
        if(probability(probabilityOfTrue)){
            timeWaitedByEachClient.insertNext(queueOfWindow.dequeue().getWaitedTime(currentTime));
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

}
