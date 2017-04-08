package main.stacks.parkingLot;
import struct.impl.stacks.StaticStack;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 * This class represents a parking lot that that can only store cars by piling them in a
 * narrow street.
 */
public class Parking {

    private StaticStack<Car> parkingLot;
    private double dailyRevenue;

    /**
     * Creates a parking with a max capacity of 50
     */
    public Parking() {
        parkingLot = new StaticStack<>(50);
        dailyRevenue = 0;
    }

    /**
     * If the parking is not full, the car is parked in the parking lot
     * @param aCar
     */
    public void parkCar(Car aCar){

        if(parkingLot.size() < 50){
            parkingLot.push(aCar);
        }
        else{
            throw new RuntimeException("Parking is full");
        }
    }

    /**
     * If the car is found, it is removed from the parking lot
     * @param aCar
     */
    public void removeCar(Car aCar){
        StaticStack<Car> street = new StaticStack<>(50);

        boolean carNotFound = true;
        while(carNotFound && parkingLot.size() > 0){
            if(parkingLot.peek().getLicensePlate().equals(aCar.getLicensePlate()) ){
                parkingLot.pop();
                carNotFound = false;
            }
            else{
                street.push(parkingLot.peek());
                parkingLot.pop();
            }
        }
        int amtOfCarsOnTheStreet = street.size();
        for (int i = 0; i < amtOfCarsOnTheStreet; i++){
            parkingLot.push(street.peek());
            street.pop();
        }

        if(!carNotFound){
            dailyRevenue += 5;
        }
        else{
            throw new RuntimeException("Car was not found");
        }
    }


    /**
     * Each car that leaves pays 5$.
     * This method return the amount of money gained in the current day.
     * @return
     */
    public double checkOutDailyRevenue(){
        double revenueOfTheDay = dailyRevenue;
        dailyRevenue = 0;
        return revenueOfTheDay;
    }


}
