package Furama_Resort.models;


import Furama_Resort.utils.ConstantUtil.*;

public class Villa extends Facility {
    private RoomType romType;
    private double areaPool;
    private int numberOfFloor;

    public Villa(int id, String code, String name, double areaUses, double price, int maxPeople, RentType rentType, RoomType romType, double areaPool, int numberOfFloor) {
        super(id, code, name, areaUses, price, maxPeople, rentType);
        this.romType = romType;
        this.areaPool = areaPool;
        this.numberOfFloor = numberOfFloor;
    }

    public RoomType getRomType() {
        return romType;
    }

    public void setRomType(RoomType romType) {
        this.romType = romType;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }
}
