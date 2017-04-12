package main.queues.simulation;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;



/**
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version 1.0
 *
 * This class is a strategy for arranging clients that are waiting within the bank.
 * It will always assign a new client the shortest queue from the 3 cashiers, and in the
 * case that two or more have the same amount, it will randomly pick one.
 */
public class MultipleQueues implements Strategy {

    @Override
    public void enqueue(Bank aBank,int amountOfClients) {
        ArrayList<Cashier> cashiers = aBank.getCashiers();

        for (int i = 0; i < amountOfClients; i++){
            Client aClient = new Client();
            Cashier bestCashier = getBestCashier(cashiers);
            if(staysGivenCertainProbability(bestCashier.amountOfClients())){
                bestCashier.newClientEnqueue(aClient);
            }
            else {
                aBank.clientLeft();
            }
        }
    }


    private Cashier getBestCashier(ArrayList<Cashier> cashiers){
        ArrayList<Integer> indexOfBestCashiers = new ArrayList<>();

        int smallestSizeOfQueue = cashiers.get(0).amountOfClients();
        indexOfBestCashiers.add(0);

        for (int i = 1; i< cashiers.size();i++){
            if(cashiers.get(i).amountOfClients() < smallestSizeOfQueue){
                smallestSizeOfQueue = cashiers.get(i).amountOfClients();
                indexOfBestCashiers.clear();
                indexOfBestCashiers.add(i);
            }
            else if(cashiers.get(i).amountOfClients() == smallestSizeOfQueue){
                indexOfBestCashiers.add(i);
            }
        }

        if (indexOfBestCashiers.size() == 1) {
            return cashiers.get(indexOfBestCashiers.get(0));
        }
        else if (indexOfBestCashiers.size() == 2) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            return cashiers.get(indexOfBestCashiers.get(randomIndex));
        }
        else {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, 2 + 1);
            return cashiers.get(indexOfBestCashiers.get(randomIndex));
        }
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
