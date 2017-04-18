package main.soccerTable;

import struct.impl.LinkedBinaryTree;
import struct.impl.stacks.LinkedStack;

import java.util.ArrayList;

/**
 * Created by marcos on 13/4/17.
 */
public class SoccerTableSolver {

    ArrayList<Team> teams;
    ArrayList<Match> matches;


    public SoccerTableSolver(ArrayList<Team> teams, ArrayList<Match> matches) {
        this.teams = teams;
        this.matches = matches;
        generateStackForMatch();
    }

    public ArrayList<Integer> result () {
        int i =0;
        while(i < matches.size()){
            Match currentMatch = matches.get(i);
            int resultOfMatch = currentMatch.getPossibleResults().peek();
            if(resultOfMatch == 0)

        }
    }

    private void generateStackForMatch(){

        for (Match match:matches){
            LinkedStack<Integer> possibleResults=new LinkedStack<>();
           //crear un result
            if (match.getAway().getScore()<3 || match.getHome().getScore()<3){

                if(match.getHome().getScore() == 0 || match.getAway().getScore() == 0){
                    if(match.getHome().getScore() == 0){
                        possibleResults.push(2);
                    }
                    else {
                        possibleResults.push(1);
                    }

                }
                else {
                    if (match.getHome().getScore() <= 2) {
                        possibleResults.push(0);
                        possibleResults.push(2);
                    } else {
                        possibleResults.push(0);
                        possibleResults.push(1);
                    }
                }
            }
            else {
                for (int i=0;i<3;i++ ){
                    possibleResults.push(i);
                }
            }
            match.setPossibleResults(possibleResults);
        }

    }

}
