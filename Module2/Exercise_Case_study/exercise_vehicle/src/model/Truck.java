package model;

public class Truck extends Vehicle{
    private double load;

    public Truck(String numberPlate, String manufacturer, int year, String owner, double load) {
        super(numberPlate, manufacturer, year, owner);
        this.load = load;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public String toString() {
        return super.toString() + "," + getLoad();
    }
}
