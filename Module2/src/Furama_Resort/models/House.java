package Furama_Resort.models;

import Furama_Resort.utils.ConstantUtil.*;

public class House extends Facility{
    private RoomType roomType;
    private int numberOfFloor;

    public House(RoomType roomType) {
        this.roomType = roomType;
    }

    public House(int id, String code, String name, double areaUses, double price, int maxPeople, RentType rentType, RoomType roomType) {
        super(id, code, name, areaUses, price, maxPeople, rentType);
        this.roomType = roomType;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }
}
