package main.stockLightBulbs;



/**
 * Created by marcos on 22/4/17.
 */
public class LightBulb implements Comparable<LightBulb> {

    private String code;
    private int watts;
    private String type;
    private int amount;

    public LightBulb(String code, int watts, String type, int amount) {
        this.code = code;
        this.watts = watts;
        this.type = type;
        this.amount = amount;
    }

    public LightBulb(String code) {
        this.code = code;
    }


    public String getCode() {
        return code;
    }

    public int getWatts() {
        return watts;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int compareTo(LightBulb x) {
        if (this.code.compareTo(x.code)<0){
            return -1;
        }
        else if (this.code.compareTo(x.code)==0)
            return 0;
        else
            return 1;
    }
}
