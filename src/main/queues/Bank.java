package main.queues;

/**
 * Created by marcos on 11/4/17.
 */
public class Bank {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Bank(Strategy strategy) {
        this.strategy = strategy;
    }
}
