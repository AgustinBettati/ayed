package main.simulacionCuartoOscuroMarcos;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class Person {
   private  Date timeWhenEntersSimulation;


    public Person() {
        this.timeWhenEntersSimulation = new Date();
    }

    public long waitedTime(){
       Date currentTime= new Date();
      return   (currentTime.getTime()-timeWhenEntersSimulation.getTime())/1000;
    }

    public PartyTicket vote(DarkRoom darkRoom){
        PartyTicket partyTicket;
        int randomIndex = ThreadLocalRandom.current().nextInt(0, 6-1);
        darkRoom.getParties().goTo(randomIndex);
        partyTicket= darkRoom.getParties().getActual().peek();
        darkRoom.getParties().getActual().pop();
        return partyTicket;
    }



}
