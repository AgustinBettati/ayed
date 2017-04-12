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
       DaySimulator daySimulatorA= new DaySimulator(new OneQueue());
        DaySimulator daySimulatorB= new DaySimulator(new MultipleQueues());
        daySimulatorA.daySimulation();
        daySimulatorB.daySimulation();

        int totalAumountOfClientsA= daySimulatorA.bank.getAmountOfClientsThatLeftDueToQueue() + daySimulatorA.bank.getTotalAmountsOfClientsAttended();
        int deficiencyA= (daySimulatorA.bank.getAmountOfClientsThatLeftDueToQueue()*100)/totalAumountOfClientsA;
        int eficiencyA= 100-deficiencyA;

        int totalAumountOfClientsB= daySimulatorB.bank.getAmountOfClientsThatLeftDueToQueue() + daySimulatorB.bank.getTotalAmountsOfClientsAttended();
        int deficiencyB= (daySimulatorB.bank.getAmountOfClientsThatLeftDueToQueue()*100)/totalAumountOfClientsB;
        int eficiencyB= 100-deficiencyB;

        System.out.println("eficiency in A strategy");
        System.out.println(eficiencyA + " %");
        System.out.println("eficiency in B strategy");
        System.out.println(eficiencyB + " %");
    }

}
