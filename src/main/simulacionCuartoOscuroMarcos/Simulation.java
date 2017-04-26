package main.simulacionCuartoOscuroMarcos;

import struct.impl.lists.StaticList;

import java.util.Scanner;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class Simulation {

    public static void main(String[] args) {
        StaticList<String> names= new StaticList<>(5);
        String cfk= "FPV";
        String macri="PRO";
        String massa="+A";
        String delCaño="frente izquierda";
        String stolbizer="progresistas";
        names.goTo(0);
        names.insertNext(cfk);
        //names.goTo(1);
        names.insertNext(macri);
        //names.goTo(2);
        names.insertNext(massa);
        //names.goTo(3);
        names.insertNext(delCaño);
        //names.goTo(4);
        names.insertNext(stolbizer);
        DarkRoom darkRoom= new DarkRoom(names);
        VotingTable votingTable= new VotingTable(darkRoom);
        while (true){
            Scanner scanner= new Scanner(System.in);
            System.out.println("enter action:");
            System.out.println("1.add person\n"+ ("2.person enter dark room\n"+"3.person go out dark room\n"+"4.refill\n"+ "5. finish"));
            int action= scanner.nextInt();
            switch (action){
                case 1:
                    votingTable.aPersonArrives();
                    break;
                case 2:
                    votingTable.tryToVote();
                    break;
                case 3:
                    votingTable.personGoOut();
                    break;
                case 4:
                    votingTable.refill();
                    break;
                case 5:
                    System.out.println("average wait:"+votingTable.getAverageWaitedTime() );
                    System.out.println("---------------");
                    System.out.println("average lasted: "+ votingTable.getAverageLastedTime());
                    System.out.println("---------------");
                    System.out.println("last 10:");
                    votingTable.lastTen();
                    System.out.println("---------------");
                    System.out.println(" VOTES: ");
                    System.out.println();
                    votingTable.countVotes();


                    System.exit(0);





            }
        }

    }
}
