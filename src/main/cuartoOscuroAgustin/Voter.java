package main.cuartoOscuroAgustin;


import java.util.Date;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Voter {
    private Date timeWhenEntersTable;
    private Date timeWhenEntersVotingBooth;
    private Ticket vote;

    public Voter(){
        timeWhenEntersTable = new Date();
        vote = null;
        timeWhenEntersVotingBooth = null;
    }

    public double secondsWaitedInLine(){
        Date currentTime = new Date();
        return (currentTime.getTime() - timeWhenEntersTable.getTime()) / 1000;
    }

    public double secondsSpentInVotingBooth(){
        Date currentTime = new Date();
        return (currentTime.getTime() - timeWhenEntersVotingBooth.getTime()) / 1000;
    }

    public void entersVotingBooth(){
        timeWhenEntersVotingBooth = new Date();
    }


    public boolean hasVoted(){
        if(vote == null){
            return false;
        }
        return true;
    }

    public void makesVote(Ticket aVote){
        vote = aVote;
    }

    public Ticket getVote(){
        return vote;
    }
}
