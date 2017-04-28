package main.parcialBettatiAgustin;
/**
 * @author Agustin
 */
public class Main {

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        Result result = simulator.run();

        System.out.println("Normal tickets sold: " + result.getAmtOfNormalTicketsSold());
        System.out.println("FastPass tickets sold: " + result.getAmtOfFastPassTicketsSold());

        System.out.println("Revenue of normal tickets: " + result.revenueOfNormalTicket());
        System.out.println("Revenue of FastPass tickets: " + result.revenueOfFastPassTicket());


        System.out.println("Percentage of people that leave in normal hours: " + result.percentageOfPeopleThatLeaveInNormalHours());
        System.out.println("Percentage of people that leave in last hour: " + result.percentageOfPeopleThatLeaveInLastHour());
        System.out.println("Percentage of people that leave when closes: " + result.percentageOfPeopleThatLeaveWhenCloses());
    }

}
