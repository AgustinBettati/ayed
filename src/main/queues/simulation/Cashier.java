package main.queues.simulation;

import struct.impl.queues.DynamicQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Cashier {
    private boolean isOccupied;
    private int scheduledTime;
    private int minTime;
    private int maxTime;
    private DynamicQueue<Client> clients;
    private int clientsAttended=0;



    public Cashier(int minTime, int maxTime) {
        this.isOccupied=false;
        this.minTime = minTime;
        this.maxTime = maxTime;
        clients=new DynamicQueue<>();
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
            clientsAttended++;
            if(clients.isEmpty())
                isOccupied = false;
            else
                determineNewScheduledTime(currentTime);

        }

    }

    public int getClientsAttended() {
        return clientsAttended;
    }

    public void determineNewScheduledTime(int currentTime){
        int randomNumber= ThreadLocalRandom.current().nextInt(minTime,maxTime+1);
        scheduledTime = currentTime + randomNumber;
    }
}

