package main.parcialMarcosKhabie;



/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class Account implements Comparable<Account> {
    private String sucursal;
    private int number;

    public Account(String sucursal, int number) {
        this.sucursal = sucursal;
        this.number = number;
    }

    public String getSucursal() {
        return sucursal;
    }

    public int getNumber() {
        return number;
    }


    @Override
    public int compareTo(Account o) {
        if (number<o.number){
            return -1;
        }
        else if (number>o.number){
            return 1;
        }
        else {
            return 0;
        }
    }
}
