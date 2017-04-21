package main.metroviasAgustin;

/**
 * @author Agustin Bettati
 * @version 1.0
 *
 * Representation of a client
 */
public class Client {

    private int timeWhenEntersQueue;

    public Client(int timeWhenEntersQueue) {
        this.timeWhenEntersQueue = timeWhenEntersQueue;
    }

    /**
     * Returns the amount of time that has passed since the client enters the queue given
     * a current time
     * @param currentTime
     * @return
     */
    public int getWaitedTime(int currentTime){
        return currentTime - timeWhenEntersQueue;
    }
}
