package main.cuartoOscuroAgustin;

import struct.impl.lists.StaticList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class VotingUrn {

    private HashMap<String, Integer> countOfEachParty;
    private StaticList<Ticket> listOfVotes;

    public VotingUrn(){
        listOfVotes = new StaticList<>();
        countOfEachParty = new HashMap<>();
    }

    public void storeVote(Ticket aVote){

        listOfVotes.goTo(listOfVotes.size());
        listOfVotes.insertPrev(aVote);
        String nameOfParty = aVote.getNameOfParty();
        if(countOfEachParty.containsKey(nameOfParty)){
            countOfEachParty.put(nameOfParty, countOfEachParty.get(nameOfParty)+ 1);
        }
        else {
            countOfEachParty.put(nameOfParty, 1);
        }
    }

    public String getNameOfWinningParty(){
        String winningParty = "";
        int maxPoints = -1;
        for (Map.Entry<String, Integer> entry : countOfEachParty.entrySet()) {
            if(entry.getValue() > maxPoints){
                winningParty = entry.getKey();
                maxPoints = entry.getValue();
            }
        }
        return winningParty;
    }

    public int getAmtOfVotesOfWinningParty(){
        int maxVotes = -1;
        for (Map.Entry<String, Integer> entry : countOfEachParty.entrySet()) {
            if(entry.getValue() > maxVotes){
                maxVotes = entry.getValue();
            }
        }
        return maxVotes;
    }

    public void printLast10Votes(){
        int i = listOfVotes.size()-1;
        int j = 0;
        while(i >=0 && j <10){
            listOfVotes.goTo(i);
            System.out.println(listOfVotes.getActual());
            j++;
            i--;
        }
    }




}
