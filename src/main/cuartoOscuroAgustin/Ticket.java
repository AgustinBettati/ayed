package main.cuartoOscuroAgustin;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Ticket {

    private String id;
    private String nameOfParty;

    public Ticket(String nameOfParty,String id) {
        this.id = id;
        this.nameOfParty = nameOfParty;
    }

    public String getNameOfParty() {
        return nameOfParty;
    }

    public String toString(){
        return "ID: " + id+", Party: " + nameOfParty;
    }
}
