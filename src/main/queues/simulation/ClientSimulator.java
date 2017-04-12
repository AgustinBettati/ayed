package main.queues.simulation;


import java.util.concurrent.ThreadLocalRandom;

public class ClientSimulator {

    private int scheduledTime;

    public ClientSimulator(){
        scheduledTime = 0;
    }

    public int amountOfNewClients(int currentTime){

        if(currentTime == scheduledTime){
            scheduledTime = 90 + currentTime;
            // range from 0 to 4 clients
            return ThreadLocalRandom.current().nextInt(0,10+1);
        }
        else
            return 0;
    }



}
