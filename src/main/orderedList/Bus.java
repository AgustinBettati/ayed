package main.orderedList;

import java.io.Serializable;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This is class is used to represent a bus.
 */
public class Bus implements Comparable<Bus>, Serializable{

    private int lineNumber;
    private int localNumber;
    private int amtOfSeats;
    private boolean seatsForDisabled;

    public Bus(int lineNumber, int localNumber, int amtOfSeats, boolean seatsForDisabled) {
        this.lineNumber = lineNumber;
        this.localNumber = localNumber;
        this.amtOfSeats = amtOfSeats;
        this.seatsForDisabled = seatsForDisabled;
    }

    public Bus(int lineNumber, int localNumber){
        this.lineNumber = lineNumber;
        this.localNumber = localNumber;
    }

    @Override
    public int compareTo(Bus o) {
        if(this.lineNumber > o.lineNumber){
            return 1;
        }
        else if(this.lineNumber < o.lineNumber){
            return -1;
        }
        else{
            if(this.localNumber > o.localNumber){
                return 1;
            }
            else if(this.localNumber < o.localNumber){
                return -1;
            }
            else
                return 0;
        }
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getLocalNumber() {
        return localNumber;
    }

    public int getAmtOfSeats() {
        return amtOfSeats;
    }

    public boolean hasSeatsForDisabled() {
        return seatsForDisabled;
    }

    public String toString(){
        return "Line number: " + lineNumber + ", local number: " + localNumber + ", amount of seats: " + amtOfSeats + ", for disabled: " + seatsForDisabled;
     }

}
