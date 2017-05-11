package main.parcialNachoMarcosKhabie;

import struct.impl.lists.DynamicList;

/**
 * @author Marcos Khabie
 */
public class Result {

    private int amountOfNormalTicketsSold;
    private int amountOfFastPassSold;
    private DynamicList<Attraction> ranking;
    private double percentageOfPeopleThatLeaveWhenClosed;
    private double percentageOfPeopleThatLeaveOneHourBefore;
    private double percentageOfPeopleThatLeaveBeforeOneHourBefore;
    private double totalPeople;



//    public Result(int amountOfNormalTicketsSold, int amountOfFastPassSold, DynamicSortedList<Attraction> rankingWait,int percentageOfPeopleThatLeaveWhenClosed,in) {
//        this.amountOfNormalTicketsSold = amountOfNormalTicketsSold;
//        this.amountOfFastPassSold = amountOfFastPassSold;
//        ranking=rankingWait;
//    }

    public Result(int amountOfNormalTicketsSold, int amountOfFastPassSold, DynamicList<Attraction> ranking, double percentageOfPeopleThatLeaveWhenClosed, double percentageOfPeopleThatLeaveOneHourBefore, double percentageOfPeopleThatLeaveBeforeOneHourBefore,double totalPeople) {
        this.amountOfNormalTicketsSold = amountOfNormalTicketsSold;
        this.amountOfFastPassSold = amountOfFastPassSold;
        this.ranking = ranking;
        this.percentageOfPeopleThatLeaveWhenClosed = percentageOfPeopleThatLeaveWhenClosed;
        this.percentageOfPeopleThatLeaveOneHourBefore = percentageOfPeopleThatLeaveOneHourBefore;
        this.percentageOfPeopleThatLeaveBeforeOneHourBefore = percentageOfPeopleThatLeaveBeforeOneHourBefore;
        this.totalPeople=totalPeople;
    }

    public int amountOfMoneyForFastpass(){
        return amountOfFastPassSold*60;
    }
    public int amountOfMoneyForNormalPass(){
        return amountOfNormalTicketsSold*35;
    }

    public int getAmountOfNormalTicketsSold() {
        return amountOfNormalTicketsSold;
    }

    public int getAmountOfFastPassSold() {
        return amountOfFastPassSold;
    }

    public DynamicList<Attraction> getRanking() {
        return ranking;
    }

    public double getPercentageOfPeopleThatLeaveWhenClosed() {
        return percentageOfPeopleThatLeaveWhenClosed;
    }

    public double getPercentageOfPeopleThatLeaveOneHourBefore() {
        return percentageOfPeopleThatLeaveOneHourBefore;
    }

    public double getPercentageOfPeopleThatLeaveBeforeOneHourBefore() {
        return percentageOfPeopleThatLeaveBeforeOneHourBefore;
    }

    public double getTotalPeople() {
        return totalPeople;
    }
}
