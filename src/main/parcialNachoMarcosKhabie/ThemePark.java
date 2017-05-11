
package main.parcialNachoMarcosKhabie;

import struct.impl.lists.DynamicList;
import struct.impl.lists.StaticList;

import java.util.Random;

/**
 * @author Marcos Khabie
 */
public class ThemePark {

    private DynamicList<Client> clientsInHub;
    private StaticList<Attraction> atractions;
    private int fastPassTicketsSold;
    private int normalTicketsSold;
    private int peopleThatLeavesOneHoursBefore;
    private int peopleThatLeavesWhenClosed;
    private int peopleLeavingBeforeOneHourBefore;


    public ThemePark(StaticList<Attraction> atractions) {
        this.atractions = atractions;
        clientsInHub=new DynamicList<>();
        fastPassTicketsSold=0;
        normalTicketsSold=0;
        peopleThatLeavesOneHoursBefore =0;
        peopleThatLeavesWhenClosed=0;
        peopleLeavingBeforeOneHourBefore=0;

    }

    public int getPeopleThatLeavesOneHoursBefore() {
        return peopleThatLeavesOneHoursBefore;
    }

    public int getPeopleThatLeavesWhenClosed() {
        return peopleThatLeavesWhenClosed;
    }

    public DynamicList<Client> getClientsInHub() {
        return clientsInHub;
    }

    public int getFastPassTicketsSold() {
        return fastPassTicketsSold;
    }

    public int getNormalTicketsSold() {
        return normalTicketsSold;
    }

    private Attraction getMostPopularAttraction() {

        atractions.goTo(0);
        Attraction mostPopulraOne= atractions.getActual();

        for (int i=0;i<atractions.size();i++){
            atractions.goTo(i);
            int compare=mostPopulraOne.compareTo(atractions.getActual());
            if (compare<0){
                mostPopulraOne=atractions.getActual();
            }
        }
        return mostPopulraOne;
    }

    public void enterThemePark(Client client){
        Random random= new Random();
        int a= random.nextInt(10);
            if (a<3){
                client.buyFastPass();
                fastPassTicketsSold++;

            }
            else {
                normalTicketsSold++;
            }

        clientsInHub.insertNext(client);
    }
    public void cycle(double actualTime){

        for (int i=-1;i<5;i++) {
            enterThemePark(new Client());
        }
        clientsInHub.goTo(0);
        clientsInHub.getActualPosition();
        for (int i=0; i<clientsInHub.size();i++){
            clientsInHub.goTo(i);

            int clientDecision=clientsInHub.getActual().decide();
            if (actualTime<28800) {
                if (clientDecision < 6) {
                    goToAttraction(clientsInHub.getActual(),actualTime);
                    clientsInHub.remove();
                } else if (clientDecision < 8) {
                    leaveThepark(i, actualTime);
                    clientsInHub.remove();



                }
            }
            else {
                if (clientDecision<5){
                    leaveThepark(i,actualTime);
                    clientsInHub.remove();
                }
                else {
                    goToAttraction(clientsInHub.getActual(),actualTime);
                    clientsInHub.remove();

                }
            }

        }
    }

       public void goToAttraction(Client client,double actualTime){
        if (client.hasFastPass()&&!client.useAllFastPass()){
            if (getMostPopularAttraction().getFastPassClients().size()<20) {
                getMostPopularAttraction().getFastPassClients().enqueue(client);
                client.useFastPass();
            }
        }
        else {
            getMostPopularAttraction().getNormalClients().enqueue(client);
        }
        client.setEnqueuedTime(actualTime); //agregado


       }

       public void leaveThepark (int i, double actualTime){
        if (actualTime>28800 && actualTime<36000){
            peopleThatLeavesOneHoursBefore++;
        }
        else {
            peopleLeavingBeforeOneHourBefore++;
        }

           clientsInHub.goTo(i);
           clientsInHub.remove();

       }
       public void closePark(){
           clientsInHub.goTo(0);
           for (int i= 0; i< clientsInHub.size();i++){
               clientsInHub.goTo(i);
               clientsInHub.remove();
               peopleThatLeavesWhenClosed++;
           }
       }

    public void goOutAttraction (double actualTime){
           atractions.goTo(0);
           clientsInHub.goTo(clientsInHub.size()-1);
           for (int i=0; i<atractions.size();i++) {
               atractions.goTo(i);
               atractions.getActual().getClientsInside().goTo(0);

               for (int b = 0; b < atractions.getActual().getClientsInside().size(); b++) {
                   atractions.getActual().getClientsInside().goTo(b);
                   clientsInHub.insertNext(atractions.getActual().getClientsInside().getActual());
                   atractions.getActual().getClientsInside().remove();
               }

                if(actualTime==36000){
                    for (int b = 0; b < atractions.getActual().getFastPassClients().size(); b++) {
                        clientsInHub.insertNext(atractions.getActual().getFastPassClients().dequeue());
                    }
                    for (int c = 0; c < atractions.getActual().getNormalClients().size(); c++) {
                        clientsInHub.insertNext(atractions.getActual().getNormalClients().dequeue());
                    }
                }
           }
    }

    public StaticList<Attraction> getAtractions() {
        return atractions;
    }

    public int getPeopleLeavingBeforeOneHourBefore() {
        return peopleLeavingBeforeOneHourBefore;
    }
    public void playAll(double actualTime){
        atractions.goTo(0);

        for (int i = 0; i < atractions.size(); i++) {
            atractions.goTo(i);
            atractions.getActual().play(actualTime);
        }
    }
}

