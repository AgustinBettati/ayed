package main.simulacionParcialMarcos;

/**
 * Created by marcos on 19/4/17.
 */
public class Person {
   private int waitedTime;
    private int arrivedTime;

    public Person( int arrivedTime) {
        this.waitedTime = 0;
        this.arrivedTime = arrivedTime;
    }

    public void setWaitedTime(int actualTime){
        waitedTime= actualTime- arrivedTime;
    }

    public int getWaitedTime() {
        return waitedTime;
    }

    public int getArrivedTime() {
        return arrivedTime;
    }
}
