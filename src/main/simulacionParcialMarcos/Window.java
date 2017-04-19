package main.simulacionParcialMarcos;

import struct.impl.queues.DynamicQueue;

import java.util.Random;

/**
 * Created by marcos on 19/4/17.
 */
public class Window {
    private DynamicQueue<Person> waitingPeople;
    private int amountOfMoney;
    private int freeTime;

    public Window() {
        this.waitingPeople = new DynamicQueue<Person>();
        this.amountOfMoney = 0;
        this.freeTime = 0;
    }

    public void addWaitingPerson(Person person) {
        this.waitingPeople.enqueue(person);
    }
    public void tryAttendNext(int actualTime){
        Random r= new Random();
        if (r.nextFloat()<=0.3){

            waitingPeople.dequeue().setWaitedTime(actualTime);


        }
    }
}
