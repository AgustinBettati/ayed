package main.queues.simulation;

import struct.impl.queues.DynamicQueue;
import java.util.concurrent.ThreadLocalRandom;


/**
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version 1.0
 *
 * This class represents a cashier that has its respective queue and attends its clients
 * with a speed ranging from two values given.
 */
public class Cashier {
    private boolean isOccupied;
    private int scheduledTime;
    private int minTime;
    private int maxTime;
    private DynamicQueue<Client> clients;
    private Bank bank;

    /**
     * Creates a cashier given a bank and a certain time range that represents the amount of seconds
     * it takes to attend a client.
     * @param aBank
     * @param minTime
     * @param maxTime
     */
    public Cashier(Bank aBank,int minTime, int maxTime) {
        this.isOccupied=false;
        this.minTime = minTime;
        this.maxTime = maxTime;
        clients=new DynamicQueue<>();
        this.bank = aBank;
    }

    public int amountOfClients(){
        return clients.size();
    }

    public void newClientEnqueue(Client aClient){
        clients.enqueue(aClient);
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    /**
     * Given a certain time, it will see if its clientes have been attended, or is a cliente is ready
     * to be attended.
     * @param currentTime
     */
    public void takeAction(int currentTime){
        if(!clients.isEmpty() && !isOccupied){
            isOccupied = true;
            determineNewScheduledTime(currentTime);
        }
        if (currentTime==scheduledTime&& isOccupied()){
            clients.dequeue();
            bank.clientWasAttended();
            if(clients.isEmpty())
                isOccupied = false;
            else
                determineNewScheduledTime(currentTime);

        }

    }

    /**
     * Determines a time in the future in which the cashier will have attended the new client.
     * @param currentTime
     */
    public void determineNewScheduledTime(int currentTime){
        int randomNumber= ThreadLocalRandom.current().nextInt(minTime,maxTime+1);
        scheduledTime = currentTime + randomNumber;
    }
}

