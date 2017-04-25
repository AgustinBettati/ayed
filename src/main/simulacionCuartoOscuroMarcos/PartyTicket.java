package main.simulacionCuartoOscuroMarcos;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class PartyTicket {
    private String nameOfParty;
    private int id;



    public PartyTicket(String nameOfParty) {

        int randomIndex = ThreadLocalRandom.current().nextInt(0, 1200);
        id=randomIndex;
        this.nameOfParty = nameOfParty;
    }

    public String getNameOfParty() {
        return nameOfParty;
    }

    public int getId() {
        return id;
    }
}
