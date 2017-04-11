package main.queues.simulation;


public interface Strategy {
    void enqueue(Bank aBank,int amountOfClients);
}
