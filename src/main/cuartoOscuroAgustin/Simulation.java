package main.cuartoOscuroAgustin;

import struct.impl.lists.StaticList;

import java.util.Scanner;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Simulation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StaticList<String> nameOfParties = new StaticList<>();
        for(int i = 0; i< 5; i++){
            String nameOfParty;
            System.out.print("Enter name of Party "+ (i+1)+": ");
            nameOfParty = scanner.nextLine();
            nameOfParties.insertNext(nameOfParty);
        }
        VotingTable votingTable = new VotingTable(nameOfParties);
        int action;

        do{
            System.out.println("Operations:\n" +
                    " 1- New person arrives to the table\n" +
                    " 2- Person enter voting booth.\n" +
                    " 3- Person leaves voting booth with his vote.\n" +
                    " 4- Restock of all voting tickets.\n" +
                    " 5- End simulation. \n");
            System.out.print("Enter a operation: ");
            action = scanner.nextInt();

            switch (action){
                case 1:
                    votingTable.newPersonArrives();
                    System.out.println("A new person has arrived to the table.");
                    break;
                case 2:
                    votingTable.personEntersVotingBooth();
                    break;
                case 3:
                    votingTable.personLeavesVotingBooth();
                    break;
                case 4:
                    votingTable.restockTickets();
                    break;
                case 5:
                    System.out.println("Average time waited in line: "+
                            String.format( "%.2f", votingTable.getAverageTimeWaitedInLine() ));
                    System.out.println("Average time spent in dark room: "+
                            String.format( "%.2f", votingTable.getAverageTimeWaitedInVotingBooth() ));
                    VotingUrn urn = votingTable.getVotingUrn();
                    System.out.println("Winning Party: "+ urn.getNameOfWinningParty()+
                        ", amount of votes: " + urn.getAmtOfVotesOfWinningParty());
                    urn.printLast10Votes();
                    break;
                default:
                    System.out.println("Please enter a valid operation.");

            }

        }while (action != 5);
    }
}
