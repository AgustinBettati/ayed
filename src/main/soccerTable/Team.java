package main.soccerTable;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class represents a soccer team.
 */
public class Team {
    String name;
    int score;

    /**
     * Creates a Team and initializes its variables.
     * @param name
     * @param score
     */
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
