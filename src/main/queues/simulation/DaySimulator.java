package main.queues.simulation;

/**
 * Created by marcos on 11/4/17.
 */
public class DaySimulator {
    private Bank bank;
    private ClientSimulator clientSimulator;

    public DaySimulator( Strategy strategy, int minRange, int maxRange) {
        this.bank = new Bank(strategy);
        clientSimulator=new ClientSimulator(minRange, maxRange);

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
        bank.closeBankAndAttendLastClients();
    }

    public static void main(String[] args) {
        int minRange = 4;
        int maxRange = 4;
        DaySimulator daySimulatorOneQueue= new DaySimulator(new OneQueue(), minRange,maxRange);
        DaySimulator daySimulatorMultipleQueue= new DaySimulator(new MultipleQueues(),minRange,maxRange);
        daySimulatorOneQueue.daySimulation();
        daySimulatorMultipleQueue.daySimulation();

        int totalAumountOfClientsA= daySimulatorOneQueue.bank.getAmountOfClientsThatLeftDueToQueue() + daySimulatorOneQueue.bank.getAmountsOfClientsAttended();
        int deficiencyA= (daySimulatorOneQueue.bank.getAmountOfClientsThatLeftDueToQueue()*100)/totalAumountOfClientsA;
        int eficiencyA= 100-deficiencyA;

        int totalAumountOfClientsB= daySimulatorMultipleQueue.bank.getAmountOfClientsThatLeftDueToQueue() + daySimulatorMultipleQueue.bank.getAmountsOfClientsAttended();
        int deficiencyB= (daySimulatorMultipleQueue.bank.getAmountOfClientsThatLeftDueToQueue()*100)/totalAumountOfClientsB;
        int eficiencyB= 100-deficiencyB;

        System.out.println("The results show the percentage of amount of clients attended over the total \namount that went to the bank.");
        System.out.println("The amount of people that enter the bank every 1.5 minutes ranges from "+ minRange+ " to "+ maxRange);
        System.out.println();
        System.out.println("eficiency in A strategy: " + eficiencyA+ "%");
        System.out.println();
        System.out.println("eficiency in B strategy: " + eficiencyB+ "%" );
    }

}
