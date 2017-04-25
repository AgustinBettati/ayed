package main.simulacionCuartoOscuroMarcos;


import struct.impl.queues.DynamicQueue;
import struct.impl.stacks.LinkedStack;
import struct.impl.stacks.StaticStack;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class VotingTable {

    private DarkRoom darkRoom;
    private DynamicQueue<Person> waitingPeople;
    private long averageWaitedTime=0;
    private LinkedStack<PartyTicket> votes;


    public VotingTable(DarkRoom darkRoom) {
        this.darkRoom = darkRoom;
        waitingPeople= new DynamicQueue<>();
        votes= new LinkedStack<>();
    }

    public void refill(){
       darkRoom.refill();
    }

    public void tryToVote(){
        if (darkRoom.isOccupied()==false&&!(waitingPeople.isEmpty())){
            darkRoom.setOccupied(true);
            Person person= waitingPeople.dequeue();
           averageWaitedTime+= person.waitedTime();
           votes.push(person.vote(darkRoom));
        }

    }





}
