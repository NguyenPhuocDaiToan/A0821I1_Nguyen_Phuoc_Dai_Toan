package Furama_Resort.models;

import Furama_Resort.utils.ConstantUtil;

public class Room extends Facility{
    private String freeService;

    public Room(int id, String code, String name, double areaUses, double price, int maxPeople, ConstantUtil.RentType rentType, String freeService) {
        super(id, code, name, areaUses, price, maxPeople, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
}
