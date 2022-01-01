package model;

public class Motor extends Vehicle{
    private double wattage;

    public Motor(String numberPlate, String manufacturer, int year, String owner, double wattage) {
        super(numberPlate, manufacturer, year, owner);
        this.wattage = wattage;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    public String toString() {
        return super.toString() + "," + getWattage();
    }
}
