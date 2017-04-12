package main.queues.simulation;

import java.util.concurrent.ThreadLocalRandom;


/**
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version 1.0
 *
 * This class simulates the coming of a certain amount of clients every 1.5 minutes.
 */
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
