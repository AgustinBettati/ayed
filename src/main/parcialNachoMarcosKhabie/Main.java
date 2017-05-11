package main.parcialNachoMarcosKhabie;

import struct.impl.lists.StaticList;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Marcos Khabie
 */
public class Main {



    public static void main(String[] args) {
       StaticList<Attraction> atractions= new StaticList<>(8);
        atractions.insertNext(new Attraction("Chipmunk Treasure", 8));
        atractions.insertNext(new Attraction("Munchin island", 4));
        atractions.insertNext(new Attraction("CDinosaur Land", 6));
        atractions.insertNext(new Attraction("Go Go Karts", 6));
        atractions.insertNext(new Attraction("Rock n Roller", 15));
        atractions.insertNext(new Attraction("Princess castle", 9));
        atractions.insertNext(new Attraction("Splash Mount", 12));
        atractions.insertNext(new Attraction("Space Extreme", 12));
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter a number of opened Atrractions between 4-8");

        Simulator simulator = new Simulator(atractions,scanner.nextInt());
        // TODO may add simulation parameters before running
        Result result=simulator.run();
        System.out.println("Amount of Normal Tickets Sold:\n ");

        System.out.println(""+ result.getAmountOfNormalTicketsSold());
        System.out.println("-----------------");
        System.out.println("Amount of FastPass Tickets Sold: \n");
        System.out.println(result.getAmountOfFastPassSold());

        System.out.println("Amount of money gain due to Normal Tickets Sold: \n");
        System.out.println(result.amountOfMoneyForNormalPass());
        System.out.println("Amount of money gain due to FastPass Tickets Sold: \n");
        System.out.println(result.amountOfMoneyForFastpass());

        System.out.println("Percentage of clients that leave before 18hs: \n");
        System.out.println(result.getPercentageOfPeopleThatLeaveBeforeOneHourBefore() + "%");
        System.out.println("Percentage of people that leave between 18hs ans 19hs: \n");
        System.out.println(result.getPercentageOfPeopleThatLeaveOneHourBefore() + "%");
        System.out.println("Percentage of people that leave when closed: \n");
        System.out.println(result.getPercentageOfPeopleThatLeaveWhenClosed()+ "%");
        System.out.println("Ranking: ");
        result.getRanking().goTo(0);
        for (int i = 0; i <result.getRanking().size() ; i++) {
            result.getRanking().goTo(i);
            System.out.println(""+i+result.getRanking().getActual().getName());
        }

     System.out.println(result.getTotalPeople());

    }

}
