package main.metroviasAgustin;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Client {

    private int timeWhenEntersQueue;

    public Client(int timeWhenEntersQueue) {
        this.timeWhenEntersQueue = timeWhenEntersQueue;
    }

    public int getWaitedTime(int currentTime){
        return currentTime - timeWhenEntersQueue;
    }
}
