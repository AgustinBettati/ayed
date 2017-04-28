package main.parcialBettatiAgustin;

import struct.impl.lists.StaticList;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Agustin Bettati
 */
public class ThemePark {
    private StaticList<Attraction> availableAttractions;
    private StaticList<Client> hub;
    private int amtOfNormalPassPurchase;
    private int amtOfFastPassPurchase;
    private int amtOfClientsThatEnter;
    private int amtOfPeopleThatLeaveDuringNormalHours;
    private int amtOfPeopleThatLeaveLastHour;
    private int amtOfPeopleThatLeaveWhenCloses;


    public ThemePark(StaticList<Attraction> attractions, int amtOfAvailableAttractions){
        hub = new StaticList<>();
        amtOfFastPassPurchase = 0;
        amtOfNormalPassPurchase = 0;
        amtOfClientsThatEnter =0;
        amtOfPeopleThatLeaveDuringNormalHours = 0;
        amtOfPeopleThatLeaveLastHour = 0;
        amtOfPeopleThatLeaveWhenCloses = 0;

        availableAttractions = new StaticList<>(amtOfAvailableAttractions);
        StaticList<Integer> indexOfOpenAttractions = new StaticList<>(amtOfAvailableAttractions);

        while(indexOfOpenAttractions.size() < amtOfAvailableAttractions){
            int randomIndex = ThreadLocalRandom.current().nextInt(0, 7 + 1);
            if( ! listContainsIndex(indexOfOpenAttractions, randomIndex) ){
                indexOfOpenAttractions.insertNext(randomIndex);
            }
        }

        for (int i = 0; i < indexOfOpenAttractions.size(); i++){
            indexOfOpenAttractions.goTo(i);
            attractions.goTo( indexOfOpenAttractions.getActual() );
            Attraction availableAttraction = attractions.getActual();
            availableAttractions.insertNext(availableAttraction);
        }
    }

    public void normalCycle(int time){
        createFiveNewClients();
        makeMovementOfClientsInHubNormalHours( time );

        attractionsTakeAction(time);
    }

    public void lastHour(int time){

        for (int i = 0; i < hub.size(); i++){
            hub.goTo(i);
            if(probability(0.5)){
                Attraction bestAttraction = getMostPopularAttraction();
                bestAttraction.recievesNewClient( hub.getActual() ,time);
            }
            else{
                amtOfPeopleThatLeaveLastHour++;
            }
        }
        hub = new StaticList<>();

        attractionsTakeAction(time);
    }

    public void closePark(){
        int amtOfPeopleLeftInPark = 0;

        for(int i = 0; i< availableAttractions.size(); i++){
            availableAttractions.goTo(i);
            amtOfPeopleLeftInPark += availableAttractions.getActual().getAmountOfClientsInAttraction();
        }

        amtOfPeopleLeftInPark += hub.size();

        amtOfPeopleThatLeaveWhenCloses = amtOfPeopleLeftInPark;

    }

    private void attractionsTakeAction(int time) {
        int size = availableAttractions.size();
        for(int i = 0; i < availableAttractions.size(); i++){
            availableAttractions.goTo(i);
            Attraction attraction = availableAttractions.getActual();
            attraction.takeAction(time);

            StaticList<Client> finishedClients = attraction.getClientsThatFinishedRide();

            for (int j = 0; j< finishedClients.size(); j++){
                finishedClients.goTo(j);

                hub.insertNext(finishedClients.getActual());

            }
        }
    }

    private void createFiveNewClients(){
        for (int i = 0; i< 5; i++){
            Client newClient = new Client();

            if (probability(0.3)){
                newClient.buysFastPath();
                amtOfFastPassPurchase++;
            }
            else {
                amtOfNormalPassPurchase++;
            }

            hub.insertNext(newClient);
        }
        amtOfClientsThatEnter += 5;
    }

    private void makeMovementOfClientsInHubNormalHours(int time){
        StaticList<Client> newHub = new StaticList<>();

        for (int i = 0; i < hub.size(); i++){
            hub.goTo(i);
            int randomNumber = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            if(randomNumber <= 2){
                newHub.insertNext(hub.getActual());
            }
            else if(randomNumber <= 4 && randomNumber > 2){
                amtOfPeopleThatLeaveDuringNormalHours++;
            }
            else{
                Attraction bestAttraction = getMostPopularAttraction();
                bestAttraction.recievesNewClient( hub.getActual(), time );
            }
        }
        hub = newHub;
    }

    private Attraction getMostPopularAttraction() {
        availableAttractions.goTo(0);
        int maxPopularity = availableAttractions.getActual().getPopularity();
        StaticList<Integer> indexOfBestAttractions = new StaticList<>();
        indexOfBestAttractions.insertNext(0);

        for(int i = 1; i < availableAttractions.size(); i++){
            availableAttractions.goTo(i);
            Attraction attraction = availableAttractions.getActual();
            int popularity = attraction.getPopularity();
            if(popularity > maxPopularity){
                indexOfBestAttractions = new StaticList<>();
                indexOfBestAttractions.insertNext(i);
            }
            else if(popularity == maxPopularity){
                indexOfBestAttractions.insertNext(i);
            }
        }
        int randomIndex = ThreadLocalRandom.current().nextInt(0, indexOfBestAttractions.size());
        indexOfBestAttractions.goTo(randomIndex);

        availableAttractions.goTo( indexOfBestAttractions.getActual() );

        return availableAttractions.getActual();
    }

    public int getAmtOfNormalPassPurchase() {
        return amtOfNormalPassPurchase;
    }

    public int getAmtOfFastPassPurchase() {
        return amtOfFastPassPurchase;
    }

    public int getAmtOfClientsThatEnter() {
        return amtOfClientsThatEnter;
    }

    public int getAmtOfPeopleThatLeaveDuringNormalHours() {
        return amtOfPeopleThatLeaveDuringNormalHours;
    }

    public int getAmtOfPeopleThatLeaveLastHour() {
        return amtOfPeopleThatLeaveLastHour;
    }

    public int getAmtOfPeopleThatLeaveWhenCloses() {
        return amtOfPeopleThatLeaveWhenCloses;
    }


    private boolean listContainsIndex(StaticList<Integer> indexOfOpenAttractions, int randomIndex) {

        for(int i = 0; i < indexOfOpenAttractions.size(); i++){
            indexOfOpenAttractions.goTo(i);
            if(indexOfOpenAttractions.getActual() == randomIndex){
                return true;
            }
        }
        return false;
    }

    private boolean probability(double probabilityTrue) {
        return Math.random() >= 1.0 - probabilityTrue;
    }


}
