package main.parcialBettatiAgustin;

import struct.impl.lists.StaticList;

import java.util.Scanner;

/**
 * @author Agustin Bettati
 */
public class Simulator {


    public Result run() {
        StaticList<Attraction> attractions = new StaticList<>();
        Attraction attraction1 = new Attraction("Chipmunk Treasure", 8);
        Attraction attraction2 = new Attraction("Munchkin Island", 4);
        Attraction attraction3 = new Attraction("Dinosaur Land", 6);
        Attraction attraction4 = new Attraction("Go Go Karts", 6);
        Attraction attraction5 = new Attraction("Rock n Roller", 15);
        Attraction attraction6 = new Attraction("Princess Castle", 9);
        Attraction attraction7 = new Attraction("Splash Mount", 12);
        Attraction attraction8 = new Attraction("Space Xtreme", 12);

        attractions.insertNext(attraction1);
        attractions.insertNext(attraction2);
        attractions.insertNext(attraction3);
        attractions.insertNext(attraction4);
        attractions.insertNext(attraction5);
        attractions.insertNext(attraction6);
        attractions.insertNext(attraction7);
        attractions.insertNext(attraction8);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount of available attractions: ");
        int amtOfAttractions = scanner.nextInt();

        ThemePark themePark = new ThemePark(attractions, amtOfAttractions);

        // i represents minutes
        for(int i =0; i <= 600; i++){

            if(i <= 540){
                themePark.createFiveNewClients();
                themePark.makeMovementOfClientsInHubNormalHours( i );
                themePark.attractionsTakeAction( i );
            }

            else{
                themePark.lastHour(i);
            }
        }
        themePark.closePark();



        return new Result(themePark.getAmtOfNormalPassPurchase(),
                themePark.getAmtOfFastPassPurchase(),
                themePark.getAmtOfPeopleThatLeaveDuringNormalHours(),
                themePark.getAmtOfPeopleThatLeaveLastHour(),
                themePark.getAmtOfPeopleThatLeaveWhenCloses(), null);
    }

}
