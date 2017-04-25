package main.simulacionParcialMarcos;

/**
 * @author Marcos Khabie
 * @version 1.0
 *
 * A class that represents a Person.
 */
public class Person {
   private int waitedTime;
    private int arrivedTime;

    /**
     * A constructor that creates a person initializating its variables.
     * @param arrivedTime
     */
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
