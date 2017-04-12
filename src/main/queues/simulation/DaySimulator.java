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

    }

    public static void main(String[] args) {
       DaySimulator daySimulator= new DaySimulator(new OneQueue());
        DaySimulator daySimulator2= new DaySimulator(new MultipleQueues());
        daySimulator.daySimulation();
        daySimulator2.daySimulation();
        System.out.println("Clients left in A strategy");
        System.out.println(daySimulator.bank.getAmountOfClientsThatLeftDueToQueue());
        System.out.println("Clients attended in A strategy");
        System.out.println(daySimulator.bank.getTotalAmountsOfClientsAttended());
        System.out.println("Clients left in B strategy");
        System.out.println(daySimulator2.bank.getAmountOfClientsThatLeftDueToQueue());
        System.out.println("Clients attended in B strategy");
        System.out.println(daySimulator2.bank.getTotalAmountsOfClientsAttended());
    }

}
