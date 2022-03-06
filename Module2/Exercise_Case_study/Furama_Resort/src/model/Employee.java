package model;

import util.ConstantUtil.*;

public class Employee extends Person {
    private Degree degree;
    private Position position;
    private double salary;

    public Employee() {

    }

    public Employee(int id, String code, String name, Gender gender, String birthday, String phone, String email, String address, Degree degree, Position position, double salary) {
        super(id, code, name, gender, birthday, phone, email, address);
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return getId() + "," + getCode() + "," + getName() + "," + getGender() + "," + getBirthday() + ","
                + getPhone() + "," + getEmail() + "," + getAddress() + "," + degree + "," + position + "," + salary;
    }
}
