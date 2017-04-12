package main.queues.simulation;

import struct.impl.queues.DynamicQueue;
import java.util.ArrayList;


public class Bank {
    private DynamicQueue<Client> alternativeQueue;
    private ArrayList<Cashier> cashiers;
    private Strategy strategy;
    private int amountOfClientsThatLeftDueToQueue;

    public Bank(Strategy strategy) {
        this.strategy = strategy;
        alternativeQueue = new DynamicQueue<>();
        cashiers = new ArrayList<>();
        cashiers.add(new Cashier(30, 90));
        cashiers.add(new Cashier(30, 120));
        cashiers.add(new Cashier(30, 150));
        amountOfClientsThatLeftDueToQueue = 0;

    }

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

    public int getAmountOfClientsThatLeftDueToQueue() {
        return amountOfClientsThatLeftDueToQueue;
    }

    public int getTotalAmountsOfClientsAttended(){
        int result=0;
        for (Cashier c:cashiers) {
            result+=c.getClientsAttended();
        }
        return result;
    }
}
