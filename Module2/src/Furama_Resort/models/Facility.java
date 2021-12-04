package Furama_Resort.models;

import Furama_Resort.utils.ConstantUtil.*;

public abstract class Facility{
    private int id;
    private String code;
    private String name;
    private double areaUses;
    private double price;
    private int maxPeople;
    private RentType rentType;

    public Facility() {}
    public Facility(int id, String code, String name, double areaUses, double price, int maxPeople, RentType rentType) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.areaUses = areaUses;
        this.price = price;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAreaUses() {
        return areaUses;
    }

    public void setAreaUses(double areaUses) {
        this.areaUses = areaUses;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
