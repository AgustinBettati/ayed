package main.cuartoOscuroAgustin;

import struct.impl.StaticList;
import struct.impl.stacks.LinkedStack;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class VotingBooth {
    private StaticList<String> nameOfParties;
    private StaticList<LinkedStack<Ticket>> listOfStacks;
    private Voter voter;

    public VotingBooth(StaticList<String> nameOfParties){
        this.nameOfParties = nameOfParties;
        voter = null;
        listOfStacks = new StaticList<>();
        for(int i = 0 ; i< 5; i++){
            listOfStacks.insertNext(new LinkedStack<Ticket>());
        }
        restockTickets();
    }

    public void restockTickets(){

        for (int i =0; i< 5; i++){
            listOfStacks.goTo(i);
            LinkedStack<Ticket> stackOfTickets = listOfStacks.getActual();

            nameOfParties.goTo(i);

            while (stackOfTickets.size() <200){
                stackOfTickets.push(new Ticket(nameOfParties.getActual(), generateID()));
            }

        }
    }

    private String generateID(){
        String result = "";
        for(int i = 0; i< 4; i++){
            result += "" + ThreadLocalRandom.current().nextInt(0, 9 + 1);
        }
        return result;
    }

    public boolean isOccupied(){
        if(voter == null){
            return false;
        }
        return true;
    }

    public Voter personLeaves(){
        if(voter == null){
            throw new RuntimeException("No voter was in the booth");
        }
        Voter aux = voter;
        voter = null;
        return aux;
    }

    public void personEnters(Voter aVoter){
        if(isOccupied()){
            throw new RuntimeException("There is already a person voting");
        }
        voter = aVoter;
        while(!voter.hasVoted()){
            int randomIndex = ThreadLocalRandom.current().nextInt(0, 4 + 1);
            listOfStacks.goTo(randomIndex);
            if(!listOfStacks.getActual().isEmpty()){
                voter.makesVote( listOfStacks.getActual().peek() );
                listOfStacks.getActual().pop();
            }
        }

    }


}
