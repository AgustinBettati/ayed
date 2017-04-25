package main.simulacionCuartoOscuroMarcos;


import struct.impl.lists.StaticList;
import struct.impl.stacks.StaticStack;

/**
 * Created by marcos on 24/4/17.
 */
public class DarkRoom {

    private StaticList<StaticStack<PartyTicket>> parties;
    private StaticList<String> nameofParties;
    private boolean isOccupied;

    public DarkRoom(StaticList<String> nameOfParties) {

        this.nameofParties=nameOfParties;
        parties= new StaticList<>(5);
        isOccupied=false;
        refill();


    }

    public StaticList<StaticStack<PartyTicket>> getParties() {
        return parties;
    }

    public StaticList<String> getNameofParties() {
        return nameofParties;
    }

    public void refill() {

        parties.goTo(0);
        nameofParties.goTo(0);
        for (int i = 0; i <=5; i++) {
            parties.goTo(i);
            nameofParties.goTo(i);
            for (int a = parties.size(); a <= 200; a++) {
                parties.getActual().push(new PartyTicket(nameofParties.getActual()));
            }

        }

    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
