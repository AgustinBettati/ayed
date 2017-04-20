package main.soccerTable;

import struct.impl.stacks.LinkedStack;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class represents a match between two teams.
 */

public class Match {
       private Team home;
       private Team away;
       private LinkedStack<Integer> possibleResults;

    /**
     * Creates a Match and initializes its variables.
     * @param home
     * @param away
     */
    public Match(Team home, Team away) {
        this.home = home;
        this.away = away;
        possibleResults=new LinkedStack<>();
    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public void setPossibleResults(LinkedStack<Integer> possibleResults) {
        this.possibleResults = possibleResults;
    }

    public LinkedStack<Integer> getPossibleResults(){
        return possibleResults;
    }

}
