package main.queues.simulation;


import java.util.concurrent.ThreadLocalRandom;

public class ClientSimulator{

    private int scheduledTime;
    private int minRange;
    private int maxRange;

    public ClientSimulator(int min, int max){
        scheduledTime = 0;
        minRange = min;
        maxRange = max;

    }

    public int amountOfNewClients(int currentTime){

        if(currentTime == scheduledTime){
            scheduledTime = 90 + currentTime;
            // range from 0 to 4 clients
            return ThreadLocalRandom.current().nextInt(minRange,maxRange+1);
        }
        else
            return 0;
    }



}
