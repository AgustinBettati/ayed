package main.queues.simulation;

import struct.impl.queues.DynamicQueue;
import java.util.ArrayList;

/**
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version 1.0
 *
 * This class represents a bank and its interaction with clients.
 */
public class Bank {
    private DynamicQueue<Client> alternativeQueue;
    private ArrayList<Cashier> cashiers;
    private Strategy strategy;
    private int amountOfClientsThatLeftDueToQueue;
    private int amountOfClientsAttended;


    /**
     * Creates a bank with a certain strategy.
     * @param strategy
     */
    public Bank(Strategy strategy) {
        this.strategy = strategy;
        alternativeQueue = new DynamicQueue<>();
        cashiers = new ArrayList<>();
        cashiers.add(new Cashier(this,30, 90));
        cashiers.add(new Cashier(this,30, 120));
        cashiers.add(new Cashier(this,30, 150));
        amountOfClientsThatLeftDueToQueue = 0;
        amountOfClientsAttended = 0;

    }

    /**
     * Enqueues a certain amount of clients to the bank.
     * @param amountOfNewClients
     */
    public void enqueueNewClients(int amountOfNewClients){
        strategy.enqueue(this, amountOfNewClients);
    }

    public DynamicQueue<Client> getAlternativeQueue() {
        return alternativeQueue;
    }

    public ArrayList<Cashier> getCashiers() {
        return cashiers;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void clientLeft(){
        amountOfClientsThatLeftDueToQueue++;
    }
    public void clientWasAttended(){
        amountOfClientsAttended++;
    }

    public int getAmountOfClientsThatLeftDueToQueue() {
        return amountOfClientsThatLeftDueToQueue;
    }

    /**
     * When the banks ends its labour day, this method makes sure that all remaining clients
     * are attended.
     */
    public void closeBankAndAttendLastClients(){
        int remainingClients = 0;
        for(Cashier cashier: cashiers){
            remainingClients += cashier.amountOfClients();
        }
        remainingClients += alternativeQueue.size();

        amountOfClientsAttended += remainingClients;

    }

    public int getAmountsOfClientsAttended(){
        return amountOfClientsAttended;
    }
}
