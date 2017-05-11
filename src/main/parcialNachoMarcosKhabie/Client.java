package main.parcialNachoMarcosKhabie;

import java.util.Random;

/**
 * @author Marcos Khabie
 */
public class Client {

    private boolean fastPass;
    private int fastPassUses;
    private double enqueuedTime;
    private double playedTime;

    public Client() {
        this.fastPass = false;
        fastPassUses=0;
    }


    public boolean hasFastPass(){
        return fastPass;
    }

    public int decide() {
        Random random = new Random();
        int decision = random.nextInt(10);
        return decision;
    }

    public void buyFastPass(){
        fastPass=true;
        fastPassUses=8;

    }
//        if (decision<6){
//            goToAttraction(attractions);
//        }
//        else if(decision<8){
//            leaveThepark();
//        }
//
//    }


    public boolean isFastPass() {
        return fastPass;
    }

    public int getFastPassUses() {
        return fastPassUses;
    }

    public double getEnqueuedTime() {
        return enqueuedTime;
    }

    public void setEnqueuedTime(double enqueuedTime) {
        this.enqueuedTime = enqueuedTime;
    }

    public double getPlayedTime() {
        return playedTime;
    }

    public void setPlayedTime(double playedTime) {
        this.playedTime = playedTime;
    }

    public void useFastPass() {
        this.fastPassUses--;
    }
    public double waitedTime(){
        return playedTime-enqueuedTime;
    }
    public boolean useAllFastPass(){
        if (fastPassUses==0){
            return true;
        }
        return false;
    }
}
