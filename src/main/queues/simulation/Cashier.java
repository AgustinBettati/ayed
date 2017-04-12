package main.queues.simulation;

import struct.impl.queues.DynamicQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Cashier {
    private boolean isOccupied;
    private int scheduledTime;
    private int minTime;
    private int maxTime;
    private DynamicQueue<Client> clients;
    private Bank bank;


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

    public void determineNewScheduledTime(int currentTime){
        int randomNumber= ThreadLocalRandom.current().nextInt(minTime,maxTime+1);
        scheduledTime = currentTime + randomNumber;
    }
}

