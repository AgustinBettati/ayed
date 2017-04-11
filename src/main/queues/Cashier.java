package main.queues;

import struct.impl.queues.DynamicQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by marcos on 11/4/17.
 */
public class Cashier {
    private boolean isOccupied;
    private int scheduledTime;
    private int minTime;
    private int maxTime;
    private DynamicQueue<Client> clients;


    public Cashier(int minTime, int maxTime) {
        this.isOccupied=false;
        this.minTime = minTime;
        this.maxTime = maxTime;
        clients=new DynamicQueue<Client>();
    }
    public void newClientEnqueue(Client client){
        clients.enqueue(client);
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public void takeAction(int currentTime){
        if(!clients.isEmpty() && !isOccupied){
            isOccupied = true;
            determineNewScheduledTime(currentTime);
        }
        if (currentTime==scheduledTime){
            clients.dequeue();
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

