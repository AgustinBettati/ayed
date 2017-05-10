package main.soccerTable;

import struct.impl.stacks.DynamicStack;

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
       private DynamicStack<Integer> possibleResults;

    /**
     * Creates a Match and initializes its variables.
     * @param home
     * @param away
     */
    public Match(Team home, Team away) {
        this.home = home;
        this.away = away;
        possibleResults=new DynamicStack<>();
    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public void setPossibleResults(DynamicStack<Integer> possibleResults) {
        this.possibleResults = possibleResults;
    }

    public DynamicStack<Integer> getPossibleResults(){
        return possibleResults;
    }

}
