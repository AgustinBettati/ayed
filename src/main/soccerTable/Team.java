package main.soccerTable;

/**
 * Created by marcos on 13/4/17.
 */
public class Team {
    String name;
    int score;

    public Team(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }


    public int getScore() {
        return score;
    }


}
