package main.simulacionParcialMarcos;

import struct.impl.queues.DynamicQueue;

import java.util.Random;

/**
 * Created by marcos on 19/4/17.
 */
public class Window {
    private DynamicQueue<Person> waitingPeople;
    private int amountOfPeopleAttended;
    private int freeTime;
    private int peoplesDelay;

    public Window() {
        this.waitingPeople = new DynamicQueue<Person>();
        this.amountOfPeopleAttended = 0;
        this.freeTime = 0;
        this.peoplesDelay=0;
    }

    public DynamicQueue<Person> getWaitingPeople() {
        return waitingPeople;
    }

    public int getAmountOfPeopleAttended() {
        return amountOfPeopleAttended;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public int getPeoplesDelay() {
        return peoplesDelay;
    }

    public void addWaitingPerson(Person person) {
        this.waitingPeople.enqueue(person);
    }

    public void tryAttendNext(int actualTime){
        Random r= new Random();
        if (r.nextFloat()<=0.3){

            if (!waitingPeople.isEmpty()) {

                Person person = waitingPeople.dequeue();
                person.setWaitedTime(actualTime);
                peoplesDelay += person.getWaitedTime();
                amountOfPeopleAttended++;
            }

        }

    }
    public void attendNext(int actualTime){

            Person person = waitingPeople.dequeue();
            person.setWaitedTime(actualTime);
            peoplesDelay += person.getWaitedTime();
            amountOfPeopleAttended++;

    }

    public boolean thereArePeopleWaiting(){
            if (waitingPeople.isEmpty()){
                return false;
            }
            return true;

        }

    public int getAverageWait(){
        return peoplesDelay/amountOfPeopleAttended;
    }

   public double getEarnings(){
        return amountOfPeopleAttended*0.7;
    }

    public void checkIfFree(){
        if (waitingPeople.isEmpty()){
            freeTime+=10;
        }
    }


}

