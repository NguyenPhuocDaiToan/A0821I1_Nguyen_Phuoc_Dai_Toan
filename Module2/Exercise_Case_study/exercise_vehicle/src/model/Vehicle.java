package model;

public abstract class Vehicle {
    private String numberPlate;
    private String manufacturer;
    private int year;
    private String owner;

    public Vehicle(String numberPlate, String manufacturer, int year, String owner) {
        this.numberPlate = numberPlate;
        this.manufacturer = manufacturer;
        this.year = year;
        this.owner = owner;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String toString() {
        return String.format("%s,%s,%s,%s", getNumberPlate(), getManufacturer(), getYear(), getOwner());
    }
}
