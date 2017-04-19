package main.soccerTable;

import main.queues.simulation.Strategy;
import struct.impl.stacks.LinkedStack;

/**
 * Created by marcos on 13/4/17.
 */
public class Match {
       private Team home;
       private Team away;
       private LinkedStack<Integer> possibleResults;

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
