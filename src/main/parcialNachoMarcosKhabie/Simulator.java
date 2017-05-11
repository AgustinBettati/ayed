package main.parcialNachoMarcosKhabie;

import struct.impl.lists.DynamicList;
import struct.impl.lists.StaticList;

import java.util.Random;

/**
 * @author Marcos Khabie
 */
public class Simulator {

    private ThemePark themePark;

    public Simulator(StaticList<Attraction> attractions, int amountOpened) {

        Random r= new Random();
        StaticList<Attraction> openedAttractions= new StaticList<>(amountOpened);
        for (int  i = 0;  i < amountOpened;  i++) {
            attractions.goTo(r.nextInt(attractions.size()));
            openedAttractions.insertNext(attractions.getActual());
            attractions.remove();

        }

      themePark=new ThemePark(openedAttractions);

    }

    public Result run() {

        double timer;
     for(timer=0; timer<36000;timer+=60){

         themePark.cycle(timer);
         if (timer==300){
             themePark.playAll(timer);
         }
         else if (timer%300==0){
             themePark.goOutAttraction(timer);
             themePark.playAll(timer);
         }

     }
        themePark.goOutAttraction(timer);
        themePark.closePark();
int a=0;

     return   new Result(themePark.getNormalTicketsSold(),themePark.getFastPassTicketsSold(),generateRanking(),generataPercentageWhenClosed(),generataPercentageOneHourBefore(),generataPercentageBeforeOneHourBefore(),generataTotalPeople());
    }

    private DynamicList<Attraction> generateRanking(){
        themePark.getAtractions().goTo(0);
        DynamicList<Attraction> result= new DynamicList<>();

        for (int i=1; i< themePark.getAtractions().size();i++){
            themePark.getAtractions().goTo(i);
            Attraction attraction= themePark.getAtractions().getActual();
            themePark.getAtractions().goTo(i-1);
            if (themePark.getAtractions().getActual().calculateAverageWait()>attraction.calculateAverageWait()){
                result.insertPrev(attraction);
            }
        }
return result;
    }

    public double generataPercentageOneHourBefore(){
        return (((double)themePark.getPeopleThatLeavesOneHoursBefore())/((double)themePark.getFastPassTicketsSold()+(double)themePark.getNormalTicketsSold()))*100;

    }
    public double generataPercentageWhenClosed(){
        return (((double)themePark.getPeopleThatLeavesWhenClosed())/((double)themePark.getFastPassTicketsSold()+(double)themePark.getNormalTicketsSold()))*100;

    }
    public double generataPercentageBeforeOneHourBefore(){
        return  (((double)themePark.getPeopleLeavingBeforeOneHourBefore())/((double)themePark.getFastPassTicketsSold()+(double)themePark.getNormalTicketsSold()))*100;

    }
    public double generataTotalPeople(){
        return  (double)((themePark.getPeopleLeavingBeforeOneHourBefore())+themePark.getPeopleThatLeavesOneHoursBefore()+themePark.getPeopleThatLeavesWhenClosed());
    }



}
