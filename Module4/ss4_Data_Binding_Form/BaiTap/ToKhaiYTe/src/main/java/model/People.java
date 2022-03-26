package model;

import java.util.Date;

public class People {
    private String name;
    private String birthday;
    private boolean gender;
    private String country;
    private String CMND;
    private String travel;

    public People() {
    }

    public People(String name, String birthday, boolean gender, String country, String CMND, String travel) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.country = country;
        this.CMND = CMND;
        this.travel = travel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }
}
