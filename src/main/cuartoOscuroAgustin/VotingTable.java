package main.cuartoOscuroAgustin;

import struct.impl.StaticList;
import struct.impl.queues.StaticQueue;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class VotingTable {
    private StaticQueue<Voter> queue;
    private VotingBooth booth;
    private StaticList<Double> timeWaitedByEachVoterInLine;
    private StaticList<Double> timeWaitedByEachVoterInVotingBooth;
    private VotingUrn votingUrn;

    public VotingTable(StaticList<String> nameOfParties) {
        queue = new StaticQueue<>(10);
        booth = new VotingBooth(nameOfParties);
        timeWaitedByEachVoterInLine = new StaticList<>(10);
        timeWaitedByEachVoterInVotingBooth = new StaticList<>();
        votingUrn = new VotingUrn();
    }

    public void newPersonArrives(){
        queue.enqueue(new Voter());
    }

    public void personEntersVotingBooth(){
        if(!queue.isEmpty() && !booth.isOccupied()){
            Voter voterThatEntersBooth = queue.dequeue();
            booth.personEnters(voterThatEntersBooth);
            voterThatEntersBooth.entersVotingBooth();
            timeWaitedByEachVoterInLine.insertNext(voterThatEntersBooth.secondsWaitedInLine());
        }
    }

    public void personLeavesVotingBooth(){
        if(booth.isOccupied()){
            Voter voterThatLeaves = booth.personLeaves();
            timeWaitedByEachVoterInVotingBooth.insertNext(
                    voterThatLeaves.secondsSpentInVotingBooth());
            votingUrn.storeVote(voterThatLeaves.getVote());
        }
    }

    public void restockTickets() {
        booth.restockTickets();
    }

    public double getAverageTimeWaitedInLine() {
        double sumOfWaitedTime= 0;
        for (int i = 0; i < timeWaitedByEachVoterInLine.size(); i++){
            timeWaitedByEachVoterInLine.goTo(i);
            sumOfWaitedTime += timeWaitedByEachVoterInLine.getActual();
        }

        return sumOfWaitedTime/ (double) timeWaitedByEachVoterInLine.size();
    }

    public double getAverageTimeWaitedInVotingBooth() {
        double sumOfWaitedTime= 0;
        for (int i = 0; i < timeWaitedByEachVoterInVotingBooth.size(); i++){
            timeWaitedByEachVoterInVotingBooth.goTo(i);
            sumOfWaitedTime += timeWaitedByEachVoterInVotingBooth.getActual();
        }

        return sumOfWaitedTime/ (double) timeWaitedByEachVoterInVotingBooth.size();
    }

    public VotingUrn getVotingUrn() {
        return votingUrn;
    }
}
