package main.soccerTable;

import struct.impl.stacks.DynamicStack;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class solves the problem.
 *
 */

public class SoccerTableSolver {

    private ArrayList<Team> teams;
    private ArrayList<Match> matches;
    private HashMap<Team, Integer> currentScores;

    /**
     * Creates a SoccerTableSolver and initializes its variables.
     * @param teams
     * @param matches
     */
    public SoccerTableSolver(ArrayList<Team> teams, ArrayList<Match> matches) {
        this.teams = teams;
        this.matches = matches;
        currentScores = new HashMap<>();

        for(Team team : teams){
            currentScores.put(team, 0);
        }
    }

    /**
     * Returns the results of all the matches in the following the initial order.
     * @return
     */
    public ArrayList<Integer> results() {
        int i =0;
        while(i < matches.size()){

            if( matches.get(i).getPossibleResults().isEmpty() ){
                generateStackForMatch( matches.get(i) );

            }
            else {
                // Hacer peek de posible results, y ver si agregando ese resultado
                // ninguno de los dos equipos se pasa de su score posta
                int possibleResult=matches.get(i).getPossibleResults().peek();

                if (newResultIsValid(matches.get(i),possibleResult)){
                    computeNewResult(matches.get(i),possibleResult);
                    i++;
                }
                else{
                    matches.get(i).getPossibleResults().pop();
                    if (matches.get(i).getPossibleResults().isEmpty()){
                        i--;
                        while(matches.get(i).getPossibleResults().size() <= 1){
                            popPosibleResult(matches.get(i));
                            i--;
                        }
                        popPosibleResult(matches.get(i));
                    }

                }

            }
        }
        ArrayList<Integer> result= new ArrayList<>();
        for (Match match:matches) {

            result.add(match.getPossibleResults().peek());

        }
        return result;
    }

    private boolean newResultIsValid(Match aMatch, int result){
        if(result == 1){
            return currentScores.get(aMatch.getHome()) + 3 <= aMatch.getHome().getScore();
        }
        else if (result == 2){
            return currentScores.get(aMatch.getAway()) + 3 <= aMatch.getAway().getScore();
        }
        else{
            return ( currentScores.get(aMatch.getHome()) + 1 <= aMatch.getHome().getScore() &&
                    currentScores.get(aMatch.getAway()) + 1 <= aMatch.getAway().getScore() );
        }
    }

    private void computeNewResult(Match aMatch , int result){
        if(result == 1){
            int previousScore = currentScores.get(aMatch.getHome());
            currentScores.put(aMatch.getHome(), previousScore + 3);
        }
        else if (result == 2){
            int previousScore = currentScores.get(aMatch.getAway());
            currentScores.put(aMatch.getAway(), previousScore + 3);
        }
        else{
            int previousScoreOfHome = currentScores.get(aMatch.getHome());
            int previousScoreOfAway = currentScores.get(aMatch.getAway());

            currentScores.put(aMatch.getHome(), previousScoreOfHome + 1);
            currentScores.put(aMatch.getAway(), previousScoreOfAway + 1);
        }
    }

    private void popPosibleResult(Match aMatch){
        int resultThatIsBeingPopped = aMatch.getPossibleResults().peek();
        if(resultThatIsBeingPopped == 1){
            int previousScore = currentScores.get(aMatch.getHome());
            currentScores.put(aMatch.getHome(), previousScore - 3);
        }
        else if (resultThatIsBeingPopped == 2){
            int previousScore = currentScores.get(aMatch.getAway());
            currentScores.put(aMatch.getAway(), previousScore - 3);
        }
        else{
            int previousScoreOfHome = currentScores.get(aMatch.getHome());
            int previousScoreOfAway = currentScores.get(aMatch.getAway());

            currentScores.put(aMatch.getHome(), previousScoreOfHome - 1);
            currentScores.put(aMatch.getAway(), previousScoreOfAway - 1);
        }

        aMatch.getPossibleResults().pop();

    }

    private void generateStackForMatch(Match match){

        DynamicStack<Integer> possibleResults=new DynamicStack<>();

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
