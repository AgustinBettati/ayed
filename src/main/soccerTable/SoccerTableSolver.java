package main.soccerTable;

import struct.impl.stacks.LinkedStack;
import java.util.ArrayList;
import java.util.HashMap;

public class SoccerTableSolver {

    ArrayList<Team> teams;
    ArrayList<Match> matches;
    HashMap<Team, Integer> currentScores;


    public SoccerTableSolver(ArrayList<Team> teams, ArrayList<Match> matches) {
        this.teams = teams;
        this.matches = matches;
        currentScores = new HashMap<>();

        for(Team team : teams){
            currentScores.put(team, 0);
        }
    }

    public ArrayList<Integer> result () {
        int i =0;
        while(i < matches.size()){

            if( matches.get(i).getPossibleResults().isEmpty() ){
                generateStackForMatch( matches.get(i) );

            }
            else {
                // Hacer peek de posible results, y ver si agregando ese resultado
                // ninguno de los dos equipos se pasa de su score posta

                //if (esta bien con el nuevo resultado){
                //    computar nuevo resultado
                //    avanzar
                // }

                // else{
                //    hacer pop
                //    loopear hast que me quede con un stack mayor a 1
                //    pop devuelta
                // }


            }
        }
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

//    private void generateStackForMatch(){
//
//        for (Match match:matches){
//            LinkedStack<Integer> possibleResults=new LinkedStack<>();
//           //crear un result
//            if (match.getAway().getScore()<3 || match.getHome().getScore()<3){
//
//                if(match.getHome().getScore() == 0 || match.getAway().getScore() == 0){
//                    if(match.getHome().getScore() == 0){
//                        possibleResults.push(2);
//                    }
//                    else {
//                        possibleResults.push(1);
//                    }
//
//                }
//                else {
//                    if (match.getHome().getScore() <= 2) {
//                        possibleResults.push(0);
//                        possibleResults.push(2);
//                    } else {
//                        possibleResults.push(0);
//                        possibleResults.push(1);
//                    }
//                }
//            }
//            else {
//                for (int i=0;i<3;i++ ){
//                    possibleResults.push(i);
//                }
//            }
//            match.setPossibleResults(possibleResults);
//        }
//
//    }

    private void generateStackForMatch(Match match){

        LinkedStack<Integer> possibleResults=new LinkedStack<>();

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
