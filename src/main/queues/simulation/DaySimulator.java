package main.queues.simulation;

/**
 * Created by marcos on 11/4/17.
 */
public class DaySimulator {
    private Bank bank;
    private ClientSimulator clientSimulator;

    public DaySimulator( Strategy strategy) {
        this.bank = new Bank(strategy);
        clientSimulator=new ClientSimulator();

    }

    public void daySimulation(){
        for (int timer=0;timer<=18000;timer++){
            bank.getCashiers().get(0).takeAction(timer);
            bank.getCashiers().get(1).takeAction(timer);
            bank.getCashiers().get(2).takeAction(timer);
            int amountOfClients=clientSimulator.amountOfNewClients(timer);
           if (amountOfClients>0){
               bank.enqueueNewClients(amountOfClients);
           }
        }
        for ()

    }

}
