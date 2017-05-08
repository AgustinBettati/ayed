package main.parcialBettatiAgustin;

import struct.impl.lists.StaticList;
import struct.impl.queues.StaticQueue;

/**
 * @author Agustin Bettati
 */
public class Attraction {

    private final String name;
    private final int capacity;
    private StaticQueue<Client> normalQueue;
    private StaticQueue<Client> fastQueue;
    private StaticList<Client> clientsInRide;
    private StaticList<Client> clientsThatFinishedRide;
    private StaticList<Integer> timeWaitedInNormalQueue;
    private int timeOfNextRide;

    public Attraction(String name, int capacity) {
        timeOfNextRide = 0;
        this.name = name;
        this.capacity = capacity;
        normalQueue = new StaticQueue<>(10);
        fastQueue = new StaticQueue<>(10);
        clientsInRide = new StaticList<>();
        clientsThatFinishedRide = new StaticList<>();
        timeWaitedInNormalQueue = new StaticList<>();

    }

    public void takeAction(int time){
        clientsThatFinishedRide = new StaticList<>();

        if(timeOfNextRide <= time){

            for (int i = 0; i < clientsInRide.size(); i++){
                clientsInRide.goTo(i);
                Client client = clientsInRide.getActual();
                clientsThatFinishedRide.insertNext(client);
                if(client.usedNormalQueue()){
                    timeWaitedInNormalQueue.insertNext(
                            client.timeWaitedInNormalQueue(time));
                }
            }

            StaticList<Client> newRide = new StaticList<>();

            int i = 0;

            while (!fastQueue.isEmpty() && i < capacity){
                newRide.insertNext(fastQueue.dequeue());
                i++;
            }

            while (!normalQueue.isEmpty() && i < capacity){
                newRide.insertNext(normalQueue.dequeue());
                i++;
            }

            if(newRide.size() > 0){
                timeOfNextRide = time + 5;
            }
            clientsInRide = newRide;
        }
    }

    public void recievesNewClient(Client aClient, int time){
        if(aClient.hasFastPass() && fastQueue.size() < 20){
            fastQueue.enqueue(aClient);
            aClient.goesToAFastPass();
        }
        else {
            aClient.entersNormalQueue(time);
            normalQueue.enqueue(aClient);
        }
    }

    public double getAverageTimeWaitedInNormalQueue(){
        double sumOfMinutes = 0;

        for(int i =0; i< timeWaitedInNormalQueue.size(); i++){
            timeWaitedInNormalQueue.goTo(i);
            sumOfMinutes += timeWaitedInNormalQueue.getActual();
        }
        return sumOfMinutes/(double)timeWaitedInNormalQueue.size();
    }

    public StaticList<Client> getClientsThatFinishedRide(){
        return clientsThatFinishedRide;
    }

    public int getAmountOfClientsInAttraction(){
        return fastQueue.size() + normalQueue.size() + clientsInRide.size();
    }

    public int getPopularity() {
        int amtOfPeopleInQueues = normalQueue.size() + fastQueue.size();

        if(amtOfPeopleInQueues == 0){
            return 10;
        }
        else if( amtOfPeopleInQueues < 80){
            return (int)(-0.1125*amtOfPeopleInQueues) +10;
        }
        else {
            return 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
