package main.simulacionParcialMarcos;

import java.util.Random;

/**
 * Created by marcos on 19/4/17.
 */
public class DaySimulator {
//    int timer;
//    int endTime;
//    public DaySimulator(int endTime) {
//       timer=0;
//       this.endTime=endTime;
//    }

    private Metrovias metrovias;
    private int timer;

    public DaySimulator(Metrovias metrovias) {
        this.metrovias = metrovias;
    }

    public void DaySimulator(){

        for(timer=0; timer<=metrovias.getWorkingTimeDuration();timer+=10){
            cycle();






        }

    }

    public void cycle(){
        Random r= new Random();
        for (int i=0; i<=4; i++){

            int window= r.nextInt(metrovias.getWindows().size()-1);
            metrovias.getWindows().goTo(window);
            metrovias.getWindows().getActual().addWaitingPerson(new Person(timer));

        }
         metrovias.getWindows().goTo(0);
        for (int i=0; i>metrovias.getWindows().size();i++){

            metrovias.getWindows().getActual().tryAttendNext(timer);
            metrovias.getWindows().goNext();

        }


    }
}
