package main.soccerTable;


import main.util.Scanner;
import java.util.ArrayList;
/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class is used to examine the functioning of the soccer table solver.
 */
public class Main {


    public static void main(String[] args) {
//        Team sevilla= new Team("Sevilla",3);
//        Team valencia= new Team("Valencia",4);
//        Team madrid= new Team("Madrid",4);
//        Team barca= new Team("Barca",6);
//        Team betis= new Team("Betis",3);
//        Team deportivo= new Team("Depo",4);
//
//        Match match1= new Match(barca,deportivo);
//        Match match2= new Match(valencia,deportivo);
//        Match match3= new Match(valencia,barca);
//        Match match4= new Match(betis,sevilla);
//        Match match5= new Match(madrid,deportivo);
//        Match match6= new Match(sevilla,madrid);
//        Match match7= new Match(betis,deportivo);
//        Match match8= new Match(madrid,betis);
//        Match match9= new Match(betis,valencia);
//
//        ArrayList<Match>matches= new ArrayList<>();
//        matches.add(match1);
//        matches.add(match2);
//        matches.add(match3);
//        matches.add(match4);
//        matches.add(match5);
//        matches.add(match6);
//        matches.add(match7);
//        matches.add(match8);
//        matches.add(match9);
//
//        ArrayList<Team> teams= new ArrayList<>();
//        teams.add(barca);
//        teams.add(madrid);
//        teams.add(sevilla);
//        teams.add(valencia);
//        teams.add(betis);
//        teams.add(deportivo);

        int amountOfTeams = Scanner.getInt("Enter the amount of teams: \n");

        ArrayList<Team> teams= new ArrayList<>();
        for (int i =0; i< amountOfTeams;i++){
            String nameOfTeam = Scanner.getString("Name of team: ");
            int scoreOfTheTeam = Scanner.getInt("Score of the team: ");
            System.out.println();
            Team newTeam = new Team(nameOfTeam, scoreOfTheTeam);
            teams.add(newTeam);
        }

        int amountOfMatches = Scanner.getInt("Enter the amount of matches: ");

        ArrayList<Match> matches =new ArrayList<>();
        for(int i = 0; i< amountOfMatches; i++){
            System.out.println("Enter new match.");
            String nameOfHome = Scanner.getString("Home team: ");
            String nameOfAway = Scanner.getString("Away team: ");
            Match newMatch = new Match(findTeam(nameOfHome, teams),findTeam(nameOfAway, teams));
            matches.add(newMatch);
        }
        System.out.println();
        SoccerTableSolver soccerTableSolver= new SoccerTableSolver(teams,matches);
        for (Integer i: soccerTableSolver.results()) {
            System.out.print(i+"  ");
        }
    }

    private static Team findTeam(String nameOfTeam, ArrayList<Team> teams){
        for(Team aTeam : teams){
            if(aTeam.getName().equals(nameOfTeam)){
                return aTeam;
            }
        }
        throw new RuntimeException("name of team was not found");

    }


}
