package main.cuartoOscuroMarcos;


import struct.impl.queues.DynamicQueue;
import struct.impl.stacks.DynamicStack;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class VotingTable {

    private DarkRoom darkRoom;
    private DynamicQueue<Person> waitingPeople;
    private long averageWaitedTime;
    private DynamicStack<PartyTicket> votes;
    private HashMap<String,Integer> counter;
    private long averageLastedTime;


    public VotingTable(DarkRoom darkRoom) {
        this.darkRoom = darkRoom;
        waitingPeople= new DynamicQueue<>();
        votes= new DynamicStack<>();
        averageWaitedTime=0;
        averageLastedTime=0;
        counter=new HashMap<>();
        darkRoom.getNameofParties().goTo(0);
        for(int i=0;i<5;i++){
            darkRoom.getNameofParties().goTo(i);
            counter.put(darkRoom.getNameofParties().getActual(),0);
        }
    }

    public void refill(){
       darkRoom.refill();
    }

    public void tryToVote(){
        if (!darkRoom.isOccupied()&&!(waitingPeople.isEmpty())){
            darkRoom.setOccupied(true);
            darkRoom.personThatIsInside= waitingPeople.dequeue();
            darkRoom.personThatIsInside.setTimeWhenEntersDarkRoom(new Date());
           averageWaitedTime+= darkRoom.personThatIsInside.waitedTime();
        }

    }

    public void personGoOut(){
        if (darkRoom.isOccupied()){
            darkRoom.setOccupied(false);
           votes.push(darkRoom.personThatIsInside.vote(darkRoom));
           averageLastedTime+= darkRoom.personThatIsInside.lastedTime();


        }
    }

    public void aPersonArrives(){
        waitingPeople.enqueue(new Person());
    }

    public long getAverageWaitedTime() {
        return averageWaitedTime;
    }

    public long getAverageLastedTime() {
        return averageLastedTime;
    }

    public void lastTen(){
        DynamicStack<PartyTicket> aux= new DynamicStack<>();
        try {
            for (int i = 0; i < 10; i++) {
                if (votes.peek()==null)throw new NullPointerException();
                aux.push(votes.peek());
                System.out.println("partido:   "+votes.peek().getNameOfParty() + "     ID   " +votes.peek().getId());
                votes.pop();

            }
            for (int i = 0; i < 10; i++) {
                votes.push(aux.peek());
                aux.pop();
            }
        }
        catch (NullPointerException e){
            for (int i = 0; i <=aux.size()-1; i++) {
                votes.push(aux.peek());
                aux.pop();
            }
            System.out.println("less than 10 votes");
        }
    }

    public void countVotes(){


        while (!votes.isEmpty()){
            System.out.println(votes.peek().getNameOfParty());
            for(Map.Entry<String,Integer> element : counter.entrySet()){

                if (element.getKey().equals(votes.peek().getNameOfParty())){
                    element.setValue(element.getValue()+1);
                }
            }
            votes.pop();
        }
        for(Map.Entry<String,Integer> element : counter.entrySet()){
            System.out.println("  partido:  "+element.getKey()+"  votos:  "+ element.getValue());
            System.out.println("--------------------");
        }
    }

}
