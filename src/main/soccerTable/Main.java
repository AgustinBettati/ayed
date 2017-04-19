package main.soccerTable;

import java.util.ArrayList;

/**
 * Created by marcos on 19/4/17.
 */
public class Main {


    public static void main(String[] args) {
//        Team deportivo=new Team("Deportivo",11);
//        Team betis= new Team("Betis",9);
//        Team sevilla= new Team("Sevilla",6);
//        Team atlMadrid= new Team("Atl Madrid",6);
//        Team barca= new Team("Barca",5);
//        Team AtlBilbao= new Team("Atl Bilbao", 4);
//        Team madrid= new Team("Madrid",2);
//        Team espanyol= new Team("Espanyol",2);
//        Team valencia= new Team("Valencia",1);
//        Team realSociedad= new Team("Real Sociedad",1);
//
//        Match match1= new Match(deportivo,realSociedad);
//        Match match2= new Match(barca,atlMadrid);
//        Match match3= new Match(AtlBilbao,espanyol);
//        Match match4= new Match(atlMadrid,madrid);
//        Match match5= new Match(deportivo,madrid);
//        Match match6= new Match(betis,deportivo);
//        Match match7= new Match(realSociedad,espanyol);
//        Match match8= new Match(valencia,deportivo);
//        Match match9= new Match(deportivo,barca);
//        Match match10= new Match(madrid,barca);
//        Match match11= new Match(espanyol,sevilla);
//        Match match12= new Match(sevilla,atlMadrid);
//        Match match13= new Match(madrid,betis);
//        Match match14= new Match(valencia,AtlBilbao);
//        Match match15= new Match(betis,AtlBilbao);
//        Match match16= new Match(valencia,atlMadrid);
//        Match match17= new Match(realSociedad,betis);
//        Match match18= new Match(barca,betis);
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
//        matches.add(match10);
//        matches.add(match11);
//        matches.add(match12);
//        matches.add(match13);
//        matches.add(match14);
//        matches.add(match15);
//        matches.add(match16);
//        matches.add(match17);
//        matches.add(match18);
//
//        ArrayList<Team> teams= new ArrayList<>();
//        teams.add(barca);
//        teams.add(realSociedad);
//        teams.add(deportivo);
//        teams.add(madrid);
//        teams.add(sevilla);
//        teams.add(atlMadrid);
//        teams.add(AtlBilbao);
//        teams.add(betis);
//        teams.add(espanyol);
//        teams.add(valencia);


        Team sevilla= new Team("Sevilla",3);
        Team valencia= new Team("Valencia",4);
        Team madrid= new Team("Madrid",4);
        Team barca= new Team("Barca",6);
        Team betis= new Team("Betis",3);
        Team deportivo= new Team("Depo",4);

        Match match1= new Match(barca,deportivo);
        Match match2= new Match(valencia,deportivo);
        Match match3= new Match(valencia,barca);
        Match match4= new Match(betis,sevilla);
        Match match5= new Match(madrid,deportivo);
        Match match6= new Match(sevilla,madrid);
        Match match7= new Match(betis,deportivo);
        Match match8= new Match(madrid,betis);
        Match match9= new Match(betis,valencia);

        ArrayList<Match>matches= new ArrayList<>();
        matches.add(match1);
        matches.add(match2);
        matches.add(match3);
        matches.add(match4);
        matches.add(match5);
        matches.add(match6);
        matches.add(match7);
        matches.add(match8);
        matches.add(match9);

        ArrayList<Team> teams= new ArrayList<>();
        teams.add(barca);
        teams.add(madrid);
        teams.add(sevilla);
        teams.add(valencia);
        teams.add(betis);
        teams.add(deportivo);

        SoccerTableSolver soccerTableSolver= new SoccerTableSolver(teams,matches);
        for (Integer i: soccerTableSolver.result()) {
            System.out.print(i+"  ");
        }
    }


}
