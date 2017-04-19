package main.metroviasAgustin;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Simulation {


    public static void main(String[] args) {

        Service metrovia = new Service(5);

        for(int i = 0; i <= 57600; i+= 10){

            if(i <= 57570) {
                metrovia.newCicle(i);
            }
            else{
                metrovia.lastCicles(i);
            }
        }

        metrovia.getAverageTimeWaited(0);
    }
}
