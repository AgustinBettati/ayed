package main.parcialBettatiAgustin;
/**
 * @author Agustin Bettati
 */
public class Client {
    private int amtOfFastPass;
    private int timeWhenEntersNormalQueue;
    private boolean usedNormalQueue;

    public Client(){
        amtOfFastPass = 0;
        timeWhenEntersNormalQueue = 0;
        usedNormalQueue = false;
    }

    public boolean usedNormalQueue(){
        return usedNormalQueue;
    }
    public void entersNormalQueue(int time){
        usedNormalQueue= true;
        timeWhenEntersNormalQueue = time;
    }

    public int timeWaitedInNormalQueue(int time){
        usedNormalQueue = false;
        return time - timeWhenEntersNormalQueue;
    }
    public void buysFastPath(){
        amtOfFastPass = 10;
    }

    public void goesToAFastPass(){
        amtOfFastPass--;
    }

    public boolean hasFastPass(){
        if(amtOfFastPass >= 1){
            return true;
        }
        return false;
    }


}
