package main.stacks.parkingLot;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * Represents a Car with its respective license plate, color, model, and factory.
 */
public class Car {

    private String licensePlate;
    private String model;
    private String color;
    private String factoryName;

    public Car(String licensePlate, String model, String color, String factoryName) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.color = color;
        this.factoryName = factoryName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }
}
