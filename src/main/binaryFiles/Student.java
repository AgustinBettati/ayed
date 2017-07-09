package main.binaryFiles;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Student {
    private int dni;
    private String name; //15 caracteres.
    private String surname;// 15 caracteres.
    private double average;
    private boolean isActive;


    public Student(int dni, String surname,String name, double average, boolean isActive) {
        this.dni = dni;
        this.name = adapt(name,15);
        this.surname = adapt(surname,15);
        this.average = average;
        this.isActive = isActive;


    }



    public int getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getAverage() {
        return average;
    }

    public boolean isActive() {
        return isActive;
    }

    private String adapt(String s, int amount){
        if (s.length()>amount){
            return s.substring(0,amount);
        }
        else {
            for (int i = s.length(); i < amount; i++) {
                s+= " ";


            }
            return s;
        }



    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
