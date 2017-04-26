package main.cuartoOscuroMarcos;


import struct.impl.lists.StaticList;
import struct.impl.stacks.StaticStack;

/**
 * Created by marcos on 24/4/17.
 */
public class DarkRoom {

    private StaticList<StaticStack<PartyTicket>> parties;
    private StaticList<String> nameofParties;
    private boolean isOccupied;
    public Person personThatIsInside;

    public DarkRoom(StaticList<String> nameOfParties) {

        this.nameofParties=nameOfParties;
        parties= new StaticList<>(5);
        parties.goTo(0);
        for (int i = 0; i<5;i++){
            parties.insertNext(new StaticStack<PartyTicket>(200));
        }
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
        if (!isOccupied()){

            parties.goTo(0);
            nameofParties.goTo(0);
            for (int i = 0; i <5; i++) {
                parties.goTo(i);
                nameofParties.goTo(i);
                int amountOfAdded=0;
                for (int a = parties.getActual().size(); a < 200; a++,amountOfAdded++) {
                    parties.getActual().push(new PartyTicket(nameofParties.getActual()));

                }

                System.out.println("For the party"+ nameofParties.getActual() +"it has been added " + (amountOfAdded)+ " tickets");
                System.out.println("--------------------------");

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
