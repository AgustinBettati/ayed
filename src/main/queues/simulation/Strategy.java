package main.queues.simulation;


/**
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version 1.0
 *
 * The capacity of arranging the flow of new clients that enter a bank.
 */
public interface Strategy {
    /**
     * Enqueues a given amount of clients to a bank.
     * @param aBank
     * @param amountOfClients
     */
    void enqueue(Bank aBank,int amountOfClients);
}
