package main.cuartoOscuroMarcos;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class Person {
   private  Date timeWhenEntersSimulation;
   private Date timeWhenEntersDarkRoom;


    public Person() {
        this.timeWhenEntersSimulation = new Date();
    }

    public long waitedTime(){
       Date currentTime= new Date();
      return   (currentTime.getTime()-timeWhenEntersSimulation.getTime())/1000;
    }
    public long lastedTime(){
        Date currentTime= new Date();
        return   (currentTime.getTime()-timeWhenEntersDarkRoom.getTime())/1000;
    }


    public PartyTicket vote(DarkRoom darkRoom){
        PartyTicket partyTicket;
        int randomIndex = ThreadLocalRandom.current().nextInt(0, 5);
        darkRoom.getParties().goTo(randomIndex);
        partyTicket= darkRoom.getParties().getActual().peek();
        darkRoom.getParties().getActual().pop();
        return partyTicket;
    }

    public void setTimeWhenEntersDarkRoom(Date timeWhenEntersDarkRoom) {
        this.timeWhenEntersDarkRoom = timeWhenEntersDarkRoom;
    }
}
