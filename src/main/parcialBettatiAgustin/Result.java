package main.parcialBettatiAgustin;

import struct.impl.lists.StaticList;

/**
 * @author Agustin
 */
public class Result {
    private int amtOfNormalTicketsSold;
    private int amtOfFastPassTicketsSold;

    private double amtThatLeaveInNormalHours;
    private double amtThatLeavesInLastHour;
    private double amtThatLeavesWhenCloses;
    private StaticList<Attraction> orderListAverageWaitingTime;

    public Result(int amtOfNormalTicketsSold, int amtOfFastPassTicketsSold, double amtThatLeaveInNormalHours, double amtThatLeavesInLastHour, double amtThatLeavesWhenCloses, StaticList<Attraction> orderListAverageWaitingTime) {
        this.amtOfNormalTicketsSold = amtOfNormalTicketsSold;
        this.amtOfFastPassTicketsSold = amtOfFastPassTicketsSold;
        this.amtThatLeaveInNormalHours = amtThatLeaveInNormalHours;
        this.amtThatLeavesInLastHour = amtThatLeavesInLastHour;
        this.amtThatLeavesWhenCloses = amtThatLeavesWhenCloses;
        this.orderListAverageWaitingTime = orderListAverageWaitingTime;
    }

    public int getAmtOfNormalTicketsSold() {
        return amtOfNormalTicketsSold;
    }

    public int getAmtOfFastPassTicketsSold() {
        return amtOfFastPassTicketsSold;
    }

    public double revenueOfNormalTicket(){
        return amtOfNormalTicketsSold * 35;
    }

    public double revenueOfFastPassTicket(){
        return amtOfFastPassTicketsSold * 60;
    }

    public double percentageOfPeopleThatLeaveInNormalHours(){
        return amtThatLeaveInNormalHours / (double)(amtOfNormalTicketsSold+amtOfFastPassTicketsSold) * 100.0;
    }

    public double percentageOfPeopleThatLeaveInLastHour(){
        return amtThatLeavesInLastHour / (double)(amtOfNormalTicketsSold+amtOfFastPassTicketsSold) * 100.0;
    }

    public double percentageOfPeopleThatLeaveWhenCloses(){
        return amtThatLeavesWhenCloses / (double)(amtOfNormalTicketsSold+amtOfFastPassTicketsSold) * 100.0;
    }



    public StaticList<Attraction> getOrderListAverageWaitingTime() {
        return orderListAverageWaitingTime;
    }
}
