package main.queues.simulation;

import struct.impl.queues.DynamicQueue;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class OneQueue implements Strategy {
    @Override
    public void enqueue(Bank aBank,int amountOfClients) {
        DynamicQueue<Client> alternativeQueue = aBank.getAlternativeQueue();
        ArrayList<Cashier> cashiers = aBank.getCashiers();

        // reorder main queue and its cashiers
        while(!alternativeQueue.isEmpty()&& !getAvailableCashierIndex(cashiers).isEmpty() ) {

            ArrayList<Integer> listOfIndexThatAreNotOccupied = getAvailableCashierIndex(cashiers);

            if (listOfIndexThatAreNotOccupied.size() == 1) {
                cashiers.get(listOfIndexThatAreNotOccupied.get(0))
                        .newClientEnqueue(alternativeQueue.dequeue());
            } else if (listOfIndexThatAreNotOccupied.size() == 2) {
                int randomIndex = ThreadLocalRandom.current().nextInt(0, 1 + 1);
                cashiers.get(listOfIndexThatAreNotOccupied.get(randomIndex))
                        .newClientEnqueue(alternativeQueue.dequeue());
            } else if (listOfIndexThatAreNotOccupied.size() == 3) {
                int randomIndex = ThreadLocalRandom.current().nextInt(0, 2 + 1);
                cashiers.get(listOfIndexThatAreNotOccupied.get(randomIndex))
                        .newClientEnqueue(alternativeQueue.dequeue());
            }
        }

        // adds new clients.
        for(int i = 0; i<amountOfClients; i++){
            Client aCliente = new Client();
            if(staysGivenCertainProbability( alternativeQueue.size() )) {
                alternativeQueue.enqueue(aCliente);
            }
            else {
                aBank.clientLeft();
            }
        }

    }

    private ArrayList<Integer> getAvailableCashierIndex(ArrayList<Cashier> cashiers){
        ArrayList<Integer> listOfIndex = new ArrayList<>();
        for (int i = 0; i < cashiers.size(); i++){
            if(!cashiers.get(i).isOccupied()){
                listOfIndex.add(i);
            }
        }
        return listOfIndex;
    }

    private boolean staysGivenCertainProbability(int sizeOfQueue){

        if(sizeOfQueue <= 3){
            return true;
        }
        else if(sizeOfQueue <= 8){
            return probability(0.75);
        }
        else {
            return probability(0.5);
        }
    }

    private boolean probability(double probabilityTrue)
    {
        return Math.random() >= 1.0 - probabilityTrue;
    }
}
