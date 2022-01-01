package model;

import common.AppConstant.*;


public class Car extends Vehicle{
    private int numberSeat;
    private TypeCar typeCar;

    public Car(String numberPlate, String manufacturer, int year, String owner, int numberSeat, TypeCar typeCar) {
        super(numberPlate, manufacturer, year, owner);
        this.numberSeat = numberSeat;
        this.typeCar = typeCar;
    }

    public int getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(int numberSeat) {
        this.numberSeat = numberSeat;
    }

    public TypeCar getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(TypeCar typeCar) {
        this.typeCar = typeCar;
    }

    public String toString() {
        return super.toString() + "," + String.format("%s,%s", getNumberSeat(), getTypeCar());
    }
}
