package main.parcialNachoMarcosKhabie;

import struct.impl.lists.StaticList;
import struct.impl.queues.DynamicQueue;
import struct.impl.queues.StaticQueue;

/**
 * @author Marcos Khabie
 */
public class Attraction implements Comparable<Attraction> {

    private final String name;
    private final int capacity;
    private double popularity;
    private StaticList<Client> clientsInside;
    private StaticQueue<Client> fastPassClients;
    private DynamicQueue<Client> normalClients;
    private int amountOfPeopleThatPlay;
    private int peoplesDelay;

    public Attraction(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        popularity=10;
        clientsInside= new StaticList<>(capacity);
        fastPassClients=new StaticQueue<Client>(20);
        normalClients=  new DynamicQueue<Client>();
    }

    public int getPopularity() {
       popularity= ((-0.1125)*(normalClients.size()+fastPassClients.size()))+10;
       return (int) popularity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }


    public StaticList<Client> getClientsInside() {
        return clientsInside;
    }

    public StaticQueue<Client> getFastPassClients() {
        return fastPassClients;
    }

    public DynamicQueue<Client> getNormalClients() {
        return normalClients;
    }

    public void play(double actualTime){
        Client client;
        clientsInside.goTo(0);
        while ((!fastPassClients.isEmpty())&&clientsInside.size()<capacity){
            client=fastPassClients.dequeue();
            client.setPlayedTime(actualTime); //agregado
            clientsInside.insertNext(client);
            amountOfPeopleThatPlay++;
            client.useFastPass();
            peoplesDelay+=client.waitedTime();

        }
        while (clientsInside.size()<capacity&&(!normalClients.isEmpty())){
            client=normalClients.dequeue();
            clientsInside.insertNext(client);
            client.setPlayedTime(actualTime);
            peoplesDelay+=client.waitedTime();
            amountOfPeopleThatPlay++;

        }


    }

    public int calculateAverageWait(){
        return peoplesDelay/amountOfPeopleThatPlay;
    }
    @Override
    public int compareTo(Attraction o) {
        if (this.getPopularity()<o.getPopularity()){
            return -1;
        }

        else if (this.getPopularity()>o.getPopularity()) {
            return 1;
        }
        return 0;
    }


}
